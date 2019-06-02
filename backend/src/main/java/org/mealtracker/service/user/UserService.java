package org.mealtracker.service.user;

import org.mealtracker.model.User;

import java.util.List;


public interface UserService {

    void save(User user);
    List<User> findAll();
    User getOne(Long id);

}
