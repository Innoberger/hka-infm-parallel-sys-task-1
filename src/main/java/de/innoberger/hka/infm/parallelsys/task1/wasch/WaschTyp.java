package de.innoberger.hka.infm.parallelsys.task1.wasch;

public enum WaschTyp {

    WASCHSTRAßE(new int[] { 5, 6, 7, 8, 9, 10 }),
    INNENRAUMREINIGUNG(new int[] { 50, 10, 15 });

    private int[] durations;

    WaschTyp(int[] durations) {
        this.durations = durations;
    }

    public int[] getDurations() {
        return this.durations;
    }

}
