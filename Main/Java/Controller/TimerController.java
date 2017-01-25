package Controller;

import Controller.Listners.*;
import Model.Timer.CountDownTimer;
import Model.Timer.GameTimer;
import Model.Timer.Stopwatch;
import View.CountDownView;
import View.MainView;
import View.StopwatchView;

/**
 * Created by yanice on 22/01/17.
 */
public class TimerController {
    private MainView mainView;
    private StopwatchView stopwatchView;
    private CountDownView countDownView;
    private GameTimer timer;
    public TimerController(){
        mainView = new MainView("Timer",this);
        setMainViewActionListners();
        mainView.setVisible(true);
    }
    public void setMainViewActionListners() {
        mainView.setStopWatchListner(new StopwatchListner(this));
        mainView.setCountDownListner(new CountDownListner(this));
    }
    public void disposeMainView(){
        mainView.dispose();
    }

    public void setStopwatchView(StopwatchView stopwatchView){
        timer = new Stopwatch(10);
        timer.addObserver(stopwatchView);
        this.stopwatchView = stopwatchView;
        stopwatchView.setVisible(true);
        stopwatchViewListnersAdded();
    }
    private void stopwatchViewListnersAdded() {
        stopwatchView.addStartListner(new StartButtonListner(this));
        stopwatchView.addResetListner(new ResetButtonListner(this));
        stopwatchView.addroundListner(new RoundButtonListner(this));
    }


    public void startTimer() {
        timer.startTimer();
    }
    public String getTime(){
        return timer.getTime();
    }

    public void resetTimer() {
        timer.reset();
    }

    public void setCountDownView(CountDownView countDownView) {
        this.countDownView = countDownView;
        timer = new CountDownTimer(countDownView.getHours(),countDownView.getMinutes(),countDownView.getseconds(),this);
        timer.addObserver(countDownView);
        CountDownViewListnersAdded();
        this.countDownView = countDownView;
    }

    private void CountDownViewListnersAdded() {
        countDownView.addStartListner(new StartButtonListner(this));
        countDownView.addResetListner(new ResetButtonListner(this));
        countDownView.addStopListner(new StopbuttonListner(this));
    }

    public void stopTimer() {
        timer.stop();
    }

    public void resetCountDownTimer() {
        timer = new CountDownTimer(countDownView.getHours(),countDownView.getMinutes(),countDownView.getseconds(),this);
        timer.addObserver(countDownView);
        countDownView.update();
    }
}
