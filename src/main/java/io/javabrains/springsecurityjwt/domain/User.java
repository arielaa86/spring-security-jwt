package io.javabrains.springsecurityjwt.domain;




import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User implements Serializable {

    @Id
    @SequenceGenerator(name = "user_id_sequence", allocationSize = 1)
    @GeneratedValue(generator = "user_id_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String lastName;
    private String username;
    private String password;
    private LocalDate birthDate;
    private Boolean accountActivated;
    private Boolean accountLocked;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user"),
            inverseJoinColumns = @JoinColumn(name = "role")
    )
    private List<Role> roles;

    public User() {
        this.accountLocked=false;
        this.accountActivated=false;
        this.roles = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getAccountActivated() {
        return accountActivated;
    }

    public void setAccountActivated(Boolean accountActivated) {
        this.accountActivated = accountActivated;
    }

    public Boolean getAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(Boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
