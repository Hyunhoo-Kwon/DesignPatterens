package chapter04.decorator;

public class BorderDecorator extends Decorator {

    private int width;

    public BorderDecorator(VisualComponent component, int width) {
        super(component);
        this.width = width;
    }

    @Override
    public void draw() {
        super.draw();
        drawBorder(width);
    }

    private void drawBorder(int width) {
        // ...
        System.out.println("drawBoard");
    }
}
