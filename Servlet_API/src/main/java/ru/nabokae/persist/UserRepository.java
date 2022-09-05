package ru.nabokae.persist;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepository {
    private final Map<Long,User> userMap = new ConcurrentHashMap<>();
    private final AtomicLong identity = new AtomicLong(0);

    public void insert (User user){
        long id = identity.incrementAndGet();
        userMap.put(id,user);
    }

    public void save (User user){
        if(user.getId()==null){
            long id = identity.incrementAndGet();
            userMap.put(id,user);
        } else {
            userMap.put(user.getId(), user);
        }
        userMap.put(user.getId(), user);
    }

    public void delete (long id){
        userMap.remove(id);
    }

    public void findById (long id){
        userMap.remove(id);
    }

    public List<User>  findAll(){
       return new ArrayList<>(userMap.values());
    }
}
