package org.example.service;

import org.example.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    Map <String, User> userMap = new HashMap<>();
    User currentUser;
    public User register(User newUser) {
        if(!userMap.containsKey(newUser.getEmail())){
            userMap.put(newUser.getEmail(), newUser);
            currentUser = newUser;
            return newUser;
        }
        return null;
    }
}
