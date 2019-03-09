package chapter04.decorator.problem;

import chapter04.decorator.TextView;

public class TextViewWithDropShadowAndBorderAndScroll extends TextView {

    private int width;

    public TextViewWithDropShadowAndBorderAndScroll(int width) {
        this.width = width;
    }

    @Override
    public void draw() {
        super.draw();
        drawDropShadow();
        drawBorder(width);
        drawScroll();
    }

    private void drawDropShadow() {
        // ...
        System.out.println("drawDropShadow");
    }

    private void drawBorder(int width) {
        // ...
        System.out.println("drawBoard");
    }

    private void drawScroll() {
        // ...
        System.out.println("drawScroll");
    }

}
