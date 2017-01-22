package Controller.Listners;

import Controller.TimerController;
import View.StopwatchView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yanice on 22/01/17.
 */
public class StopwatchListner implements ActionListener {
    private TimerController c;
    public StopwatchListner(TimerController c){
        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        c.disposeMainView();
        c.setStopwatchView(new StopwatchView(c));
    }
}
