package ru.nabokae.persist;

import jakarta.persistence.*;
import org.springframework.context.annotation.Bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String userName;
    @NotBlank
    @Column(nullable = false)
    private String passWord;
    @Min(value = 16)
    @Column(nullable = false)
    private Integer Age;


    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }



    public User(Long id, String userName, String passWord, Integer age) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.Age = age;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
