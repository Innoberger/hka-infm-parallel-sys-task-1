package de.innoberger.hka.infm.parallelsys.waschpark.timeperiod;

import de.innoberger.hka.infm.parallelsys.waschpark.Auto;
import de.innoberger.hka.infm.parallelsys.waschpark.wasch.WaschPark;

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

        int totalAutos = 0;

        for (int i = 0; i < 12; i++) {
            int autoAmount = random.nextInt(this.minAutos, this.maxAutos + 1);
            String minuteString = String.format("%02d", i * 5);

            System.out.println(this.getName() + " Minute " + minuteString + ": " + autoAmount + " Autos kommen vorbei");

            for (int j = 0; j < autoAmount; j++) {
                boolean auchInnenraumreinigung = (totalAutos + j) % this.innenraumreinigungModulo == 0;

                Auto auto = new Auto(this.random, this.waschPark, "Auto@" + this.getName() + ":" + minuteString + "#" + j, auchInnenraumreinigung);

                auto.start();
            }

            totalAutos += autoAmount;

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
