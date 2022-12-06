package de.innoberger.hka.infm.parallelsys.waschpark;

import de.innoberger.hka.infm.parallelsys.waschpark.wasch.WaschPark;
import de.innoberger.hka.infm.parallelsys.waschpark.wasch.WaschTyp;

import java.util.Random;

public class Auto implements Runnable {

    private Random random;
    private String name;
    private WaschPark waschPark;
    private int waschstraßeDuration, innenraumreinigungDuration;

    public Auto(Random random) {
        this.random = random;
        this.waschstraßeDuration = WaschTyp.WASCHSTRAßE.getRandomDuration(this.random);
   }

    public Auto withName(String name) {
        this.name = name;

        return this;
    }
    public Auto inWaschpark(WaschPark waschPark) {
        this.waschPark = waschPark;

        return this;
    }

    public Auto auchInnenraumreinigung(boolean auchInnenraumreinigung) {
        this.innenraumreinigungDuration = auchInnenraumreinigung ? WaschTyp.INNENRAUMREINIGUNG.getRandomDuration(this.random) : 0;

        return this;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.name);

        System.out.printf("Auto '%s' ist angekommen%s", Thread.currentThread().getName(), System.lineSeparator());

        try {
            this.doWaschstraße();
            this.doInnenraumreinigung();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("Auto '%s' wurde komplett gewaschen%s", Thread.currentThread().getName(), System.lineSeparator());
    }

    private void doWaschstraße() throws InterruptedException {
        waschPark.getWaschstraßen().enter(this);
        Thread.sleep((long) waschstraßeDuration * 1000L);
        waschPark.getWaschstraßen().leave(this, waschstraßeDuration);
    }

    private void doInnenraumreinigung() throws InterruptedException {
        if (this.innenraumreinigungDuration == 0)
            return;

        waschPark.getInnenraumreinigung().enter(this);
        Thread.sleep((long) innenraumreinigungDuration * 1000L);
        waschPark.getInnenraumreinigung().leave(this, innenraumreinigungDuration);
    }

    public String getName() {
        return this.name;
    }

}
