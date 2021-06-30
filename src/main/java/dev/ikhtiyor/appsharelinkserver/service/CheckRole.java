package dev.ikhtiyor.appsharelinkserver.service;

import dev.ikhtiyor.appsharelinkserver.entity.Role;
import dev.ikhtiyor.appsharelinkserver.entity.User;
import dev.ikhtiyor.appsharelinkserver.entity.enums.RoleName;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Ikhtiyor Khaitov
 * 16/05/21
 **/

@Service
public class CheckRole {

    public boolean isAdmin(User user) {
        for (Role role : user.getRoles()) {
            if (role.getRoleName() == RoleName.ROLE_ADMIN) {
                return true;
            }
        }
        return false;
    }
}
