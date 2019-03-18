package chapter05.chain;

public class Widget extends HelpHandler {

    private HelpHandler parent;

    protected Widget(HelpHandler h, Topic t) {
        super(h, t);
        parent = h;
    }

}
