package chapter04.decorator.problem;

import chapter04.decorator.TextView;

public class TextViewWithBorderAndScroll extends TextView {

    private int width;

    public TextViewWithBorderAndScroll(int width) {
        this.width = width;
    }

    @Override
    public void draw() {
        super.draw();
        drawBorder(width);
        drawScroll();
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
