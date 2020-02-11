package ru.epam.javacore.lesson_5_oop_continue.lesson.a_1_abstract_classes;

public abstract class BaseAtm {
    protected int transactionCount = 0;

    protected abstract float getRate();
    public abstract String getMoney(int money);

    protected void incTransactionCount(){
        transactionCount++;
    }

    protected boolean cashWithCoins() {
        if (getRate() > 10) {
            return true;
        } else {
            return false;
        }
    }

    public int getTransactionCount() {
        return transactionCount;
    }
}
