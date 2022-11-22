package de.innoberger.hka.infm.parallelsys.task1.timeperiod;

import de.innoberger.hka.infm.parallelsys.task1.Auto;
import de.innoberger.hka.infm.parallelsys.task1.wasch.WaschTyp;

import java.util.Random;

public abstract class TimePeriod {

    private Random random;
    private int minAutos, maxAutos, innenraumreinigungModulo;

    public TimePeriod(int minAutos, int maxAutos, int innenraumreinigungModulo) {
        this.random = new Random();
        this.minAutos = minAutos;
        this.maxAutos = maxAutos;
        this.innenraumreinigungModulo = innenraumreinigungModulo;

        System.out.println("--- " + this.getName() + " hat begonnen");

        for (int i = 0; i < 12; i++) {
            int autoAmount = random.nextInt(this.minAutos, this.maxAutos + 1);
            System.out.println(this.getName() + " Minute " + (i * 5) + ": " + autoAmount + " Autos kommen vorbei");

            for (int j = 0; j < autoAmount; j++) {
                this.wascheAuto(WaschTyp.WASCHSTRAßE);

                if (j % this.innenraumreinigungModulo == 0)
                    this.wascheAuto(WaschTyp.INNENRAUMREINIGUNG);
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ie) {}
        }

        System.out.println(this.getName() + " ist vorbei");
    }

    private void wascheAuto(WaschTyp type) {
        int duration = type.getDurations()[this.random.nextInt(type.getDurations().length)];
        Auto auto = new Auto();

        auto.start();
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

}
