package chapter04.decorator;

public class DropShadowDecorator extends Decorator {

    public DropShadowDecorator(VisualComponent component) {
        super(component);
    }

    @Override
    public void draw() {
        super.draw();
        drawDropShadow();
    }

    private void drawDropShadow() {
        // ...
        System.out.println("drawDropShadow");
    }

}
