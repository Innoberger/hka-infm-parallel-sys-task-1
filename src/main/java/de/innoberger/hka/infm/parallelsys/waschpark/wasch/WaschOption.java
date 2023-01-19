package de.innoberger.hka.infm.parallelsys.waschpark.wasch;

import de.innoberger.hka.infm.parallelsys.waschpark.Auto;

import java.util.concurrent.Semaphore;

public class WaschOption {

    private WaschTyp type;
    private Semaphore semaphore;

    public WaschOption ofType(WaschTyp type) {
        this.type = type;

        return this;
    }

    public WaschOption withCapacity(int capacity) {
        this.semaphore = new Semaphore(capacity);

        return this;
    }

    public void enter(Auto auto) {
        try {
            this.semaphore.acquire();
        } catch (InterruptedException ignored) {
        } finally {
            System.out.printf("Reinigung für Auto '%s' in '%s' gestartet. Neue freie Kapazität: %d%s", auto.getName(), this.type.toString(), this.semaphore.availablePermits(), System.lineSeparator());
        }
    }

    public void leave(Auto auto, int duration) {
        this.semaphore.release();
        System.out.printf("Reinigung für Auto '%s' in '%s' beendet (Dauer: %d Minuten). Neue freie Kapazität: %d%s", auto.getName(), this.type.toString(), duration, this.semaphore.availablePermits(), System.lineSeparator());
    }
}
