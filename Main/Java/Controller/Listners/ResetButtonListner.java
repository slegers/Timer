package Controller.Listners;

import Controller.TimerController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yanice on 22/01/17.
 */
public class ResetButtonListner implements ActionListener {
    private TimerController controller;
    public ResetButtonListner(TimerController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.resetTimer();
    }
}
