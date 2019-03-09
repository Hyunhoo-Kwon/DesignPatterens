package chapter04.decorator.problem;

import chapter04.decorator.TextView;

public class TextViewWithScroll extends TextView {

    @Override
    public void draw() {
        super.draw();
        drawScroll();
    }

    private void drawScroll() {
        // ...
        System.out.println("drawScroll");
    }

}
