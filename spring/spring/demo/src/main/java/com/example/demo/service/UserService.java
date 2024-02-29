package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public boolean post(User user)
    {
        try{
            userRepo.save(user);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
}
