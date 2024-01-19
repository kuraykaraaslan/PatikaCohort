package org.rentacar;

import org.rentacar.controller.UserController;
import org.rentacar.core.Helpers;
import org.rentacar.views.AdminView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Helpers.setTheme();
        //LoginView loginView = new LoginView();
        UserController userController = new UserController();
        AdminView adminView = new AdminView(userController.login("admin", "1234"));
    }
}