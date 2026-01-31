package FactoryDP;

public class ComponentFactory {
    public static UIComponentFactory getComponentFactory(String platformName) {
        if(platformName.equals("Android")) {
            return new AndroidComponentFactory();
        } else if(platformName.equals("Ios")) {
            return new IosComponentFactory();
        }
        return null;
    }
}
