package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.service.UserMealService;
import ru.javawebinar.topjava.to.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static ru.javawebinar.topjava.util.UserMealsUtil.*;

/**
 * GKislin
 * 06.03.2015.
 */
@Controller
public class UserMealRestController {
    @Autowired
    private UserMealService service;
    private static final Logger LOG = LoggerFactory.getLogger(UserMealRestController.class);

    public List<UserMealWithExceed> getAll(){
        LOG.info("get all ");
        return getWithExceeded(service.getAll(LoggedUser.id()), LoggedUser.getCaloriesPerDay());
    }

//    public List<UserMealWithExceed> getBetween(LocalTime startTime, LocalTime endTime,
//                                               LocalDate startDate, LocalDate endDate){
//        LOG.info("get between " + startTime  + startDate + " " + endTime + endDate);
//        return getFilteredWithExceeded(service.getBetween(LoggedUser.id()), startTime, endTime, startDate, e, LoggedUser.getCaloriesPerDay());
//    }

    public void delete(int id){
        LOG.info("delete " + id);
        service.delete(LoggedUser.id(), id);
    }

    public UserMeal save(UserMeal um){
        LOG.info("save " + um);
        return service.save(LoggedUser.id(), um);
    }

    public void update(UserMeal um){
        LOG.info("update " + um);
        service.update(LoggedUser.id(), um);
    }
}