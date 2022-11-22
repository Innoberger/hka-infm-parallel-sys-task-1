package de.innoberger.hka.infm.parallelsys.task1.timeperiod;

import de.innoberger.hka.infm.parallelsys.task1.Auto;
import de.innoberger.hka.infm.parallelsys.task1.wasch.WaschPark;

import java.util.Random;

public abstract class TimePeriod {

    private Random random;
    private WaschPark waschPark;
    private int minAutos, maxAutos, innenraumreinigungModulo;

    public TimePeriod(Random random, WaschPark waschPark, int minAutos, int maxAutos, int innenraumreinigungModulo) {
        this.random = random;
        this.waschPark = waschPark;
        this.minAutos = minAutos;
        this.maxAutos = maxAutos;
        this.innenraumreinigungModulo = innenraumreinigungModulo;

        System.out.println("--- " + this.getName() + " hat begonnen");

        for (int i = 0; i < 12; i++) {
            int autoAmount = random.nextInt(this.minAutos, this.maxAutos + 1);
            System.out.println(this.getName() + " Minute " + (i * 5) + ": " + autoAmount + " Autos kommen vorbei");

            for (int j = 0; j < autoAmount; j++) {
                boolean auchInnenraumreinigung = j % this.innenraumreinigungModulo == 0;

                Auto auto = new Auto(this.random, this.waschPark, auchInnenraumreinigung);

                auto.start();
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ie) {}
        }

        System.out.println(this.getName() + " ist vorbei");
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

}
