package org.example.c;

import java.io.*;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();

        serialize(testClass);
        System.out.println(deSerialize());
    }

    public static void serialize(Object obj) {
        try (FileOutputStream fos = new FileOutputStream("test.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deSerialize() {
        try (FileInputStream fis = new FileInputStream("test.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object fobj = ois.readObject();
            return checkObj(fobj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static Object checkObj(Object obj) {
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {
            if (!field.isAnnotationPresent(Save.class)) {
                try {
                    field.setAccessible(true);
                    field.set(obj, null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return obj;
    }
}

