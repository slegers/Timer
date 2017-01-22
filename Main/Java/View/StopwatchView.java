package View;
import Controller.TimerController;
import Model.Observer.Observer;
import Model.Observer.Subject;
import Model.Round;
import sun.print.BackgroundServiceLookup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by yanice on 22/01/17.
 */
public class StopwatchView extends JFrame implements Observer{
    private JButton start, reset, round;
    private JLabel time;
    private TimerController controller;

    public StopwatchView(TimerController c){
        this.controller = c;
        createElements();
        addElements();
        pack();
    }

    private void addElements() {
        this.setLayout(new GridLayout(4,1));
        time.setHorizontalAlignment(SwingConstants.CENTER);
        time.setFont(new Font(Font.SERIF,Font.PLAIN,30));
        add(time);
        time.setForeground(Color.red);
        add(start);
        add(reset);

        //TODO
        //add(round);
    }
    public void addStartListner(ActionListener listener){
        start.addActionListener(listener);
    }
    public void addResetListner(ActionListener listener){
        reset.addActionListener(listener);
    }
    public void addroundListner(ActionListener listener){
        round.addActionListener(listener);
    }

    private void createElements() {
        time = new JLabel("00:00:00:00");
        start = new JButton("Start");
        round = new JButton("Round");
        reset = new JButton("Reset");
    }

    @Override
    public void update() {
        time.setText(controller.getTime());
    }
}
