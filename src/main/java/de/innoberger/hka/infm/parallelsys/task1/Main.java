package de.innoberger.hka.infm.parallelsys.task1;

import de.innoberger.hka.infm.parallelsys.task1.timeperiod.Abend;
import de.innoberger.hka.infm.parallelsys.task1.timeperiod.Nachmittag;
import de.innoberger.hka.infm.parallelsys.task1.timeperiod.RushHour;
import de.innoberger.hka.infm.parallelsys.task1.wasch.WaschPark;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int waschstraßenCapacity = 5;
        int innenraumreinigungCapacity = 4;

        WaschPark waschPark = new WaschPark(waschstraßenCapacity, innenraumreinigungCapacity);
        Random random = new Random();

        // NACHMITTAG
        new Nachmittag();

        // RUSH HOUR
        new RushHour();

        // ABEND
        new Abend();
    }

}