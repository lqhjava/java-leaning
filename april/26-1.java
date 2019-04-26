package com.lqh.std;

public interface Friut {
    void eat();
}
package com.lqh.std;

public class Apple implements Friut {

    @Override
    public void eat() {
        System.out.println("吃苹果");
    }
}
package com.lqh.std;

public class Oringe implements Friut {

    @Override
    public void eat() {
        System.out.println("吃橘子");
    }
}
package com.lqh.std;

public class Factory {
    public Factory(){};

    public static Friut getFriut(String classNmae){
        Friut f = null;
        // Class.forName(classNmae). 获取对象的类
        //.newInstance(); 创建对象
        try {
            //new 的对象不是Friut 邀强转
            f = (Friut) Class.forName(classNmae).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return f;
    }
}
package com.lqh.main;

import com.lqh.std.Factory;
import com.lqh.std.Friut;
import com.lqh.std.MyClass;

public class TestMain {
    public static void main(String[] args) {

        Friut f = Factory.getFriut("com.lqh.std.Oringe");
        f.eat();
        Class<?> cls = f.getClass();
        System.out.println(cls.getPackage().getName());

        System.out.println(cls.getSuperclass().getName());
        //类实现的接口一般是多个，用数组存储
        Class<?>[] icls = cls.getInterfaces();
        for (Class<?> class1:icls
             ) {
            System.out.println(class1.getName());
        }
//        MyClass<Integer> my1 = new MyClass();
//
//
//        try {
//            Class<?> cls = Class.forName("com.lqh.std.MyClass");
//            Object obj = cls.newInstance();
//            System.out.println(obj);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }
        //System.out.println(my1.getClass());
//        my1.setX(2);
//        my1.setY(20);
//
//        MyClass<String> my2 = new MyClass<>();
//        my2.setX("东经30度");
//        my2.setY("北纬40度");
//
//        int x = my1.getX();
//        String y = my2.getY();

//        System.out.println(x);
//        System.out.println(y);

//        my1.testMethod("hello wold");
//        my1.testMethod(236);


    }

    public  static void fun(MyClass<?> t){
        System.out.println(t.getX());
    }
}
