package com.amazonapi.amazonapi.Service;

import com.amazonapi.amazonapi.Entity.User;
import com.amazonapi.amazonapi.Exception.UserNotFoundException;

import java.nio.file.attribute.UserPrincipalNotFoundException;

public interface UserService {

    User addUser(User user);

    User findUser(Long id) throws UserNotFoundException;
}
