package View;

import Controller.TimerController;
import javax.swing.*;

/**
 * Created by yanice on 15/01/17.
 */
public class MainMenu extends JMenuBar {
    private JMenu menu, help,exit,timer;
    private JMenuItem menuItem;
    private TimerController controller;
    public MainMenu(TimerController controller){
        createItems();
        setElements();
        setVisible(true);
        this.controller = controller;

    }

    private void createItems() {
        menu = new JMenu("Menu");
        help = new JMenu("about");
        exit = new JMenu("exit");
    }
    private void setElements(){
        this.add(menu);
        this.add(help);
        this.add(exit);

    }
}
