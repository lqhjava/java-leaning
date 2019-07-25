package com.lqh;


//圆
public class Circlur  implements IShape {

    private int r;

    @Override
    public String toString() {
        return "Circlur{" +
                "r=" + r +"area"+this.area()+"side"+this.side()+
                '}';
    }

    public Circlur() {
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public double area() {
        return  Math.PI * Math.pow(r, 2);
    }

    public double side() {
        return 2 * Math.PI * r;
    }
}
