package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * GKislin
 * 15.09.2015.
 */
@Repository
public class InMemoryUserMealRepositoryImpl implements UserMealRepository {
    private Map<Integer, Map<Integer, UserMeal>> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);
    {
//        UserMealsUtil.MEAL_LIST.forEach(this::save);
        for (UserMeal userMeal : UserMealsUtil.MEAL_LIST){
            save(1, userMeal);
        }
    }

    @Override
    public UserMeal save(int userId, UserMeal userMeal) {
        if (userMeal.isNew()) {
            userMeal.setId(counter.incrementAndGet());
        }
        repository.get(userId).put(userMeal.getId(),userMeal);
        return userMeal;
    }

    @Override
    public void delete(int userId, int id) {
        repository.get(userId).remove(id);
    }

    @Override
    public UserMeal get(int userId, int id) {
        return repository.get(userId).get(id);
    }

    @Override
    public Collection<UserMeal> getAll(int userId) {
        Collection<UserMeal> userMealCollection = repository.get(userId).values();
        userMealCollection.stream().sorted((o1, o2) -> o1.getDateTime().compareTo(o2.getDateTime()));
        return userMealCollection;
    }
}

