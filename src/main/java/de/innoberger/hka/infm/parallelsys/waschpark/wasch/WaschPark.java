package de.innoberger.hka.infm.parallelsys.waschpark.wasch;

public class WaschPark {
    private WaschOption waschstrassen, innenraumreinigung;

    public WaschPark withWaschstrassenCapacity(int waschstrassenCapacity) {
        this.waschstrassen = new WaschOption()
            .ofType(WaschTyp.WASCHSTRASSE)
            .withCapacity(waschstrassenCapacity);

        return this;
    }

    public WaschPark withInnenraumreinigungCapacity(int innenraumreinigungCapacity) {
        this.innenraumreinigung = new WaschOption()
            .ofType(WaschTyp.INNENRAUMREINIGUNG)
            .withCapacity(innenraumreinigungCapacity);

        return this;
    }

    public WaschOption getWaschstrassen() {
        return this.waschstrassen;
    }

    public WaschOption getInnenraumreinigung() {
        return this.innenraumreinigung;
    }
}
