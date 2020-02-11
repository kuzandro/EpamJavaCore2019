package ru.epam.javacore.lesson_10.lesson.a_4_wild_card;

public class A_2_Wild_Card_Demo_2 {

    private static class Box<T extends Number> {
        private T t;

        public Box(T t) {
            this.t = t;
        }

        public boolean isEquals(Box<T> otherBox){
          //  return t.equals(otherBox.t);
            return t.longValue() == otherBox.t.longValue();
        }

        public boolean isEquals2(Box<?> otherBox){
          //  return t.equals(otherBox.t);
            //t++;
            return t.longValue() == otherBox.t.longValue();
        }

    }

    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>(10);
        Box<Integer> box2 = new Box<>(10);
        Box<Long> box3 = new Box<>(30L);
        System.out.println(box1.isEquals(box2));
        //System.out.println(box1.isEquals(box3));
        System.out.println(box1.isEquals2(box3));
    }
}
