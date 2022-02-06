package model;

public class Display {

    private int width;
    private int height;

    public Display(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "width is " + width + "px" +
                ", height is " + height + "px.";
    }
}