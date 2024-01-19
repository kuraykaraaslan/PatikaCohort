package org.rentacar.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Layout extends JFrame {
    public void layoutStart(int height, int width){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Rent A Car");
        //the dimensions of the GUI
        this.setSize(width,height);
        //calculating the viewport to be in the middle of the users screen
        int userViewportHeight = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - this.getSize().height) / 2;
        int userViewportWidth = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - this.getSize().width) / 2;
        this.setLocation(userViewportWidth, userViewportHeight);
        this.setVisible(true);
    }

    public void createTable(DefaultTableModel defaultTableModel, JTable jTable, Object[] cols, ArrayList<Object[]> rows){
        defaultTableModel.setColumnIdentifiers(cols);
        jTable.setModel(defaultTableModel);
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.getColumnModel().getColumn(0).setMaxWidth(75);
        jTable.setEnabled(false);

        DefaultTableModel clearModel = (DefaultTableModel) jTable.getModel();
        clearModel.setRowCount(0);

        if (rows == null){
            rows = new ArrayList<>();
        }

        for (Object[] row: rows){
            defaultTableModel.addRow(row);
        }
    }

    public int getTableSelectedRow(JTable table, int index){
        return Integer.parseInt(table.getValueAt(table.getSelectedRow(), index).toString());

    }

    public void tableRowSelect(JTable table){
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selected_row = table.rowAtPoint(e.getPoint());
                table.setRowSelectionInterval(selected_row,selected_row);
            }
        });
    }
}
