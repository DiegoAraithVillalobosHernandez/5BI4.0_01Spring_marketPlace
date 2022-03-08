package mx.edu.utez.erielit.user.controller;

import com.sun.istack.NotNull;
import mx.edu.utez.erielit.person.model.Person;
import mx.edu.utez.erielit.role.model.Role;

import java.util.Set;

public class UserDTO {
    private long id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private Person person;
    @NotNull
    private Set<Role> roles;

    public UserDTO() {
    }

    public UserDTO(String username, String password, Person person, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.person = person;
        this.roles = roles;
    }

    public UserDTO(long id, String username, String password, Person person, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.person = person;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
