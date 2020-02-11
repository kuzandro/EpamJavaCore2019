package ru.epam.javacore.lesson_10.lesson.a_1_not_generic_box;

public class Box {
    private static class Car{}
    private Object content;

    public Box(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public static void main(String[] args) {
        Box carBox = new Box(new Car());
        Box stringBox = new Box("Any str");
        Box numberBox = new Box(33);
        workWithBox(stringBox);
        workWithBox(numberBox);
    }

    private static void workWithBox(Box box){
        Object content = box.content;
        if (String.class.equals(content.getClass())){
            String s = (String) content;
            System.out.println(s.length());
        } else if (Integer.class.equals(content.getClass())){
            int i = (int) content;
            System.out.println(++i);
        }
    }
}
