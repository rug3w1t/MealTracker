package org.mealtracker.service.user;

import org.mealtracker.model.User;
import org.mealtracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public void save(User user) {
        repository.save(user);
    }


    @Override
    public List<User> findAll() {

        return repository.findAll();
    }

    @Override
    public User getOne(Long id) {
        return repository.getOne(id);
    }
}
