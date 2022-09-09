package ru.nabokae.persist;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final Map<Long, User> userMap = new ConcurrentHashMap<>();
    private final AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init() {
        this.insert(new User(1L, "Иван", "111"));
        this.insert(new User(2L, "Марья", "222"));
        this.insert(new User(3L, "Галя", "333"));
    }


    @Override
    public void insert(User user) {
        Long id = identity.incrementAndGet();
        user.setId(id);
        userMap.put(id, user);
    }

    @Override
    public void update(User user) {
        if (user.getId() == null) {
            Long id = identity.incrementAndGet();
            userMap.put(id, user);
        } else {
            userMap.put(user.getId(), user);
        }
    }

    @Override
    public void delete(long id) {
        userMap.remove(id);
    }

    @Override
    public User findById(long id) {
        return userMap.get(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }
}
