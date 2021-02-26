package io.javabrains.springsecurityjwt.service;

import io.javabrains.springsecurityjwt.domain.Role;
import io.javabrains.springsecurityjwt.repository.RoleRepository;
import io.javabrains.springsecurityjwt.util.CrudInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleService implements CrudInterface<Role> {

    @Autowired
    RoleRepository roleRepository;


    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role get(Long id) {
        return null;
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public List<Role> getAll(int page, int size) {
        return null;
    }

    @Override
    public void saveAll(List<Role> list) {

    }
}
