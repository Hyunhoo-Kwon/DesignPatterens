package chapter04.decorator;

import chapter04.decorator.problem.TextViewWithDropShadowAndBorderAndScroll;
import org.junit.Test;

import static org.junit.Assert.*;

public class DecoratorTest {

    @Test
    public void decoratorTest() {
        Window window = new Window();
        TextView textView = new TextView();

        window.setComponent(new DropShadowDecorator(new BorderDecorator(new ScrollDecorator(textView), 1)));
        window.draw();
    }

    @Test
    public void decoratorProblemTest() {
        TextViewWithDropShadowAndBorderAndScroll textViewWithDropShadowAndBorderAndScroll = new TextViewWithDropShadowAndBorderAndScroll(1);
        textViewWithDropShadowAndBorderAndScroll.draw();
    }

}