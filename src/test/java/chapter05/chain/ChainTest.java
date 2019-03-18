package chapter05.chain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChainTest {

    @Test
    public void chainTest() {
        Application application = new Application(Topic.APPLICATION_TOPIC);
        Dialog dialog = new Dialog(application, Topic.PRINNT_TOPIC);
        Button button = new Button(dialog, Topic.PAPER_ORIENTATION_TOPIC);

        button.handleHelp();
    }

    @Test
    public void chainTest2() {
        Application application = new Application(Topic.APPLICATION_TOPIC);
        Dialog dialog = new Dialog(application, Topic.PRINNT_TOPIC);
        Button button = new Button(dialog, Topic.NO_HELP_TOPIC);

        button.handleHelp();
    }

    @Test
    public void chainTest3() {
        Application application = new Application(Topic.APPLICATION_TOPIC);
        Dialog dialog = new Dialog(application, Topic.NO_HELP_TOPIC);
        Button button = new Button(dialog, Topic.NO_HELP_TOPIC);

        button.handleHelp();
    }

}
