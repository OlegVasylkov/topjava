package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;
import ru.javawebinar.topjava.util.UserMealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by filipenko_n on 03.08.2016.
 */
public class MealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(MealServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("redirect to mealList");
        List<UserMealWithExceed> list = UserMealsUtil.getFilteredWithExceeded(UserMealsUtil.mealList, LocalTime.MIN, LocalTime.MAX, UserMealsUtil.DEFAULT_CALORIES_PER_DAY);
        request.setAttribute("mealList", list);
        request.getRequestDispatcher("/mealList.jsp").forward(request, response);

//        при redirect аттрибуты теряются
//        response.sendRedirect("mealList.jsp");
    }
}