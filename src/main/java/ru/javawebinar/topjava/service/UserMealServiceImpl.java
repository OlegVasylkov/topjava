package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
@Service
public class UserMealServiceImpl implements UserMealService {

    @Autowired
    private UserMealRepository repository;

    @Override
    public List<UserMeal> getAll(int userId) {
        List<UserMeal> list = new ArrayList<>();
        list.addAll(repository.getAll(userId));
        list.sort(((o1, o2) -> o1.getDateTime().compareTo(o2.getDateTime())));
        return list;
     }

    @Override
    public void delete(int userId, int id) {

    }

    @Override
    public UserMeal save(int userId, UserMeal um) {
        return null;
    }

    @Override
    public UserMeal update(int userId, UserMeal um) {
        return null;
    }
}
