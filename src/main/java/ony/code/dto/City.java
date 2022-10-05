package ony.code.dto;

public class City {
    public int cityid;
    public String title;
    public City() {
    }

    public City(int cityid, String title) {
        this.cityid = cityid;
        this.title = title;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
