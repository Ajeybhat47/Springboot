package com.example.auction.Service;
// UserService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auction.DTOModels.BidDTO;
import com.example.auction.DTOModels.UserDTO;
import com.example.auction.Models.Bid;
import com.example.auction.Models.User;
import com.example.auction.Repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::mapEntityToDto).toList();
        
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id){

        userRepository.deleteById(id);
    }

    private UserDTO mapEntityToDto(User user) {
        return new UserDTO(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole()
        );
    }

}
