package com.itheima;

/**
 * @author ydd
 * @project IntelliJ IDEA
 */
public class ThreadLocalTest {
    private static ThreadLocal<String> local = new ThreadLocal<>();
    public static void main(String[] args) {
        local.set("Main Message");
        System.out.println(Thread.currentThread().getName()+":"+local.get());
        local.remove();
        System.out.println(Thread.currentThread().getName()+":"+local.get());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+":"+local.get());
            }
        }).start();

    }
}
