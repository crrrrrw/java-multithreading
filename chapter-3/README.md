# 第3章 线程间通信
需掌握如下技术点:
- 使用 wait/notify 实现线程间的通信
- 生产者/消费者模式的实现
- 方法join的使用
- ThreadLocal类的使用


小总结：  
1. wait()是Object的方法，调用该方法前必须获得该对象的对象级别锁，没有锁会抛IllegalMonitorStateException
2. notify()也必须在同步方法或同步代码块中调用，否则也会抛IllegalMonitorStateException
3. 用一句话总结wait和notify:wait使线程停止，而notify使停止的线程继续运行。
4. notify() 调用后，并不会立即释放对象锁，而是退出synchronized代码块后
5. Java线程的5种状态及切换.
6. 多生产与多消费情况，尽量使用 notifyAll() 防止出现假死情况。
7. 使用管道流实现线程间通信
8. join()方法作用是使所属的线程对象x正常执行run()方法中的任务，而使当前线程进行无限期的阻塞，等待x线程销毁后
再继续执行线程z后面的代码。
9. join()与synchronized区别是：join在内部使用wait()方法进行等待，而synchronized关键字使用的是“对象监视器”原理作为同步。
10. join(long) 与 sleep(long) 区别：join(long)内部使用wait(long)方法来实现，所以具有释放锁的特点。
而sleep(long)方法却不释放锁。
11. ThreadLocal:解决每个线程各自的共享变量问题。(源码阅读，ThreadLocalMap)
12. 类InheritableThreadLocal使用，值继承，子线程从父线程取得值

### Java线程的5种状态及切换
#### 0.Java中的线程的生命周期大体可分为5种状态。
1. 新建(NEW)：新创建了一个线程对象。
2. 可运行(RUNNABLE)：线程对象创建后，其他线程(比如main线程）调用了该对象的start()方法。该状态的线程位于可运行线程池中，等待被线程调度选中，获取cpu 的使用权 。
3. 运行(RUNNING)：可运行状态(runnable)的线程获得了cpu 时间片（timeslice） ，执行程序代码。
4. 阻塞(BLOCKED)：阻塞状态是指线程因为某种原因放弃了cpu 使用权，也即让出了cpu timeslice，暂时停止运行。直到线程进入可运行(runnable)状态，才有机会再次获得cpu timeslice 转到运行(running)状态。阻塞的情况分三种： 
(一). 等待阻塞：运行(running)的线程执行o.wait()方法，JVM会把该线程放入等待队列(waitting queue)中。
(二). 同步阻塞：运行(running)的线程在获取对象的同步锁时，若该同步锁被别的线程占用，则JVM会把该线程放入锁池(lock pool)中。
(三). 其他阻塞：运行(running)的线程执行Thread.sleep(long ms)或t.join()方法，或者发出了I/O请求时，JVM会把该线程置为阻塞状态。当sleep()状态超时、join()等待线程终止或者超时、或者I/O处理完毕时，线程重新转入可运行(runnable)状态。
5. 死亡(DEAD)：线程run()、main() 方法执行结束，或者因异常退出了run()方法，则该线程结束生命周期。死亡的线程不可再次复生。

#### 1.线程的状态图
![image](http://dl.iteye.com/upload/picture/pic/116719/7e76cc17-0ad5-3ff3-954e-1f83463519d1.jpg)

#### 2.线程的状态详解
##### 1.初始状态
实现Runnable接口和继承Thread可以得到一个线程类，new一个实例出来，线程就进入了初始状态
##### 2.可运行状态
1. 可运行状态只是说你资格运行，调度程序没有挑选到你， 你就永远是可运行状态。
2. 调用线程的start()方法，此线程进入可运行状态。
3. 当前线程sleep()方法结束，其他线程join()结束，等待 用户输入完毕，某个线程拿到对象锁，这些线程也将进入可运行状态。
4. 当前线程时间片用完了，调用当前线程的yield()方法，当前线程进入可运行状态。
5. 锁池里的线程拿到对象锁后，进入可运行状态。

##### 3.运行状态
线程调度程序从可运行池中选择一个线程作为当前线程时线程所处的状态。这也是线程进入运行状态的唯一一种方式。

##### 4.死亡状态
1. 当线程的run()方法完成时，或者主线程的main()方法完成时，我们就认为它死去。这个线程对象也许是活的，但是，它已经不是一个单独执行的线程。线程一旦死亡，就不能复生。
2. 在一个死去的线程上调用start()方法，会抛出java.lang.IllegalThreadStateException异常。

##### 5.阻塞状态
1. 当前线程T调用Thread.sleep()方法，当前线程进入阻塞状态。
2. 运行在当前线程里的其它线程t2调用join()方法，当前线程进入阻塞状态。
3. 等待用户输入的时候，当前线程进入阻塞状态。
