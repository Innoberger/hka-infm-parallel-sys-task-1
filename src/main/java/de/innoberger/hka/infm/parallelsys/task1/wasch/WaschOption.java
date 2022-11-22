package de.innoberger.hka.infm.parallelsys.task1.wasch;

import de.innoberger.hka.infm.parallelsys.task1.Auto;

public class WaschOption {

    private WaschTyp type;
    private int capacity;

    public WaschOption(WaschTyp type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public synchronized void enter(Auto auto) {
        while (this.capacity == 0) {
            try {
                this.wait();
            } catch (InterruptedException ie) {}
        }

        this.capacity--;
        System.out.println("Reinigung für Auto '" + auto.getName() + "' in '" + this.type.toString() + "' gestartet. Freie Kapazität: " + this.capacity);
    }

    public synchronized void leave(Auto auto) {
        this.capacity++;
        System.out.println("Reinigung für Auto '" + auto.getName() + "' in '" + this.type.toString() + "' beendet. Freie Kapazität: " + this.capacity);
        this.notify();
    }
}
