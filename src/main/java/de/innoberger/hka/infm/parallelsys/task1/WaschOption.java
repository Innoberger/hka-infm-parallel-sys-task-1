package de.innoberger.hka.infm.parallelsys.task1;

public class WaschOption {

    private WaschTyp type;
    private int capacity;

    public WaschOption(WaschTyp type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    private synchronized boolean tryToEnter() {
        boolean success = false;

        if (this.capacity > 0) {
            this.capacity--;
            success = true;
        }

        return success;
    }

    public void enter() {
        while(!tryToEnter());
    }

    public synchronized void leave() {
        this.capacity++;
    }
}
