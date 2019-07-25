package com.lqh;


//矩形
public class Rectsngl implements IShape{
    private int wideth;
    private int high;

    @Override
    public String toString() {
        return "Rectsngl{" +
                "wideth=" + wideth +
                ", high=" + high +"area"+this.area()+"side"+this.side()+
                '}';
    }

    public Rectsngl() {
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getWideth() {
        return wideth;
    }

    public void setWideth(int wideth) {
        this.wideth = wideth;
    }

    public double area() {
        return wideth*high;
    }

    public double side() {
        return 2*(wideth+high);
    }
}
