package dev.ikhtiyor.appsharelinkserver.repository;

import dev.ikhtiyor.appsharelinkserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Ikhtiyor Khaitov
 * 15/05/21
 **/

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByPhoneNumber(String phoneNumber);
}
