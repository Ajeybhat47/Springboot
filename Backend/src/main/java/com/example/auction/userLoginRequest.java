// UserLoginRequest.java
package com.example.auction;

public class userLoginRequest {

    private String email;
    private String password;

    // Default constructor (required by Spring)
    public userLoginRequest() {
    }

    // Constructor with fields
    public userLoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
