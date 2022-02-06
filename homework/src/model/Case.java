package model;

import java.util.Map;
import java.util.Set;

public class Case {

    private String color;
    private String text;

    public Case(String color) {
        this.color = color;
    }

    public Case(String color, String text) {
        this.color = color;
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Case{" +
                "color='" + color + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}