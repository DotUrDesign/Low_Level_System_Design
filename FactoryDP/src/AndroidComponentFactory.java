public class AndroidComponentFactory implements UIComponentFactory{
    @Override
    public void createButton() {
        System.out.println("Android button");
    }

    @Override
    public void createDropdown() {
        System.out.println("Android dropdown");
    }

    @Override
    public void createMenu() {
        System.out.println("Android menu");
    }
}
