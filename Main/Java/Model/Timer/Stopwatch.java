package Model.Timer;

import Model.Round;

import java.util.ArrayList;
import java.util.Timer;

/**
 * Created by yanice on 22/01/17.
 */
public class Stopwatch extends GameTimer {

    public Stopwatch(int interval) {
        super(interval);
    }

    @Override
    public void performAction() {
        setCentiSeconds(centiseconds + 1);
        if (centiseconds >= 93) {
            setCentiSeconds(0);
            setSeconds(seconds + 1);
        }
        if (seconds >= 60) {
            setSeconds(0);
            setMinutes(minutes + 1);
        }
        if (minutes >= 60) {
            setMinutes(0);
            setHours(hours + 1);
        }
        notifyObservers();
    }

    @Override
    public void reset() {
        centiseconds = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
    }
}
