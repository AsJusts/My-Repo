package dev.ikhtiyor.appsharelinkserver.payload;

import dev.ikhtiyor.appsharelinkserver.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Ikhtiyor Khaitov
 * 16/05/21
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    Integer id;
    String firstName;
    String lastName;
    String phoneNumber;
    String oldPassword;
    String password;
    String prePassword;
}
