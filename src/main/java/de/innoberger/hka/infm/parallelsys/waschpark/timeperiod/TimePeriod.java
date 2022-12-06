package de.innoberger.hka.infm.parallelsys.waschpark.timeperiod;

import de.innoberger.hka.infm.parallelsys.waschpark.Auto;
import de.innoberger.hka.infm.parallelsys.waschpark.wasch.WaschPark;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public abstract class TimePeriod {

    private Random random;
    private WaschPark waschPark;
    private int minAutos, maxAutos, innenraumreinigungModulo, totalAutos;
    private ExecutorService pool;

    public TimePeriod(Random random, WaschPark waschPark, int minAutos, int maxAutos, int innenraumreinigungModulo) {
        this.random = random;
        this.waschPark = waschPark;
        this.minAutos = minAutos;
        this.maxAutos = maxAutos;
        this.innenraumreinigungModulo = innenraumreinigungModulo;
        this.totalAutos = 0;
        this.pool = Executors.newFixedThreadPool(this.maxAutos);
    }

    public void execute() {
        System.out.printf("--- %s hat begonnen%s", this.getName(), System.lineSeparator());

        IntStream.range(0, 12).forEach(this::runInterval);
        this.pool.shutdown();

        System.out.printf("%s ist vorbei%s", this.getName(), System.lineSeparator());
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    private void runInterval(int interval) {
        int autoAmount = random.nextInt(this.minAutos, this.maxAutos + 1);

        System.out.printf("%s Minute %02d: %d Autos kommen vorbei%s", this.getName(), interval * 5, autoAmount, System.lineSeparator());

        IntStream.range(0, autoAmount).forEach(autoCounter -> this.pool.execute(this.createAuto(interval, autoCounter)));
        this.totalAutos += autoAmount;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {}
    }

    private Auto createAuto(int timeCounter, int autoCounter) {
        return new Auto(this.random)
            .withName(this.buildAutoName(timeCounter, autoCounter))
            .inWaschpark(this.waschPark)
            .auchInnenraumreinigung(this.buildAutoAuchInnenraumreinigung(autoCounter));
    }

    private String buildAutoName(int interval, int autoCounter) {
        return String.format("Auto@%s:%02d#%d", this.getName(), interval * 5, autoCounter);
    }

    private boolean buildAutoAuchInnenraumreinigung(int autoCounter) {
        return (this.totalAutos + autoCounter) % this.innenraumreinigungModulo == 0;
    }

}
