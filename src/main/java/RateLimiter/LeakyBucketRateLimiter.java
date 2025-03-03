package RateLimiter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LeakyBucketRateLimiter implements RateLimiter{
    private final int capacity;
    private final int leakRate;
    private final AtomicInteger waterLevel;
    private long lastLeakTimestamp;
    private final Lock lock = new ReentrantLock();
    private final double NANO = 1e9;

    LeakyBucketRateLimiter(int capacity, int leakRate){
        this.capacity = capacity;
        this.leakRate = leakRate;
        this.waterLevel = new AtomicInteger(capacity);
        this.lastLeakTimestamp = System.nanoTime();
    }

    private void leak(){
        long now = System.nanoTime();
        long elapsedTime = now - lastLeakTimestamp;
        int leakedAmount = (int) (elapsedTime/NANO) * leakRate;
        if(leakedAmount > 0) {
            waterLevel.getAndAccumulate(0, (curr, min) -> Math.min(min, curr - leakedAmount));
            lastLeakTimestamp = now;
        }
    }

    @Override
    public boolean allowRequest() {
        lock.lock();
        try{
            leak();
            if(waterLevel.get() < capacity){
                waterLevel.incrementAndGet();
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }
}
