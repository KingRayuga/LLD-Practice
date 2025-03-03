package RateLimiter;

import java.util.concurrent.ConcurrentHashMap;

public class RateLimitingRegistry {
    private static final ConcurrentHashMap<String, RateLimiter> limiters = new ConcurrentHashMap<>();

    private RateLimitingRegistry(){}

    public static RateLimiter getRateLimiter(String userId, RateLimitingAlgo type, int capacity, int rate) {
        return limiters.computeIfAbsent(userId, _ -> RateLimitingFactory.getRateLimiter(type, capacity, rate));
    }

}
