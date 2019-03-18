package chapter05.chain;

public abstract class HelpHandler {

    private HelpHandler successor;
    private Topic topic;

    public HelpHandler(HelpHandler successor, Topic topic) {
        this.successor = successor;
        this.topic = topic;
    }

    public boolean hasHelp() {
        return !topic.equals(Topic.NO_HELP_TOPIC);
    }

    public void setHandler(HelpHandler successor, Topic topic) {
        this.successor = successor;
        this.topic = topic;
    }

    public void handleHelp() {
        if (successor != null) {
            successor.handleHelp();
        }
    }

}
