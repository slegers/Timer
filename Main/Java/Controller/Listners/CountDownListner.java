package Controller.Listners;

import Controller.TimerController;
import View.StopwatchView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

/**
 * Created by yanice on 22/01/17.
 */
public class CountDownListner implements ActionListener{
    private TimerController controller;

    public CountDownListner(TimerController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.disposeMainView();
        controller.setStopwatchView(new StopwatchView(controller));
    }
}
