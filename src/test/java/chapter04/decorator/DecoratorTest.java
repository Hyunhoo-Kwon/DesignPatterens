package chapter04.decorator;

import chapter04.decorator.problem.TextViewWithDropShadowAndBorderAndScroll;
import org.junit.Test;

import java.io.*;

public class DecoratorTest {

    @Test
    public void decoratorTest() {
        Window window = new Window();
        TextView textView = new TextView();

        window.setComponent(new DropShadowDecorator(new BorderDecorator(new ScrollDecorator(textView), 1)));
        window.getComponent().draw();
    }

    @Test
    public void decoratorProblemTest() {
        TextViewWithDropShadowAndBorderAndScroll textViewWithDropShadowAndBorderAndScroll = new TextViewWithDropShadowAndBorderAndScroll(1);
        textViewWithDropShadowAndBorderAndScroll.draw();
    }

    @Test
    public void readerTest() throws Exception {
        LineNumberReader lineNumberReader = new LineNumberReader(new BufferedReader(new FileReader(new File("/Users/kakao/test.txt"))));
        System.out.println(lineNumberReader.readLine());
    }

}
