package com.mercadolibre.users.service;

import com.mercadolibre.users.persistence.domain.User;
import com.mercadolibre.users.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User findByName(String name) {
        Optional<User> user = userRepository.findByName(name);

        return user.orElseThrow(IllegalArgumentException::new);

    }
}
