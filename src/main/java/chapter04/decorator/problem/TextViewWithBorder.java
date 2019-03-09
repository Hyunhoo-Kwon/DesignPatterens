package chapter04.decorator.problem;

import chapter04.decorator.TextView;

public class TextViewWithBorder extends TextView {

    private int width;

    public TextViewWithBorder(int width) {
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
