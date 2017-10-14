package com.crw.study.java.multithread.demo10;

public class Service2 {
    private String usernameParam;
    private String passwordParam;

    public void setUsernamePassword(String username, String password) {
        String anyString = new String();
        synchronized (anyString) {
            try {
                System.out.println("线程名称为：" + Thread.currentThread().getName() +
                        "在" + System.currentTimeMillis() + "进入同步代码块");
                usernameParam = username;
                Thread.sleep(3000);
                passwordParam = password;
                System.out.println("线程名称为：" + Thread.currentThread().getName() +
                        "在" + System.currentTimeMillis() + "离开同步代码块");            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
