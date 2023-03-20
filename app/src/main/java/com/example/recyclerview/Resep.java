package com.example.recyclerview;

public class Resep {

    private String name;
    private String description;
    private int image;
    //    getter
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPoster() {
        return image;
    }

    //    setter
    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
