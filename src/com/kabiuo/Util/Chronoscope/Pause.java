package com.kabiuo.Util.Chronoscope;

public class Pause extends Thread {
    private Start ss;

    public Pause(Start ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        ss.interrupt();
    }

}
