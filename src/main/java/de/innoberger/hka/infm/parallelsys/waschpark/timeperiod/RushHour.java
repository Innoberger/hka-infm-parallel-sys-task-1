package de.innoberger.hka.infm.parallelsys.waschpark.timeperiod;

import de.innoberger.hka.infm.parallelsys.waschpark.wasch.WaschPark;

import java.util.Random;

public class RushHour extends TimePeriod {

    public RushHour(Random random, WaschPark waschPark) {
        super(random, waschPark, 4, 7, 4);
    }

}
