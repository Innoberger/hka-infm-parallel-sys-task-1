package de.innoberger.hka.infm.parallelsys.waschpark.timeperiod;

import de.innoberger.hka.infm.parallelsys.waschpark.wasch.WaschPark;

import java.util.Random;

public class Abend extends TimePeriod {

    public Abend(Random random, WaschPark waschPark) {
        super(random, waschPark, 3, 6, 1);
    }

}
