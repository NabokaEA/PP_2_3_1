package ru.nabokae.persist;

import java.util.List;
import java.util.Optional;

public class HibernateRepositoryImpl implements UserRepository{
    @Override
    public void insert(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Optional<User> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
