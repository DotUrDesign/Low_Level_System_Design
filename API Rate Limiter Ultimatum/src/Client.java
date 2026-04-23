import enums.RateLimiterType;
import enums.UserTier;
import model.User;
import service.RateLimiterService;

public class Client {
    /*
        Flow -
        2 users => one free user and one premium user

        remember,
        based on the membership of the user
            => configuration of the rate limiter
                   - how many requests per how many seconds should be accepted
                   - like => for free members 10reqs/60secs
                   - or for premium members 100 reqs/60secs
                    and
            => type of the rate limiter
                - fixed window
                - sliding window log
                - token bucket

     */

    public static void main(String[] args) {

        User user1 = new User("User1", UserTier.FREE);
        User user2 = new User("User2", UserTier.PREMIUM);

        RateLimiterService rateLimiterService = new RateLimiterService(user1);

        rateLimiterService.allowRequest();
    }
}
