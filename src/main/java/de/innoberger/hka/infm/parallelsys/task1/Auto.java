package de.innoberger.hka.infm.parallelsys.task1;

public class Auto extends Thread {

    @Override
    public void run() {
        System.out.println("Auto '" + this.getName() + "' konstruiert");

        System.out.println("Auto '" + this.getName() + "' destruiert");
    }

}
