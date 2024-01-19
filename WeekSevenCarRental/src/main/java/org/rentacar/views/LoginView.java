package org.rentacar.views;

import org.rentacar.controller.UserController;
import org.rentacar.core.Helpers;
import org.rentacar.entities.User;

import javax.swing.*;
import java.awt.*;

public class LoginView extends Layout{
    private JPanel container;
    private JPanel w_top;
    private JLabel lbl_welcomemsg;
    private JLabel lbl_welcomemsg2;
    private JPanel w_bottom;
    private JTextField field_username;
    private JPasswordField field_password;
    private JButton btn_login;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private final UserController UserController;

    public LoginView(){
        this.UserController = new UserController();
        //draw the UI
        this.add(container);
        //when GUI is closed end the program
        layoutStart(400, 400);
        //making sure the fields are not empty
        btn_login.addActionListener(e -> {
            if (Helpers.isFieldEmpty(this.field_username)){
                Helpers.showErrorMessage("Username field cannot be empty.");
            } else {
                if (Helpers.isFieldEmpty((this.field_password))){
                    Helpers.showErrorMessage("Password field cannot be empty.");
                } else {
                    User loginUser = this.UserController.login(this.field_username.getText(), this.field_password.getText());
                    if (loginUser == null){
                        Helpers.showErrorMessage("User not found.");
                    } else {
                        AdminView adminView = new AdminView(loginUser);
                        dispose();
                    }
                }
            }
        });

    }
}
