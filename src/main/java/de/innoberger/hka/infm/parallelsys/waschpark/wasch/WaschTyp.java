package de.innoberger.hka.infm.parallelsys.waschpark.wasch;

public enum WaschTyp {

    WASCHSTRAßE(new int[] { 5, 6, 7, 8, 9, 10 }),
    INNENRAUMREINIGUNG(new int[] { 5, 10, 15 });

    private int[] durations;

    WaschTyp(int[] durations) {
        this.durations = durations;
    }

    public int[] getDurations() {
        return this.durations;
    }

}
