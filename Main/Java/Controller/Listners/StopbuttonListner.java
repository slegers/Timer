package Controller.Listners;

import Controller.TimerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yanice on 25/01/17.
 */
public class StopbuttonListner implements ActionListener {
    private TimerController controller;
    public StopbuttonListner(TimerController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.stopTimer();
    }
}
