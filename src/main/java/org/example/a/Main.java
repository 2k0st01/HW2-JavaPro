package org.example.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Main main = new Main();
        Class<Main> cls = Main.class;
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test test = method.getAnnotation(Test.class);
                method.invoke(main, test.param1(), test.param2());
            }
        }
    }

    @Test(param1 = 1,param2 = 5)
    private void test1(int a, int b){
        System.out.println(a+b);
    }

    @Test(param1 = 7,param2 = 3)
    public void test2(int a, int b){
        System.out.println(a+b);
    }
}