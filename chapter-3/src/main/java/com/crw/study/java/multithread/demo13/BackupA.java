package com.crw.study.java.multithread.demo13;

public class BackupA extends Thread {
    private DBTools dbTools;

    public BackupA(DBTools dbTools) {
        super();
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backupA();
    }
}
