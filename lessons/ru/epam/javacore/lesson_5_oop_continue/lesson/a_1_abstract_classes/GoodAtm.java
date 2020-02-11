package ru.epam.javacore.lesson_5_oop_continue.lesson.a_1_abstract_classes;

public class GoodAtm extends BaseAtm {
    private static final float RATE = 0.01f;

    @Override
    protected float getRate() {
        return RATE;
    }

    public String getMoney(int money) {
        incTransactionCount();
        float result = money * (100 - RATE);

        if (cashWithCoins()) {
            System.out.println("Any complex logic");
            return "Coins " + result;
        } else {
            return "Banknots " + result;
        }
    }


}
