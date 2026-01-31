public abstract class Platform {
    public static Platform getPlatform(String platform) {
        return PlatformFactory.getPlatform(platform);
    }

    public abstract UIComponentFactory createUIComponentFactory();
}
