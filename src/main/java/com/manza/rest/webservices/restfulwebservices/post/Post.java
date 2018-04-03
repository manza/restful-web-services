package com.manza.rest.webservices.restfulwebservices.post;

import java.util.Date;

public class Post {

    private Integer id;
    private String name;
    private Date publishDate;

    public Post() {
    }

    public Post(Integer id, String name, Date publishDate) {
        this.id = id;
        this.name = name;
        this.publishDate = publishDate;
    }

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

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
