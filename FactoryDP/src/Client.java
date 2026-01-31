public class Client {
    public static void main(String[] args) {
        String platform_name = "Android"; // this is a simulation
        Platform p = Platform.getPlatform(platform_name);
        UIComponentFactory ui = p.createUIComponentFactory();
        ui.createButton();
        ui.createDropdown();
        ui.createMenu();

        System.out.println("---------------------------------------------------");

        String platform_name1 = "IOS"; // this is a simulation
        Platform p1 = Platform.getPlatform(platform_name1);
        UIComponentFactory ui1 = p1.createUIComponentFactory();
        ui1.createButton();
        ui1.createDropdown();
        ui1.createMenu();

    }
}
