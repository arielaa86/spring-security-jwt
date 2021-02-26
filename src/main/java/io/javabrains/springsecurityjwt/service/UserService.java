package io.javabrains.springsecurityjwt.service;



import io.javabrains.springsecurityjwt.domain.Role;
import io.javabrains.springsecurityjwt.domain.User;
import io.javabrains.springsecurityjwt.repository.UserRepository;
import io.javabrains.springsecurityjwt.util.CrudInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements CrudInterface<User> {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(Long id) {
        Optional<User> optional = userRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public Long count() {
        return userRepository.count();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
       List<User> userList = new ArrayList<>();

        userRepository.findAll().forEach(user -> {
            userList.add(user);
        });

        return userList;
    }


    @Override
    public List<User> getAll(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        List<User> userList = new ArrayList<>();

        userRepository.findAll(pageable).forEach(user -> {
            userList.add(user);
        });

        return userList;
    }

    @Override
    public void saveAll(List<User> list) {
        userRepository.saveAll(list);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }



}
