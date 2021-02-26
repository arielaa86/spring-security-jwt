package io.javabrains.springsecurityjwt.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @Id
    @SequenceGenerator(name = "role_id_sequence", allocationSize = 1)
    @GeneratedValue(generator = "role_id_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String authority;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
