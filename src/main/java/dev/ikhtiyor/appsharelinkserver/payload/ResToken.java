package dev.ikhtiyor.appsharelinkserver.payload;

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
public class ResToken {
    private String token;
    private String tokenType = "Bearer ";

    public ResToken(String token) {
        this.token = token;
    }
}
