package pe.area51.myfragmentapp;

public class Note {

    private final long id;
    private final long unixTime;
    private final String title;
    private final String content;

    public Note(final String title, final String content) {
        this.id = -1;
        this.unixTime = -1;
        this.title = title;
        this.content = content;
    }


    public long getId() {
        return id;
    }

    public long getUnixTime() {
        return unixTime;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", UnixTime: " + unixTime + ", Title: " + title + ", Content: " + content;
    }
}
