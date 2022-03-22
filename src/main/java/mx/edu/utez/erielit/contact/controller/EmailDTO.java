package mx.edu.utez.erielit.contact.controller;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

public class EmailDTO {

    @NotBlank
    @NotNull
    private String email;
    @NotBlank
    @NotNull
    private String fullname;
    @NotBlank
    @NotNull
    private String comments;

    public EmailDTO() {
    }

    public EmailDTO(String email, String fullname, String comments) {
        this.email = email;
        this.fullname = fullname;
        this.comments = comments;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
