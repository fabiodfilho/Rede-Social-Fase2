package com.example.rsocial2.Model;

import jakarta.persistence.*;
@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String password;
    private String perfilPhoto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerfilPhoto() {
        return perfilPhoto;
    }

    public void setPerfilPhoto(String perfilPhoto) {
        this.perfilPhoto = perfilPhoto;
    }

}
