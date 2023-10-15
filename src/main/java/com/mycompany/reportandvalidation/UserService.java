/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reportandvalidation;

import java.util.List;

/**
 *
 * @author USER
 */
public class UserService {

    static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public User login(String login, String password) {
        UserDao userDao = new UserDao();
        User user = userDao.getByLogin(login);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public List<User> getUsers() {
        UserDao userDao = new UserDao();
        return userDao.getAll(" user_login asc");
    }

    public User addNew(User editedUser) throws ValidateException {
        if (editedUser.isValid()) {
            UserDao userDao = new UserDao();
            return userDao.save(editedUser);
        } else {
            throw new ValidateException("Error, Plase check agin.");
        }
    }

    public User update(User editedUser) throws ValidateException {
        if (editedUser.isValid()) {
            UserDao userDao = new UserDao();
            return userDao.update(editedUser);
        } else {
            throw new ValidateException("Error, Plase check agin.");
        }
    }

    public int delete(User editedUser) {
        UserDao userDao = new UserDao();
        return userDao.delete(editedUser);
    }

}
