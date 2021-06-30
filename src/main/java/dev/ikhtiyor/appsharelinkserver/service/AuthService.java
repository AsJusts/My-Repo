package dev.ikhtiyor.appsharelinkserver.service;

import dev.ikhtiyor.appsharelinkserver.entity.User;
import dev.ikhtiyor.appsharelinkserver.payload.ApiResponse;
import dev.ikhtiyor.appsharelinkserver.payload.UserDto;
import dev.ikhtiyor.appsharelinkserver.repository.UserRepository;
import dev.ikhtiyor.appsharelinkserver.utils.Constants;
import dev.ikhtiyor.appsharelinkserver.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

/**
 * Created by Ikhtiyor Khaitov
 * 15/05/21
 **/

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByPhoneNumber(s).orElseThrow(() -> new UsernameNotFoundException(s));
    }

    public ApiResponse editUser(Integer id, UserDto request) {
        try {
            Optional<User> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();

                user.setFirstName(request.getFirstName() == null ? user.getFirstName() : request.getFirstName());
                user.setLastName(request.getLastName() == null ? user.getLastName() : request.getLastName());
                user.setPhoneNumber(request.getPhoneNumber() == null ? user.getPhoneNumber() : request.getPhoneNumber());

                if (request.getPassword() != null || request.getPassword().length() > 0) {
                    if (passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
                        user.setPassword(passwordEncoder.encode(request.getPassword()));
                    }
                }

                userRepository.save(user);
                return ResponseUtils.success(Constants.SUCCESS_EDIT);
            } else {
                return ResponseUtils.error(Constants.USER_NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseUtils.error(Constants.SYSTEM_ERROR);
        }
    }
}
