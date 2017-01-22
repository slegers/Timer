package View;

import Controller.TimerController;
import Model.Observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by yanice on 22/01/17.
 */
public class CountDownView extends JFrame implements Observer{
    private JPanel buttonsPanel,maxTimePanel;
    private TimerController controller;
    private JLabel time;
    private JLabel maxTime;
    private JTextField maxTimeTxt;
    private JButton start,reset,stop;

    public CountDownView(TimerController controller){
        this.controller = controller;
        createElements();
        setElements();
        pack();
        setVisible(true);
    }
    private void createElements() {
        buttonsPanel = new JPanel();
        maxTimePanel = new JPanel();
        time = new JLabel("Time");
        maxTime = new JLabel("Maximum time:");
        maxTimeTxt = new JTextField(5);
        start = new JButton("Start");
        reset = new JButton("Reset");
        stop = new JButton("Stop");
    }

    private void setElements() {
        this.setLayout(new GridLayout(2,1));
        maxTimePanel.setLayout(new GridLayout(1,2));
        maxTimePanel.add(maxTime);
        maxTimeTxt.setText("00:00:20:00");
        maxTimePanel.add(maxTimeTxt);
        add(maxTimePanel);
        buttonsPanel.setLayout(new GridLayout(3,1));
        buttonsPanel.add(start);
        buttonsPanel.add(reset);
        buttonsPanel.add(stop);
        add(buttonsPanel);
    }
    public void addStartListner(ActionListener listener){
        start.addActionListener(listener);
    }
    public void addStopListner(ActionListener listener){
        stop.addActionListener(listener);
    }
    public void addResetListner(ActionListener listener){
        reset.addActionListener(listener);
    }
    public String getMaxTime(){
        return maxTime.getText();
    }

    @Override
    public void update() {

    }
}
