package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * GKislin
 * 15.06.2015.
 */
@Repository
public class InMemoryUserRepositoryImpl implements UserRepository {
    private static final Logger LOG = LoggerFactory.getLogger(InMemoryUserRepositoryImpl.class);
    private static Map<Integer, User> users = new ConcurrentHashMap<>();
    static {
        users.put(1, new User(1, "admin name", "admin", "root", Role.ROLE_ADMIN));
        users.put(2, new User(2, "user name", "user", "password", Role.ROLE_USER));
    }

    @Override
    public boolean delete(int id) {
        LOG.info("delete " + id);
        return users.remove(id) != null;
    }

    @Override
    public User save(User user) {
        LOG.info("save " + user);
        if (user.isNew())
            user.setId(3);
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User get(int id) {
        LOG.info("get " + id);
        return users.get(id);
    }

    @Override
    public List<User> getAll() {
        LOG.info("getAll");
        List<User> userList = new ArrayList<>();
        userList.addAll(users.values());
        userList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        return userList;
    }

    @Override
    public User getByEmail(String email) {
        LOG.info("getByEmail " + email);
        return users.values().stream().filter(u -> u.getEmail().equals(email)).findFirst().get();
    }
}
