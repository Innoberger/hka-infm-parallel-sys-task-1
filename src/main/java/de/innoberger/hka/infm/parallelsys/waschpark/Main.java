package de.innoberger.hka.infm.parallelsys.waschpark;

import de.innoberger.hka.infm.parallelsys.waschpark.timeperiod.Abend;
import de.innoberger.hka.infm.parallelsys.waschpark.timeperiod.Nachmittag;
import de.innoberger.hka.infm.parallelsys.waschpark.timeperiod.RushHour;
import de.innoberger.hka.infm.parallelsys.waschpark.wasch.WaschPark;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int waschstraßenCapacity = 5;
        int innenraumreinigungCapacity = 4;

        WaschPark waschPark = new WaschPark(waschstraßenCapacity, innenraumreinigungCapacity);
        Random random = new Random();

        // NACHMITTAG
        new Nachmittag(random, waschPark);

        // RUSH HOUR
        new RushHour(random, waschPark);

        // ABEND
        new Abend(random, waschPark);
    }

}