package model;

import enums.UserTier;

public class User {
    private String userId;
    private UserTier userTier;

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
