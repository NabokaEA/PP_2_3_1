package ru.nabokae.persist;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void insert(User user);
    void update (User user);
    void delete(long id);
    Optional<User> findById(long id);
    List<User> findAll();
}
