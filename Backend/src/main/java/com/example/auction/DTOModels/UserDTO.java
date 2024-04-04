package com.example.auction.DTOModels;

import com.example.auction.Models.User;

public class UserDTO {
    
    private Long userId;
    private String userName;
    private String email;
    
    private String role;

    public UserDTO() {
    }

    public UserDTO(Long userId, String userName, String email, String role) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static UserDTO mapEntityToDto(User user) {
        return new UserDTO(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole()
        );
    }
}
