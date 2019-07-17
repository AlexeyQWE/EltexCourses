package eltex.tasks;

public class Msg {

    private String to;
    private  String from;
    private String title;

    Msg () {}

     Msg(String to, String from, String title) {
        this.to = to;
        this.from = from;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
