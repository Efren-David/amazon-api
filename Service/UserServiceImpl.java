package com.amazonapi.amazonapi.Service;


import com.amazonapi.amazonapi.Entity.User;
import com.amazonapi.amazonapi.Exception.UserNotFoundException;
import com.amazonapi.amazonapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUser(Long id) throws  UserNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }
}
