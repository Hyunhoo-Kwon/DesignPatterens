package chapter05.chain;

public class Dialog extends Widget {

    public Dialog(HelpHandler h, Topic t) {
        super(h, t);
    }

    @Override
    public void handleHelp() {
        if(hasHelp()) {
            System.out.println("Dialog help message");
        } else {
            super.handleHelp();
        }
    }

}
