public class IosComponentFactory implements UIComponentFactory{
    @Override
    public void createButton() {
        System.out.println("IOS button");
    }

    @Override
    public void createDropdown() {
        System.out.println("IOS dropdown");
    }

    @Override
    public void createMenu() {
        System.out.println("IOS menu");
    }
}
