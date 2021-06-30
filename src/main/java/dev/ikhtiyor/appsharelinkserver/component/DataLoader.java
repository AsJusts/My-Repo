package dev.ikhtiyor.appsharelinkserver.component;

import dev.ikhtiyor.appsharelinkserver.entity.User;
import dev.ikhtiyor.appsharelinkserver.repository.RoleRepository;
import dev.ikhtiyor.appsharelinkserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${spring.datasource.initialization-mode}")
    private String initialization;

    @Override
    public void run(String... args) throws Exception {
        if (initialization.equals("always")) {
            userRepository.save(
                    new User(
                            "Admin",
                            "Admin",
                            passwordEncoder.encode("3333qqqq"),
                            "1234567",
                            roleRepository.findAll(),
                            true,
                            true,
                            true,
                            true
                    )
            );
        }
    }
}

