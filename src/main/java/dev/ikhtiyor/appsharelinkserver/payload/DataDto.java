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
public class DataDto {
    private Long id;
    private String date;
    private String name;
    private String originalLink;
    private String generatedLink;
}
