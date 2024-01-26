package org.launchcode.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User {
//    @NotBlank(message="Username is required.")
    @Size(min=5, max=15, message="Username must be 5-15 characters long.")
    private String username;
    @Email(message="Invalid email format.")
    private String email;
    @Size(min=6,message="Password is 6 character long.")
    private String password;
    private static int nextId=1;
    private static int id;
    @NotNull(message="Passwords do not match.")
    private String verifyPassword;

    public User() {}


    public User(String username, String email, String password ,String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword= verifyPassword;
        this.id=nextId;
        nextId++;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        checkPassword();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
    public void checkPassword() {
        if(password != null && verifyPassword != null && !password.equals(verifyPassword)){
            setVerifyPassword(null);
        }
    }
}
