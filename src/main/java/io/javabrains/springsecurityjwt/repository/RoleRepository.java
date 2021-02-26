package io.javabrains.springsecurityjwt.repository;

import io.javabrains.springsecurityjwt.domain.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
}
