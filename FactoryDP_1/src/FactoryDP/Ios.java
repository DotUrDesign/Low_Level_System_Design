package FactoryDP;

public class Ios extends Platform{
    @Override
    public UIComponentFactory createUIComponentFactory() {
        return new IosComponentFactory();
    }
}
