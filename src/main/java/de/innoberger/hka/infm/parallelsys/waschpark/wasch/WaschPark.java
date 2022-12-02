package de.innoberger.hka.infm.parallelsys.waschpark.wasch;

public class WaschPark {
    private WaschOption waschstraßen, innenraumreinigung;

    public WaschPark withWaschstraßenCapacity(int waschstraßenCapacity) {
        this.waschstraßen = new WaschOption(WaschTyp.WASCHSTRAßE, waschstraßenCapacity);

        return this;
    }

    public WaschPark withInnenraumreinigungCapacity(int innenraumreinigungCapacity) {
        this.innenraumreinigung = new WaschOption(WaschTyp.INNENRAUMREINIGUNG, innenraumreinigungCapacity);

        return this;
    }

    public WaschOption getWaschstraßen() {
        return this.waschstraßen;
    }

    public WaschOption getInnenraumreinigung() {
        return this.innenraumreinigung;
    }
}
