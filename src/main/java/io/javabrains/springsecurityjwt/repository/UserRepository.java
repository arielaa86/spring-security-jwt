package io.javabrains.springsecurityjwt.repository;


import io.javabrains.springsecurityjwt.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByUsername(String username);

}
