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
        System.out.printf("Reinigung für Auto '%s' in '%s' gestartet. Neue freie Kapazität: %d%s", auto.getName(), this.type.toString(), this.capacity, System.lineSeparator());
    }

    public synchronized void leave(Auto auto, int duration) {
        this.capacity++;
        System.out.printf("Reinigung für Auto '%s' in '%s' beendet (Dauer: %d Minuten). Neue freie Kapazität: %d%s", auto.getName(), this.type.toString(), duration, this.capacity, System.lineSeparator());
        this.notify();
    }
}
