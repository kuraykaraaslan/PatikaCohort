package org.rentacar.views;

import org.rentacar.controller.BookController;
import org.rentacar.core.Helpers;
import org.rentacar.entities.Book;
import org.rentacar.entities.Car;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookingView extends Layout {
    private JPanel container;
    private JLabel lbl_car_info;
    private JTextField fld_book_name;
    private JTextField fld_book_idno;
    private JTextField fld_book_mpno;
    private JTextField fld_book_mail;
    private JTextField fld_book_strt_date;
    private JTextField fld_book_fnsh_date;
    private JTextField fld_book_prc;
    private JTextArea txta_book_note;
    private JButton btn_book_save;
    private Car car;
    private BookController bookController;

    public BookingView(Car selectedCar, String strt_date, String fnsh_date) {
        this.car = selectedCar;
        this.bookController = new BookController();
        this.container = new JPanel();
        this.container.setSize(500, 500);

        lbl_car_info.setText("Car Info: " +
                this.car.getPlate() + " / " +
                this.car.getModel().getBrand().getName() + " / " +
                this.car.getModel().getName());

        this.fld_book_strt_date.setText(strt_date);
        this.fld_book_fnsh_date.setText(fnsh_date);

        btn_book_save.addActionListener(e -> {
            JTextField[] checkFieldList = {
                    this.fld_book_name,
                    this.fld_book_mail,
                    this.fld_book_prc,
                    this.fld_book_idno,
                    this.fld_book_strt_date,
                    this.fld_book_fnsh_date
            };

            if (Helpers.isFieldEmpty(checkFieldList) || this.txta_book_note.getText().trim().isEmpty()) {
                Helpers.showMessage("Please fill in all the fields.");
            } else {
                Book book = new Book();
                book.setBookCase("done");
                book.setId(this.car.getId());
                book.setFullName(this.fld_book_name.getText());
                book.setStartDate(Date.valueOf(LocalDate.parse(strt_date, DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                book.setEndDate(Date.valueOf(LocalDate.parse(fnsh_date, DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                book.setBookID(this.fld_book_idno.getText());
                book.setPhone(this.fld_book_mpno.getText());
                book.setEmail(this.fld_book_mail.getText());
                book.setNote(this.txta_book_note.getText());
                book.setPrice(Integer.parseInt(this.fld_book_prc.getText()));

                if (this.bookController.saveBook(book)) {
                    Helpers.showMessage("Booking saved successfully.");
                    ((JFrame) SwingUtilities.getWindowAncestor(this.container)).dispose();
                } else {
                    Helpers.showMessage("Error occurred while saving the booking.");
                }

            }

        });
    }
}
