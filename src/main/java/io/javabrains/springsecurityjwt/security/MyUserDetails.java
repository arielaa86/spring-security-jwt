package io.javabrains.springsecurityjwt.security;

import io.javabrains.springsecurityjwt.domain.Role;
import io.javabrains.springsecurityjwt.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private String username;
    private String password;
    private LocalDate birthDate;
    private Boolean accountActivated;
    private Boolean accountLocked;
    private List<GrantedAuthority> authorities;


    public MyUserDetails(User user) {

        this.username = user.getUsername();
        this.password = user.getPassword();
        this.accountActivated = user.getAccountActivated();
        this.accountLocked = user.getAccountLocked();
        this.authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toList());

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return accountActivated;
    }

}
