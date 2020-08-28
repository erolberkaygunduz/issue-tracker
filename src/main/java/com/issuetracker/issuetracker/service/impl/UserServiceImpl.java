package com.issuetracker.issuetracker.service.impl;

import com.issuetracker.issuetracker.entity.User;
import com.issuetracker.issuetracker.repository.UserRepository;
import com.issuetracker.issuetracker.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if (user.getUsername()==null){
            throw new IllegalArgumentException("Username can not be null!");
        }
        return null;
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(User user) {
        return null;
    }

    @Override
    public User getByUserName(String username) {
        return userRepository.findByUsername(username);
    }
}
