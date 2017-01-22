package Controller;

import Controller.Listners.CountDownListner;
import Controller.Listners.ResetButtonListner;
import Controller.Listners.StartButtonListner;
import Controller.Listners.StopwatchListner;
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
}
