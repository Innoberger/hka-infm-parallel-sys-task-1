package de.innoberger.hka.infm.parallelsys.waschpark;

import de.innoberger.hka.infm.parallelsys.waschpark.wasch.WaschPark;
import de.innoberger.hka.infm.parallelsys.waschpark.wasch.WaschTyp;

import java.util.Random;

public class Auto extends Thread {

    private WaschPark waschPark;
    private int waschstraßeDuration, innenraumreinigungDuration;

    public Auto(Random random, WaschPark waschPark, String name, boolean auchInnenraumreinigung) {
        super(name);

        this.waschPark = waschPark;
        this.waschstraßeDuration = WaschTyp.WASCHSTRAßE.getDurations()[random.nextInt(WaschTyp.WASCHSTRAßE.getDurations().length)];
        this.innenraumreinigungDuration = auchInnenraumreinigung ? WaschTyp.INNENRAUMREINIGUNG.getDurations()[random.nextInt(WaschTyp.INNENRAUMREINIGUNG.getDurations().length)] : 0;
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
