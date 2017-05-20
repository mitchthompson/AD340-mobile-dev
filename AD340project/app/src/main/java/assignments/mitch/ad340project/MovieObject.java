package assignments.mitch.ad340project;


public class MovieObject {
    String title;
    String year;
    public String img_url;

    public MovieObject(String title, String year, String img_url) {
        this.title = title;
        this.year = year;
        this.img_url = img_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImgURL() {return img_url;}

    public void setImgURL(String img_url) {
        this.img_url = img_url;
    }
}


