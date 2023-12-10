package com.example.rsocial2.Model;

import jakarta.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String userName;
    private Integer creationDate;
    private Integer likeCount;
    private String text;
    private String image;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }


    // getters and setters

    public String getUserName() {
        return userName;
    }

    public void setUserName(String user) {

        user = user;
    }

    public Integer getCreationDate() {

        return creationDate;
    }

    public void setCreationDate(Integer day) {

        creationDate = creationDate;
    }

    public Integer getLikeCount() {

        return likeCount;
    }

    public void setLikeCount(Integer likes) {

        likeCount = likeCount;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {

        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
