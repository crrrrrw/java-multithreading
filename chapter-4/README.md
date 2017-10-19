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
7.  void lockInterruptibly() - 如果当前线程未被中断，则获取锁定，如果已经被中断则出现异常。  
8.  boolean tryLock() - 仅在调用时锁定未被另一个线程保持的情况下，才获取该锁定.  
9.  boolean tryLock(long timeout,TimeUnit unit) - 如果锁定在给定等待时间内没有被另一个线程保持，且当前线程未被中断，则获取该锁定  
10. void awaitUninterruptibly() - 造成当前线程在接到信号之前一直处于等待状态。  
11. awaitUntil() - 到达等待时间可唤醒自己
12. 使用condition 实现对业务线程进行排序规划。  
13. 读写锁(lock.readLock().lock(),lock.writeLock().lock())：  
类ReentrantReadWriteLock的使用：读读共享  
类ReentrantReadWriteLock的使用：写写互斥  
类ReentrantReadWriteLock的使用：读写互斥
    