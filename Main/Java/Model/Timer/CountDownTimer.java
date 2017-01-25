package Model.Timer;

import Controller.TimerController;

/**
 * Created by yanice on 23/01/17.
 */
public class CountDownTimer extends GameTimer{
    private int oHours,oMinuts,oSeconds;
    private TimerController controller;
    public CountDownTimer(int hours, int minutes, int getseconds, TimerController controller) {
        super(10);
        oHours = hours;
        oMinuts = minutes;
        oSeconds = seconds;
        centiseconds = 0;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = getseconds;
        this.controller = controller;
    }

    @Override
    public void performAction() {
        if(hours == 0 && minutes == 0 && seconds == 0 && centiseconds == 0){
            stop();
        }else{
            centiseconds--;
            if(centiseconds <=0) {
             if(!(seconds <= 0 && minutes <= 0 && hours <= 0)){
                setCentiSeconds(93);
                seconds--;
            }
            }if(seconds <=0 ){
                if(!(minutes<=0 && hours <=0)){
                    setSeconds(59);
                    minutes--;
                }
            }if(minutes <= 0){
                if(!(hours <=0)){
                    setMinutes(59);
                    hours--;
                }
            }
        }
        notifyObservers();
    }

    @Override
    public void reset() {
        controller.resetCountDownTimer();
    }
}
