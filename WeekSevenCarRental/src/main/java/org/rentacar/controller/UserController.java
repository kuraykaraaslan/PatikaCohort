package org.rentacar.controller;

import org.rentacar.core.Helpers;
import org.rentacar.data.UserData;
import org.rentacar.entities.User;

import java.util.ArrayList;
public class UserController {
    public final UserData userData = new UserData();


    public ArrayList<Object[]> getForTable(int size, ArrayList<User> users) {
        ArrayList<Object[]> data = new ArrayList<>();
        for (User user : users) {
            Object[] row = new Object[size];
            row[0] = user.getId();
            row[1] = user.getUsername();
            row[2] = user.getEmail();
            row[4] = user.getRole();
            data.add(row);
        }
        return data;
    }
    public ArrayList<Object[]> getForTable(int size) {
        ArrayList<Object[]> data = new ArrayList<>();
        return getForTable(size, userData.getAll());
    }

    public ArrayList<User> getAll(){
        return userData.getAll();
    }

    public boolean saveUser(User user){
        return userData.add(user);
    }

    public User get(int userId){
        return userData.get(userId);
    }

    public User getById(int userId){
        return userData.get(userId);
    }

    public boolean updateUser(User user){
        if(userData.get(user.getId()) != null){
            return userData.update(user);
        } else {
            Helpers.showErrorMessage("User not found");
            return false;
        }
    }

    public boolean deleteUser(User user){
        if(userData.get(user.getId()) != null){
            return userData.delete(user);
        } else {
            Helpers.showErrorMessage("User not found");
            return false;
        }
    }

    public User login(String username, String password){
        return this.userData.login(username, password);
    }
}