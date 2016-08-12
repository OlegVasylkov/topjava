package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.List;

/**
 * GKislin
 * 15.06.2015.
 */
public interface UserMealService {
    List<UserMeal> getAll(int userId);

    void delete(int userId, int id);

    UserMeal save(int userId, UserMeal um);

    UserMeal update(int userId, UserMeal um);
}
