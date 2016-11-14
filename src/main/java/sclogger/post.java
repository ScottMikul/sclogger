package sclogger;

import java.util.Date;

/**
 * Created by scott on 11/3/2016.
 */

public class post {
    public String toString() {
        return "posttoString{" +
                "content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String content;

    public post(String content, String title, String date) {
        this.content = content;
        this.title = title;
        this.date = date;
    }

    public String title;
    public String date;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
