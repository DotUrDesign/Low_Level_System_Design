public class PlatformFactory {
    public static Platform getPlatform(String platform) {
        if(platform.equals("Android")) {
            return new Android();
        } else if(platform.equals("IOS")) {
            return new IOS();
        }
        return null;
    }
}
