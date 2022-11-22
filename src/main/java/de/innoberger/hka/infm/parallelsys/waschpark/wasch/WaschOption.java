package de.innoberger.hka.infm.parallelsys.waschpark.wasch;

import de.innoberger.hka.infm.parallelsys.waschpark.Auto;

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
        System.out.println("Reinigung für Auto '" + auto.getName() + "' in '" + this.type.toString() + "' gestartet. Neue freie Kapazität: " + this.capacity);
    }

    public synchronized void leave(Auto auto, int duration) {
        this.capacity++;
        System.out.println("Reinigung für Auto '" + auto.getName() + "' in '" + this.type.toString() + "' beendet (Dauer: " + duration + " Minuten). Neue freie Kapazität: " + this.capacity);
        this.notify();
    }
}
