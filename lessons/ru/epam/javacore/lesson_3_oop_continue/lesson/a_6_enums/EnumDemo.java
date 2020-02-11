package ru.epam.javacore.lesson_3_oop_continue.lesson.a_6_enums;

public class EnumDemo {
    public static void main(String[] args) {
        for (Color color : Color.values()) {
            System.out.println(color.name() + " " + color.ordinal());
        }
        String colorStr = "RED";

        Color red = Color.valueOf(colorStr);
        System.out.println(red);

        System.out.println(colorStrToColorEnum(null));
    }

    private static Color colorStrToColorEnum(String colorStr) {
        for (Color color : Color.values()) {
            if (color.name().equals(colorStr)) {
                return color;
            }
        }

        return null;
    }

}
