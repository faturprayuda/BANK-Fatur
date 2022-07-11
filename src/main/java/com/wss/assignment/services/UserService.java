package com.wss.assignment.services;

import com.wss.assignment.models.Users;
import com.wss.assignment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users save(Users users) {

        return userRepository.save(users);
    }

    public List<Users> getUsers(){
        return userRepository.findAll();
    }

    public void delete(int userId){
        userRepository.deleteById(userId);
    }

    public List<Users> findByIdentityNumber(String identityNumber){
        return userRepository.findByIdentityNumber(identityNumber);
    }

    public Users findById(int id){
        return userRepository.findById(id);
    }
}
