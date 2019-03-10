package chapter04.decorator;

public class Window {

    private VisualComponent component;

    public void setComponent(VisualComponent component) {
        this.component = component;
    }

    public VisualComponent getComponent() {
        return component;
    }
}
