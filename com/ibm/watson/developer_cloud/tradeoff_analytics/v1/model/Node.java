package com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Node {
    private Position coordinates;
    @SerializedName("solution_refs")
    private List<String> solutionRefs;

    public Node() {
        this.solutionRefs = new ArrayList();
    }

    public Position getCoordinates() {
        return this.coordinates;
    }

    public List<String> getSolutionRefs() {
        return this.solutionRefs;
    }

    public void setCoordinates(Position coordinates) {
        this.coordinates = coordinates;
    }

    public void setSolutionRefs(List<String> solutionRefs) {
        this.solutionRefs = solutionRefs;
    }
}
