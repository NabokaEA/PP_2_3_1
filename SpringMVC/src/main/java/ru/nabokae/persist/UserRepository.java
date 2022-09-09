package ru.nabokae.persist;

import java.util.List;

public interface UserRepository {
    void insert(User user);
    void update (User user);
    void delete(long id);
    User findById(long id);
    List<User> findAll();
}
