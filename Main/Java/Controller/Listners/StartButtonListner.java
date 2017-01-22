package Controller.Listners;

import Controller.TimerController;
import com.sun.tools.javadoc.Start;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yanice on 22/01/17.
 */
public class StartButtonListner implements ActionListener {
    private TimerController controller;
    public StartButtonListner(TimerController controller){
        this.controller = controller;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        controller.startTimer();
    }
}
