package chapter05.chain;

public class Button extends Widget {

    public Button(HelpHandler h, Topic t) {
        super(h, t);
    }

    @Override
    public void handleHelp() {
        if(hasHelp()) {
            System.out.println("Button help message");
        } else {
            super.handleHelp();
        }
    }

}
