package models;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private Long id;
    private String login;
    private boolean activated;
    private String email;
    private Set<String> authorities;
}