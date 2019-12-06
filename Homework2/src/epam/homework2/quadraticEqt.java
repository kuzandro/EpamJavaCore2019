package epam.homework2;

public class quadraticEqt {
    private float a;
    private float b;
    private float c;
    private float d;
    private Double x1;
    private Double x2;

    private float calcD(float a, float b, float c) {
        return b * b - 4 * a * c;
    }

    private void calcRoots(float a, float b, float c, float d) {
        if (d > 0) {
            this.x1 = (-b - Math.sqrt(d)) / (2 * a);
            this.x2 = (-b + Math.sqrt(d)) / (2 * a);
        } else if (d == 0) {
            this.x1 = (double) -b / (2 * a);
        }
    }

    public quadraticEqt(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
        d = calcD(a, b, c);
        calcRoots(this.a, this.b, this.c, d);
    }

    public void printRoots(){
        if(x2 != null){
            System.out.println("x1 = " + x1 + ", x2 = " + x2 + "\n");
        } else if (x1 != null) {
            System.out.println("x = " + x1 + "\n");
        } else {
            System.out.println("No real roots \n");
        }
    }

    public void printEqt(){
        System.out.println("Equation: \n" + a + "*xˆ2 + " + b + "*x + " + c);
    }

    public void setA(float a) {
        this.a = a;
    }
    public void setB(float b) {
        this.b = b;
    }
    public void setC(float c) {
        this.c = c;
    }
}
