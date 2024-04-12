package com.example.auction.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auction.DTOModels.UserDTO;
import com.example.auction.Models.User;
import com.example.auction.Repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        try {
            List<User> users = userRepository.findAll();
            return users.stream().map(UserDTO::mapEntityToDto).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching all users: " + e.getMessage(), e);
        }
    }

    public User getUserById(Long id) {
        try {
            return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching user by ID: " + e.getMessage(), e);
        }
    }
    public User getUserByUsername(String username) {
        try {
            return userRepository.findByUsername(username).orElseThrow(() -> new NoSuchElementException("User not found"));
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching user by username: " + e.getMessage(), e);
        }
    }


    public UserDTO getUserDTOById(Long id) {
        try {
            User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
            return new UserDTO(user);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching user DTO by ID: " + e.getMessage(), e);
        }
    }

    public void createUser(User user) {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while creating user: " + e.getMessage(), e);
        }
    }

    public void deleteUser(Long id) {
        try {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
            } else {
                throw new NoSuchElementException("User not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while deleting user: " + e.getMessage(), e);
        }
    }
}
