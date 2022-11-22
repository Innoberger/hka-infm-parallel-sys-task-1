package de.innoberger.hka.infm.parallelsys.task1.timeperiod;

import de.innoberger.hka.infm.parallelsys.task1.wasch.WaschPark;

import java.util.Random;

public class Nachmittag extends TimePeriod {

    public Nachmittag(Random random, WaschPark waschPark) {
        super(random, waschPark, 3, 5, 3);
    }

}
