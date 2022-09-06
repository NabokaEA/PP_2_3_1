package ru.nabokae.persist;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public interface UserRepository {
    void insert(User user);
    void save(User user);
    void delete(long id);
    void findById(long id);
    List<User> findAll();
}
