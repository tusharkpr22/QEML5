package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Authenticate {
    private String username;
    private String password;
    private boolean rememberMe;

}
