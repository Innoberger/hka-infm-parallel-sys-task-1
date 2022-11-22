package de.innoberger.hka.infm.parallelsys.waschpark.wasch;

public class WaschPark {
    private WaschOption waschstraßen, innenraumreinigung;

    public WaschPark(int waschstraßenCapacity, int innenraumreinigungCapacity) {
        this.waschstraßen = new WaschOption(WaschTyp.WASCHSTRAßE, waschstraßenCapacity);
        this.innenraumreinigung = new WaschOption(WaschTyp.INNENRAUMREINIGUNG, innenraumreinigungCapacity);
    }

    public WaschOption getWaschstraßen() {
        return this.waschstraßen;
    }

    public WaschOption getInnenraumreinigung() {
        return this.innenraumreinigung;
    }
}
