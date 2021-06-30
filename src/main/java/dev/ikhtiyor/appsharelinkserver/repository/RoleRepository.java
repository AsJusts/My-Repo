package dev.ikhtiyor.appsharelinkserver.repository;

import dev.ikhtiyor.appsharelinkserver.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ikhtiyor Khaitov
 * 15/05/21
 **/

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
