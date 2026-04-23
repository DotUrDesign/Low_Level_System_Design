import enums.UserTier;
import model.User;
import service.RateLimiterService;

public class Client {
    public static void main(String[] args) {
        User user1 = new User(1, UserTier.FREE);
        User user2 = new User(2, UserTier.PREMIUM);

        RateLimiterService rateLimiterService = new RateLimiterService(user1);
        boolean allowReq = rateLimiterService.allowRequest();
    }
}
