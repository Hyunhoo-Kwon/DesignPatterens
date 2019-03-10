package chapter04.decorator;

public class TextView implements VisualComponent {

    @Override
    public void draw() {
        System.out.println("TextView");
    }

    @Override
    public void resize() {

    }
}
