package dev.ikhtiyor.appsharelinkserver.controller;

import dev.ikhtiyor.appsharelinkserver.entity.User;
import dev.ikhtiyor.appsharelinkserver.payload.ApiResponse;
import dev.ikhtiyor.appsharelinkserver.payload.ResToken;
import dev.ikhtiyor.appsharelinkserver.payload.UserDto;
import dev.ikhtiyor.appsharelinkserver.repository.UserRepository;
import dev.ikhtiyor.appsharelinkserver.security.CurrentUser;
import dev.ikhtiyor.appsharelinkserver.security.JwtTokenProvider;
import dev.ikhtiyor.appsharelinkserver.service.AuthService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ikhtiyor Khaitov
 * 15/05/21
 **/

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    final
    AuthenticationManager authenticationManager;

    final
    JwtTokenProvider jwtTokenProvider;

    final
    UserRepository userRepository;

    final
    AuthService authService;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserRepository userRepository, AuthService authService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
        this.authService = authService;
    }

    @PostMapping("/signIn")
    public HttpEntity<?> login(@RequestBody UserDto request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getPhoneNumber(),
                request.getPassword()
        ));
        String token = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new ResToken(token));
    }

    @PostMapping("/edit/{id}")
    public HttpEntity<?> editUserDetail(
            @PathVariable Integer id,
            @RequestBody UserDto request
    ) {
        ApiResponse apiResponse = authService.editUser(id, request);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponse);
    }

    @GetMapping("/me")
    public HttpEntity<?> userMe(@CurrentUser User user) {
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new UserDto(
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getPhoneNumber(),
                    "",
                    "",
                    ""
            ));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("CONFLICT");
        }
    }
}
