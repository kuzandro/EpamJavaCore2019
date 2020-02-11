package ru.epam.javacore.lesson_3_oop_continue.lesson.a_6_enums;

public enum ImprovedColor {

    RED(255, 0, 0), BLUE(0, 0, 255), GREEN(0, 255, 0);

    private int red;
    private int green;
    private int blue;

    ImprovedColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public static void main(String[] args) {
        ImprovedColor redColor = ImprovedColor.RED;
        redColor.getBlue();
    }
}
