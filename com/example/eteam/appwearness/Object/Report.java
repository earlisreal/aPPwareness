package com.example.eteam.appwearness.Object;

public class Report {
    private Coordinate coordinate;
    private int device_id;
    private int report_type_id;

    public Report(int device_id, Coordinate coordinate, int report_type_id) {
        this.device_id = device_id;
        this.coordinate = coordinate;
        this.report_type_id = report_type_id;
    }

    public int getReport_type_id() {
        return this.report_type_id;
    }

    public void setReport_type_id(int report_type_id) {
        this.report_type_id = report_type_id;
    }

    public int getDevice_id() {
        return this.device_id;
    }

    public void setDevice_id(int device_id) {
        this.device_id = device_id;
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
