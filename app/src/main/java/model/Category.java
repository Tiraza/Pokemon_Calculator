package model;

/**
 * Created by regedit on 28/07/2016.
 */
public enum Category {
    PHYSICAL("Physical"),
    SPECIAL("Special"),
    STATUS("Status");

    private String display;

    Category(String display) {this.display = display;}

    public String getDisplay() { return this.display; }
}
