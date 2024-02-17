package org.example.b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TextContainer txt = new TextContainer();
        Class<?> cls = TextContainer.class;


        Method[] methods = cls.getDeclaredMethods();
        SaveTo saveTo = cls.getAnnotation(SaveTo.class);

        for(Method method : methods){
            if(method.isAnnotationPresent(Sever.class)){
                method.invoke(txt, saveTo.path());
            }
        }
    }
}
