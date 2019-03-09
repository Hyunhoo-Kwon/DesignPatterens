package chapter04.decorator.problem;

import chapter04.decorator.TextView;

public class TextViewWithDropShadow extends TextView {

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
