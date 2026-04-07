package model;

import enums.UserTier;

public class User {
    private String userId;
    private UserTier userTier;

    public User(String userId, UserTier userTier) {
        this.userId = userId;
        this.userTier = userTier;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserTier getUserTier() {
        return userTier;
    }

    public void setUserTier(UserTier userTier) {
        this.userTier = userTier;
    }
}
