package com.example.auction;
// UserService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
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

    public User Custom(Long id){
        return userRepository.Custom(id);
    }

    public User fetchByemail(String username){
        return userRepository.fetchByemail(username);
    }

}
