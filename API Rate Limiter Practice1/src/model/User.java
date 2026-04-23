package model;

import enums.UserTier;

public class User {
    private int userId;
    private UserTier userTier;

    public User(int userId, UserTier userTier) {
        this.userId = userId;
        this.userTier = userTier;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserTier getUserTier() {
        return userTier;
    }

    public void setUserTier(UserTier userTier) {
        this.userTier = userTier;
    }
}
