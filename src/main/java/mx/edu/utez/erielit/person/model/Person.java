package mx.edu.utez.erielit.person.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mx.edu.utez.erielit.user.model.User;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = false)
    private String name;
    @Column(unique = false)
    private String surname;
    @Column(unique = false)
    private String lastname;
    @Column(unique = false)
    private String birthday;
    @Column(unique = true, nullable = false, length = 18)
    private String curp;
    @OneToOne(mappedBy = "person")
    @JsonIgnore
    private User user;

    public Person() {
    }

    public Person(String name, String surname, String lastname, String birthday, String curp) {
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.curp = curp;
    }

    public Person(long id, String name, String surname, String lastname, String birthday, String curp) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.curp = curp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
