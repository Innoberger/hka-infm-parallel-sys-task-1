package de.innoberger.hka.infm.parallelsys.waschpark;

import de.innoberger.hka.infm.parallelsys.waschpark.wasch.WaschPark;
import de.innoberger.hka.infm.parallelsys.waschpark.wasch.WaschTyp;

import java.util.Random;

public class Auto extends Thread {

    private Random random;
    private WaschPark waschPark;
    private int waschstraßeDuration, innenraumreinigungDuration;

    public Auto(Random random) {
        this.random = random;
        this.waschstraßeDuration = WaschTyp.WASCHSTRAßE.getDurations()[random.nextInt(WaschTyp.WASCHSTRAßE.getDurations().length)];
   }

    public Auto withName(String name) {
        this.setName(name);

        return this;
    }
    public Auto inWaschpark(WaschPark waschPark) {
        this.waschPark = waschPark;

        return this;
    }

    public Auto auchInnenraumreinigung(boolean auchInnenraumreinigung) {
        this.innenraumreinigungDuration = auchInnenraumreinigung ? WaschTyp.INNENRAUMREINIGUNG.getDurations()[this.random.nextInt(WaschTyp.INNENRAUMREINIGUNG.getDurations().length)] : 0;

        return this;
    }

    @Override
    public void run() {
        System.out.printf("Auto '%s' ist angekommen%s", this.getName(), System.lineSeparator());

        try {
            this.doWaschstraße();
            this.doInnenraumreinigung();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("Auto '%s' wurde komplett gewaschen%s", this.getName(), System.lineSeparator());
    }

    private void doWaschstraße() throws InterruptedException {
        waschPark.getWaschstraßen().enter(this);
        this.sleep((long) waschstraßeDuration * 1000L);
        waschPark.getWaschstraßen().leave(this, waschstraßeDuration);
    }

    private void doInnenraumreinigung() throws InterruptedException {
        if (this.innenraumreinigungDuration == 0)
            return;

        waschPark.getInnenraumreinigung().enter(this);
        this.sleep((long) innenraumreinigungDuration * 1000L);
        waschPark.getInnenraumreinigung().leave(this, innenraumreinigungDuration);
    }

}
