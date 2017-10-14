package com.crw.study.java.multithread.demo15;

/**
 * P107
 * 死锁测试
 * jstack命令
 */
public class Run_deadLock {
    public static void main(String[] args) {
        try {
            DealThread t1 = new DealThread();
            t1.setFlag("a");
            Thread thread1 = new Thread(t1);
            thread1.start();
            Thread.sleep(100);
            t1.setFlag("b");
            Thread thread2 = new Thread(t1);
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


/*
输出：
username = a
username = b

---------------------------


$ jps
9488 Jps
10180
8700 Launcher

(启动Run_deadLock的main方法)

$ jps
10180
9780 Launcher
3400 Run_deadLock
8632 Jps

$ jstack -l 3400
2017-10-14 21:14:00
Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.60-b23 mixed mode):

"DestroyJavaVM" #14 prio=5 os_prio=0 tid=0x0000000001f38000 nid=0x2140 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"Thread-1" #13 prio=5 os_prio=0 tid=0x0000000058c9d000 nid=0x241c waiting for monitor entry [0x000000005b29e000]
   java.lang.Thread.State: BLOCKED (on object monitor)
        at com.crw.study.java.multithread.demo15.DealThread.run(DealThread.java:38)
        - waiting to lock <0x00000000d8582d48> (a java.lang.Object)
        - locked <0x00000000d8582d58> (a java.lang.Object)
        at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
        - None

"Thread-0" #12 prio=5 os_prio=0 tid=0x0000000058c8b000 nid=0x2638 waiting for monitor entry [0x000000005b14f000]
   java.lang.Thread.State: BLOCKED (on object monitor)
        at com.crw.study.java.multithread.demo15.DealThread.run(DealThread.java:24)
        - waiting to lock <0x00000000d8582d58> (a java.lang.Object)
        - locked <0x00000000d8582d48> (a java.lang.Object)
        at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
        - None

"Service Thread" #11 daemon prio=9 os_prio=0 tid=0x0000000058bc3800 nid=0x1d60 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"C1 CompilerThread3" #10 daemon prio=9 os_prio=2 tid=0x0000000058b2f000 nid=0x1054 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"C2 CompilerThread2" #9 daemon prio=9 os_prio=2 tid=0x0000000058b22000 nid=0x1b18 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"C2 CompilerThread1" #8 daemon prio=9 os_prio=2 tid=0x0000000058b18800 nid=0xe80 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"C2 CompilerThread0" #7 daemon prio=9 os_prio=2 tid=0x0000000058b15800 nid=0x1718 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"Monitor Ctrl-Break" #6 daemon prio=5 os_prio=0 tid=0x0000000058b14000 nid=0x1f94 runnable [0x000000005a4de000]
   java.lang.Thread.State: RUNNABLE
        at java.net.SocketInputStream.socketRead0(Native Method)
        at java.net.SocketInputStream.socketRead(SocketInputStream.java:116)
        at java.net.SocketInputStream.read(SocketInputStream.java:170)
        at java.net.SocketInputStream.read(SocketInputStream.java:141)
        at sun.nio.cs.StreamDecoder.readBytes(StreamDecoder.java:284)
        at sun.nio.cs.StreamDecoder.implRead(StreamDecoder.java:326)
        at sun.nio.cs.StreamDecoder.read(StreamDecoder.java:178)
        - locked <0x00000000d8626b70> (a java.io.InputStreamReader)
        at java.io.InputStreamReader.read(InputStreamReader.java:184)
        at java.io.BufferedReader.fill(BufferedReader.java:161)
        at java.io.BufferedReader.readLine(BufferedReader.java:324)
        - locked <0x00000000d8626b70> (a java.io.InputStreamReader)
        at java.io.BufferedReader.readLine(BufferedReader.java:389)
        at com.intellij.rt.execution.application.AppMainV2$1.run(AppMainV2.java:64)

   Locked ownable synchronizers:
        - None

"Attach Listener" #5 daemon prio=5 os_prio=2 tid=0x0000000058ac3000 nid=0x1c64 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"Signal Dispatcher" #4 daemon prio=9 os_prio=2 tid=0x0000000058acf800 nid=0x2158 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"Finalizer" #3 daemon prio=8 os_prio=1 tid=0x0000000057b10800 nid=0x1bf4 in Object.wait() [0x0000000059f6f000]
   java.lang.Thread.State: WAITING (on object monitor)
        at java.lang.Object.wait(Native Method)
        - waiting on <0x00000000d83870b8> (a java.lang.ref.ReferenceQueue$Lock)
        at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
        - locked <0x00000000d83870b8> (a java.lang.ref.ReferenceQueue$Lock)
        at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:164)
        at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:209)

   Locked ownable synchronizers:
        - None

"Reference Handler" #2 daemon prio=10 os_prio=2 tid=0x0000000057b08000 nid=0xe8c in Object.wait() [0x0000000059d7f000]
   java.lang.Thread.State: WAITING (on object monitor)
        at java.lang.Object.wait(Native Method)
        - waiting on <0x00000000d8386af8> (a java.lang.ref.Reference$Lock)
        at java.lang.Object.wait(Object.java:502)
        at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:157)
        - locked <0x00000000d8386af8> (a java.lang.ref.Reference$Lock)

   Locked ownable synchronizers:
        - None

"VM Thread" os_prio=2 tid=0x0000000058a62000 nid=0xf20 runnable

"GC task thread#0 (ParallelGC)" os_prio=0 tid=0x0000000001f4d000 nid=0xd68 runnable

"GC task thread#1 (ParallelGC)" os_prio=0 tid=0x0000000001f4e800 nid=0x1d48 runnable

"GC task thread#2 (ParallelGC)" os_prio=0 tid=0x0000000001f50000 nid=0xe20 runnable

"GC task thread#3 (ParallelGC)" os_prio=0 tid=0x0000000001f54000 nid=0x1cd4 runnable

"GC task thread#4 (ParallelGC)" os_prio=0 tid=0x0000000001f57000 nid=0x1704 runnable

"GC task thread#5 (ParallelGC)" os_prio=0 tid=0x0000000001f58000 nid=0x1c88 runnable

"GC task thread#6 (ParallelGC)" os_prio=0 tid=0x0000000001f59800 nid=0x1f98 runnable

"GC task thread#7 (ParallelGC)" os_prio=0 tid=0x0000000001f5a800 nid=0x10b8 runnable

"VM Periodic Task Thread" os_prio=2 tid=0x0000000058b50800 nid=0x150c waiting on condition

JNI global references: 33


Found one Java-level deadlock:
=============================
"Thread-1":
  waiting to lock monitor 0x0000000057b0e598 (object 0x00000000d8582d48, a java.lang.Object),
  which is held by "Thread-0"
"Thread-0":
  waiting to lock monitor 0x0000000057b0a5a8 (object 0x00000000d8582d58, a java.lang.Object),
  which is held by "Thread-1"

Java stack information for the threads listed above:
===================================================
"Thread-1":
        at com.crw.study.java.multithread.demo15.DealThread.run(DealThread.java:38)
        - waiting to lock <0x00000000d8582d48> (a java.lang.Object)
        - locked <0x00000000d8582d58> (a java.lang.Object)
        at java.lang.Thread.run(Thread.java:745)
"Thread-0":
        at com.crw.study.java.multithread.demo15.DealThread.run(DealThread.java:24)
        - waiting to lock <0x00000000d8582d58> (a java.lang.Object)
        - locked <0x00000000d8582d48> (a java.lang.Object)
        at java.lang.Thread.run(Thread.java:745)

Found 1 deadlock.




 */