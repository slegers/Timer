package Model.Timer;

import Model.Observer.Observer;
import Model.Observer.Subject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanice on 22/01/17.
 */
public abstract class GameTimer implements Subject {
    int centiseconds,seconds,minutes,hours;
    private Timer timer;
    private List<Observer> observerList = new ArrayList<>();

    public GameTimer(int interval){

        timer = new Timer(interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performAction();
                notifyObservers();
            }
        });

    }
    public String getTime(){
        String centiSecondsS,secondsS,minutsS,hoursS;

        centiSecondsS = centiseconds + "";
        secondsS = seconds + "";
        minutsS = minutes + "";
        hoursS = hours + "";

        if(centiSecondsS.length() == 1){
            centiSecondsS = "0" + centiSecondsS;
        }if(secondsS.length() == 1){
            secondsS = "0" + secondsS;
        }if(minutsS.length() == 1){
            minutsS = "0" + minutsS;
        }if(hoursS.length() == 1){
            hoursS = "0" + hoursS;
        }
        return hoursS + ":" + minutsS + ":" + secondsS + ":" + centiSecondsS;
    }
    public abstract void performAction();
    public void addObserver(Observer observer){
        observerList.add(observer);
    }
    public void removeObserver(Observer observer){
        observerList.add(observer);
    }
    public void notifyObserver(Observer observer){
        observerList.remove(observer);
    }

    public void notifyObservers(){
    for(Observer o : observerList){
            o.update();
        }
    }
    public void setCentiSeconds(int centiSeconds) {
        this.centiseconds = centiSeconds;
    }
    public void setSeconds(int seconds){
        this.seconds = seconds;
    }
    public void setMinutes(int minutes){
        this.minutes = minutes;
    }
    public void setHours(int hours){
        this.hours = hours;
    }


    public void stop() {
        timer.stop();
    }
    public boolean isRunning(){
        return timer.isRunning();
    }

    public void startTimer(){
        timer.start();
    }
    public abstract  void reset();
}
