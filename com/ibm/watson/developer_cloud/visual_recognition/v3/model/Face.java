package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import com.google.gson.annotations.SerializedName;

public class Face {
    private Age age;
    private Gender gender;
    private Identity identity;
    @SerializedName("face_location")
    private Location location;

    public class Identity {
        private String name;
        private Double score;
        @SerializedName("type_hierarchy")
        private String typeHierarchy;

        public String getName() {
            return this.name;
        }

        public Double getScore() {
            return this.score;
        }

        public String getTypeHierarchy() {
            return this.typeHierarchy;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setScore(Double score) {
            this.score = score;
        }

        public void setTypeHierarchy(String typeHierarchy) {
            this.typeHierarchy = typeHierarchy;
        }
    }

    public Age getAge() {
        return this.age;
    }

    public Location getLocation() {
        return this.location;
    }

    public Gender getGender() {
        return this.gender;
    }

    public Identity getIdentity() {
        return this.identity;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }
}
