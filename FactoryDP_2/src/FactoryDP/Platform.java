package FactoryDP;

public abstract class Platform {
    public static Platform getPlatform(String platformName) {
        return PlatformFactory.getPlatform(platformName);
    }

    public abstract UIComponentFactory createUIComponentFactory();
}
