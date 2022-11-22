package de.innoberger.hka.infm.parallelsys.task1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int waschstraßenCapacity = 5;
        int innenraumreinigungCapacity = 4;

        WaschPark waschPark = new WaschPark(waschstraßenCapacity, innenraumreinigungCapacity);
        List<Auto> autos = new ArrayList<Auto>();
    }

}