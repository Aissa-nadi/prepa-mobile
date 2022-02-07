package com.example.tpglobale;

import java.io.Serializable;

public class Car implements Serializable {
    private int image;
    private String titre;
    private String desc;

    public Car() {
    }

    public Car(String titre, String desc) {
        this.titre = titre;
        this.desc = desc;
    }

    public Car(int image, String titre, String desc) {
        this.image = image;
        this.titre = titre;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Car{" +
                "titre='" + titre + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
