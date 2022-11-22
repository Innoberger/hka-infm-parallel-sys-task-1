package de.innoberger.hka.infm.parallelsys.waschpark.timeperiod;

import de.innoberger.hka.infm.parallelsys.waschpark.wasch.WaschPark;

import java.util.Random;

public class Nachmittag extends TimePeriod {

    public Nachmittag(Random random, WaschPark waschPark) {
        super(random, waschPark, 3, 5, 3);
    }

}
