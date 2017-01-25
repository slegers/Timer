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
    private JComboBox hours,min,sec;
    private TimerController controller;
    private JLabel h,m,s;
    private JLabel time;
    private JButton start,reset,stop;
    //private JMenuBar menubar;

    public CountDownView(TimerController controller){
        this.controller = controller;
        createElements();
        setElements();
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void createElements() {
        buttonsPanel = new JPanel();
        maxTimePanel = new JPanel();
        time = new JLabel("00:00:00:00");
        start = new JButton("Start");
        reset = new JButton("Reset");
        stop = new JButton("Stop");
        h = new JLabel("Hours:");
        m = new JLabel("Minutes:");
        s = new JLabel("Seconds:");
      //  menubar = new MainMenu(controller);
        String[] s = new String[60];
        for(int i = 0; i < 60;i++){
            s[i] = i + "";
        }
        hours = new JComboBox(s);
        min = new JComboBox(s);
        sec = new JComboBox(s);
    }

    private void setElements() {
       //t add(menubar);
        this.setLayout(new GridLayout(4,3));
        maxTimePanel.setLayout(new GridLayout(2,3));
        maxTimePanel.add(h);
        maxTimePanel.add(m);
        maxTimePanel.add(s);
        maxTimePanel.add(hours);
        maxTimePanel.add(min);
        maxTimePanel.add(sec);

        add(maxTimePanel);
        time.setHorizontalAlignment(SwingConstants.CENTER);
        add(time);
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
        controller.resetCountDownTimer();
    }
    public String getMaxTime(){
        return time.getText();
    }

    @Override
    public void update() {
        time.setText(controller.getTime());
    }

    public int getHours() {
        return Integer.parseInt(hours.getSelectedItem().toString());
    }

    public int getMinutes() {
        return Integer.parseInt(min.getSelectedItem().toString());
    }

    public int getseconds() {
        return Integer.parseInt(sec.getSelectedItem().toString());
    }
}
