package de.innoberger.hka.infm.parallelsys.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int waschstraßenCapacity = 5;
        int innenraumreinigungCapacity = 4;

        WaschPark waschPark = new WaschPark(waschstraßenCapacity, innenraumreinigungCapacity);
        Random random = new Random();

        // NACHMITTAG
        timePeriod(random, "Nachmittag", 3, 5);

        // RUSH HOUR
        timePeriod(random, "Rush Hour", 4, 7);

        // ABEND
        timePeriod(random, "Abend", 3, 5);
    }

    public static void timePeriod(Random random, String name, int minAutos, int maxAutos) {
        System.out.println("--- " + name + " hat begonnen");

        for (int i = 0; i < 12; i++) {
            int autoAmount = random.nextInt(3, maxAutos + 1);
            System.out.println(name + " Minute " + (i * 5) + ": " + autoAmount + " Autos kommen vorbei");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ie) {}
        }

        System.out.println(name + " ist vorbei");
    }

}