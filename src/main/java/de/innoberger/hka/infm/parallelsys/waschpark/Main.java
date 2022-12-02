package de.innoberger.hka.infm.parallelsys.waschpark;

import de.innoberger.hka.infm.parallelsys.waschpark.timeperiod.Abend;
import de.innoberger.hka.infm.parallelsys.waschpark.timeperiod.Nachmittag;
import de.innoberger.hka.infm.parallelsys.waschpark.timeperiod.RushHour;
import de.innoberger.hka.infm.parallelsys.waschpark.wasch.WaschPark;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        WaschPark waschPark = new WaschPark()
            .withWaschstraßenCapacity(5)
            .withInnenraumreinigungCapacity(4);

        Random random = new Random();

        // NACHMITTAG
        new Nachmittag(random, waschPark);

        // RUSH HOUR
        new RushHour(random, waschPark);

        // ABEND
        new Abend(random, waschPark);
    }

}