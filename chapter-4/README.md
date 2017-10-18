# 第4章 Lock的使用
需掌握如下技术点:
- ReentrantLock 类的使用
- ReentrantReadWriteLock 类的使用

小总结
1. ReentrantLock加锁使用 lock(), unlock().
2. 正确使用Condition实现等待/通知(await(),await(long time, TimeUnit unit), signal(), signalAll())
3. 公平所(FIFO)与非公平锁(锁抢占机制)
4.  int getHoldCount() - 查询当前线程保持此锁定的个数，即调用lock()方法的次数  
    int getQueueLength() - 返回正在等待获取此锁定的线程估计数  
    int getWaitQueueLength(Condition condition) - 返回等待与此锁定相关的给定条件Condition的线程估计数  
5.  boolean hasQueueThread(Thread thread) - 查询指定的线程是否正在等待获取此锁定  
    boolean hasQueueThreads() - 查询是否有线程正在等待获取此锁定
    boolean hasWaiters(Condition) - 查询是否有线程正在等待与此锁定有关的condition条件  
6.  boolean isFair() - 判断是不是公平锁  
    boolean isHeldByCurrentThread() - 查询当前线程是否保持此锁定  
    boolean isLocked() - 查询此锁定是否由任意线程保持  
7.  
    