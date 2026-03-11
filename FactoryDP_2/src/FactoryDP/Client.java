package FactoryDP;

public class Client {
    public static void main(String[] args) {
        String platformName = "Android";  // this is a simulation
        Platform platform = Platform.getPlatform(platformName);
        UIComponentFactory componentFactory = platform.createUIComponentFactory();
        componentFactory.createButton();
        componentFactory.createDropdown();
    }
}
