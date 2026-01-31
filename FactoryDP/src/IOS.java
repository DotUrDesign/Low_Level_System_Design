public class IOS extends Platform{
    @Override
    public UIComponentFactory createUIComponentFactory() {
        return new IosComponentFactory();
    }
}
