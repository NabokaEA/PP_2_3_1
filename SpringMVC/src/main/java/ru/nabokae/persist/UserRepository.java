package ru.nabokae.persist;

import java.util.List;

public interface UserRepository {
    void insert(User user);
    void save(User user);
    void delete(long id);
    void findById(long id);
    List<User> findAll();
}
