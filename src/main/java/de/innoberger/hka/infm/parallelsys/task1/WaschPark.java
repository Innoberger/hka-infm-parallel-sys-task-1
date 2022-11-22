package de.innoberger.hka.infm.parallelsys.task1;

public class WaschPark {
    private WaschOption waschstraßen, innenraumreinigung;

    public WaschPark(int waschstraßenCapacity, int innenraumreinigungCapacity) {
        this.waschstraßen = new WaschOption(WaschTyp.WASCHSTRAßE, waschstraßenCapacity);
        this.innenraumreinigung = new WaschOption(WaschTyp.INNENRAUMREINIGUNG, innenraumreinigungCapacity);
    }
}
