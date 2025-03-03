package RateLimiter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TokenBucketRateLimiter implements RateLimiter{

    private final int capacity;
    private final int refillRate;
    private final AtomicInteger tokens;
    private long lastRefillTimestamp;
    private final Lock lock = new ReentrantLock();
    private static final double NANO = 1e9;

    TokenBucketRateLimiter(int capacity, int refillRate){
        this.capacity = capacity;
        this.refillRate = refillRate;
        tokens = new AtomicInteger(capacity);
        this.lastRefillTimestamp = System.nanoTime();
    }

    private void refill(){
        long now = System.nanoTime();
        long elapsedTime = now - lastRefillTimestamp;
        int newTokens = (int) ((elapsedTime / NANO) * refillRate);

        if(newTokens > 0){
            tokens.getAndAccumulate(capacity, (curr, max) -> Math.min(max, curr + max));
            lastRefillTimestamp = now;
        }
    }

    @Override
    public boolean allowRequest() {
        lock.lock();
        try{
            refill();
            if(tokens.get() > 0){
                tokens.decrementAndGet();
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }
}
