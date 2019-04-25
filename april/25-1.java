package com.lqh.main;

import com.lqh.std.MyClass;

public class TestMain {
    public static void main(String[] args) {
        MyClass<Integer> my1 = new MyClass();
        my1.setX(2);
        my1.setY(20);

        MyClass<String> my2 = new MyClass<>();
        my2.setX("东经30度");
        my2.setY("北纬40度");

        int x = my1.getX();
        String y = my2.getY();

//        System.out.println(x);
//        System.out.println(y);

//        my1.testMethod("hello wold");
//        my1.testMethod(236);

        fun(my1);
        fun(my2);
    }

    public  static void fun(MyClass<?> t){
        System.out.println(t.getX());
    }
}
package com.lqh.std;

//泛型
public class MyClass<T> {
    private T x;
    private T y;

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public <T> void testMethod(T t){
        System.out.println(t);
    }
}
