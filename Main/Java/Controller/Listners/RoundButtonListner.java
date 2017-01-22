package Controller.Listners;

import Controller.TimerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yanice on 22/01/17.
 */
public class RoundButtonListner implements ActionListener {
    private TimerController controller;
    public RoundButtonListner(TimerController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
