package RateLimiter;

public class RateLimitingFactory {
    public static  RateLimiter getRateLimiter(RateLimitingAlgo rateLimitingAlgo, int capacity, int rate){
        return switch(rateLimitingAlgo){
            case LEAKY_BUCKET -> new LeakyBucketRateLimiter(capacity, rate);
            case TOKEN_BUCKET -> new TokenBucketRateLimiter(capacity, rate);
        };
    }
}
