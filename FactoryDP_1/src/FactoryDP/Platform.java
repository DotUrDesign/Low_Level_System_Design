package FactoryDP;

public abstract class Platform {
    public static Platform getPlatform(String platformName) {
        return PlatformFactory.getPlatform(platformName);
    }

    public static UIComponentFactory getUIComponentFactory(String platformName) {
        return ComponentFactory.getComponentFactory(platformName);
    }

    public abstract UIComponentFactory createUIComponentFactory();

}
