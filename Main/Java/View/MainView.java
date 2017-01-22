package View;


import Controller.Listners.CountDownListner;
import Controller.Listners.StopwatchListner;
import Controller.TimerController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yanice on 22/01/17.
 */
public class MainView extends JFrame   {
    private JButton stopwatch, countDown;
    private TimerController controller;
    public MainView(String name, TimerController controller){
        super(name);
        this.controller = controller;
        createElements();
        addElements();
    }
    private void createElements() {
        stopwatch = new JButton("Stopwatch Timer");
        countDown = new JButton("Countdown Timer");
    }

    private void addElements() {
        this.setLayout(new GridLayout(2,1));
        add(stopwatch);
        add(countDown);
        pack();
    }

    public void setStopWatchListner(StopwatchListner stopWatchListner) {
       stopwatch.addActionListener(stopWatchListner);
    }
    public void setCountDownListner(CountDownListner countDownListner) {
        countDown.addActionListener(countDownListner);
    }

}
