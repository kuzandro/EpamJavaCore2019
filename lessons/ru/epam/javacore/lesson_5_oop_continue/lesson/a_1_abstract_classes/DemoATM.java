package ru.epam.javacore.lesson_5_oop_continue.lesson.a_1_abstract_classes;

public class DemoATM {

    public static void main(String[] args) {
        BaseAtm goodAtm = new GoodAtm();
        givMoney(goodAtm, 246);

        BaseAtm badAtm = new BadAtm();
        givMoney(badAtm, 56);

        System.out.println("Transactions " + goodAtm.getTransactionCount());
        System.out.println("Transactions " + badAtm.getTransactionCount());
    }

    private static void givMoney(BaseAtm baseAtm, int number){
        for (int i=0;i<number;i++){
            baseAtm.getMoney(300);
        }
    }
}
