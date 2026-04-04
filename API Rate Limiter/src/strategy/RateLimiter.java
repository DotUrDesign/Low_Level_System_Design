package strategy;

import enums.RateLimiterType;
import model.RateLimiterConfig;
import model.User;
/*
    Why we thought of making the RateLimiter as an abstract class instead of interface ?
    => First thing first, this is the place inside which we will be placing all the
    common things - which will be implemented or used by the concrete classes which
    ever extends this class.

    => And we wanted a constructor here to initialize the config for rate limiter and
    type of rate limiter.

    => Common info -
        rate limiter config
        rate limiter type
        allow request func


    CONCLUSIVE POINT -
    As common things are being placed here, we have to place the rateLimiter config and
    the rate limiter type here.
    And to set its values, we needed a constructor.
    And constructors cannot be initialized inside an interface.
    We need to make the class as an abstract class to initialize a constructor.

 */
public abstract class RateLimiter {
    public RateLimiterConfig rateLimiterConfig;
    public RateLimiterType rateLimiterType;
    public abstract boolean allowRequests(User user);

    public RateLimiter(RateLimiterConfig rateLimiterConfig, RateLimiterType rateLimiterType) {
        this.rateLimiterConfig = rateLimiterConfig;
        this.rateLimiterType = rateLimiterType;
    }
}
