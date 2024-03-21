package com.swaraj.projectx.lambda;

@FunctionalInterface
interface StateChangeListener {
    void OnStateChanged(Object oldState, Object newState);
}
