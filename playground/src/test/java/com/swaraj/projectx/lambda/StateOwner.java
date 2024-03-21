package com.swaraj.projectx.lambda;

import java.util.ArrayList;
import java.util.List;

public class StateOwner {
    final private List<StateChangeListener> stateChangeListenerList;

    public StateOwner() {
        this.stateChangeListenerList = new ArrayList<>();
    }

    public void addListener(StateChangeListener newStateChangeListener) {
        this.stateChangeListenerList.add(newStateChangeListener);
    }

    public void notifyChange() {
        //notify all registered listeners
        for (StateChangeListener stateChangeListener : stateChangeListenerList) {
            stateChangeListener.OnStateChanged(new Object(), new Object());
        }
    }
}
