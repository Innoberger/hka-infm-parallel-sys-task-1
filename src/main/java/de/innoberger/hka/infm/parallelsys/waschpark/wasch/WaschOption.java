package de.innoberger.hka.infm.parallelsys.waschpark.wasch;

import de.innoberger.hka.infm.parallelsys.waschpark.Auto;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class WaschOption {

    private WaschTyp type;
    private int capacity;
    private final ReentrantLock lock;
    private final Condition condition;

    public WaschOption() {
        this.lock = new ReentrantLock();
        this.condition = this.lock.newCondition();
    }

    public WaschOption ofType(WaschTyp type) {
        this.type = type;

        return this;
    }

    public WaschOption withCapacity(int capacity) {
        this.capacity = capacity;

        return this;
    }

    public void enter(Auto auto) {
        this.lock.lock();

        try {
            while (this.capacity == 0) {
                try {
                    this.condition.await();
                } catch (InterruptedException ie) {}
            }

            this.capacity--;
            System.out.printf("Reinigung für Auto '%s' in '%s' gestartet. Neue freie Kapazität: %d%s", auto.getName(), this.type.toString(), this.capacity, System.lineSeparator());
        } finally {
            this.lock.unlock();
        }
    }

    public void leave(Auto auto, int duration) {
        this.lock.lock();

        try {
            this.capacity++;
            System.out.printf("Reinigung für Auto '%s' in '%s' beendet (Dauer: %d Minuten). Neue freie Kapazität: %d%s", auto.getName(), this.type.toString(), duration, this.capacity, System.lineSeparator());
            this.condition.signal();
        } finally {
            this.lock.unlock();
        }
    }
}
