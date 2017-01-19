package com.example.eteam.appwearness.Object;

public class ReportType {
    private String description;
    private String icon;
    private int id;

    public ReportType(int id) {
        this.id = id;
    }

    public ReportType(int id, String description, String icon) {
        this.id = id;
        this.description = description;
        this.icon = icon;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
