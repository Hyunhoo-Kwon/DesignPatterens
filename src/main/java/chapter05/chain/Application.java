package chapter05.chain;

public class Application extends HelpHandler {

    public Application(Topic t) {
        super(null, t);
    }

    @Override
    public void handleHelp() {
        System.out.println("Application help message");
    }
}
