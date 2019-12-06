package epam.homework2;

public class Main {

    public static void main(String[] args) {
        quadraticEqt equation1 = new quadraticEqt(1, 2,1);
        equation1.printEqt();
        equation1.printRoots();

        quadraticEqt equation2 = new quadraticEqt(1, 24,88);
        equation2.printEqt();
        equation2.printRoots();

        quadraticEqt equation3 = new quadraticEqt(25, 2,5.6f);
        equation3.printEqt();
        equation3.printRoots();
    }
}
