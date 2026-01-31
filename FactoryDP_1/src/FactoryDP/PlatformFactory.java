package FactoryDP;

public class PlatformFactory {
    public static Platform getPlatform(String platformName) {
        if(platformName.equals("Android")) {
            return new Android();
        } else if(platformName.equals("Ios")) {
            return new Ios();
        }
        return null;
    }
}
