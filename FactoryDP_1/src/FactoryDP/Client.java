package FactoryDP;
/*
    1. Product
    2. Factory

    Product --> Button
            --> Checkbox

    Factory --> AndroidComponentFactory
            --> IOSComponentFactory

    Product => Normal categorisation
    Factory => UI-based categorisation

    ---------------------------------------------------------------

    There are 2 ways via which we fetched the ComponentFactory - either AndroidComponentFactory or IosComponentFactory.
    1. Fetched via the platformName
    2. Fetched via the platform(which is being fetched via platformName)

    The first way is a bit poor design - as we have 2 if-else blocks which violates the OCP principle
    One is present in the PlatformFactory class, another one is present in the ComponentFactory class.

    But the second way is a bit better design as we have only one if-else blocks present inside the PlatformFactory class. The ComponentFactory object - we are trying to fetch it from the platform(Android object or Ios Object) we got from the Platform Factory.

*/
public class Client {
    public static void main(String[] args) {
        String platformName = "Android";    // this is a simulation
        Platform platform = Platform.getPlatform(platformName);  // Android or Ios
        UIComponentFactory ui = Platform.getUIComponentFactory(platformName);  // AndroidComponentFactory or IosComponentFactory
        ui.createButton();
        ui.createDropdown();

        System.out.println("-----------------------------------");

        // Better approach to fetch the UIComponentFactory
        String platformName1 = "Ios";
        Platform platform1 = Platform.getPlatform(platformName1);  // Ios
        UIComponentFactory ui1 = platform1.createUIComponentFactory();  // IosComponentFactory
        ui1.createButton();
        ui1.createDropdown();
    }
}
