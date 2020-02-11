package ru.epam.javacore.lesson_10.lesson.a_2_generic_box;

public class A_3_Game {

    private static class GameResult {
        private Integer money;
        private String message;

        public GameResult(Integer money, String message) {
            this.money = money;
            this.message = message;
        }
    }

    private static class Pair<Left, Right> {
        private Left left;
        private Right right;

        public Pair(Left left, Right right) {
            this.left = left;
            this.right = right;
        }
    }

    private static GameResult playNoGeneric(String name) {
        if (name.length() > 3) {
            return new GameResult(1000, null);
        } else {
            return new GameResult(null, "Play again " +
                    "and one day you will win!");
        }
    }

    private static Pair<Integer, String> playGeneric(String name) {
        if (name.length() > 3) {
            return new Pair<>(1000, null);
        } else {
            return new Pair<>(null, "Play again " +
                    "and one day you will win!");
        }
    }

    public static void main(String[] args) {
        GameResult result = playNoGeneric("Ivan");
        if (result.money != null) {
            System.out.println("Ivan is the winner! " + result.money);
        }
        result = playNoGeneric("U2");
        result = playNoGeneric("A");

        Pair<Integer, String> genericResult = playGeneric("U2");
        boolean resultWin = genericResult.left != null;
        genericResult = playGeneric("A");


    }
}
