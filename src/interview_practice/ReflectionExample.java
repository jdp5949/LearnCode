package interview_practice;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;



class MyClass {
    public int publicField = 10;
    private String privateField = "Hello, Reflection!";

    public MyClass() {
    }

    public void publicMethod() {
        System.out.println("Public Method");
    }

    private void privateMethod() {
        System.out.println("Private Method");
    }
}

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        // Getting the Class object
        Class<?> myClass = Class.forName("interview_practice.MyClass");

        // Creating an instance of the class
        Object obj = myClass.getDeclaredConstructor().newInstance();

        // Accessing public field
        Field publicField = myClass.getField("publicField");
        System.out.println("Public Field Value: " + publicField.get(obj));

        // Accessing private field using reflection (not recommended)
        Field privateField = myClass.getDeclaredField("privateField");
        privateField.setAccessible(true);
        System.out.println("Private Field Value: " + privateField.get(obj));

        // Accessing public method
        Method publicMethod = myClass.getMethod("publicMethod");
        publicMethod.invoke(obj);

        // Accessing private method using reflection (not recommended)
        Method privateMethod = myClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(obj);

        // Creating an array using reflection
        int[] intArray = (int[]) Array.newInstance(int.class, 5);
        System.out.println("Array Length: " + intArray.length);

        // Accessing annotations
        Method annotatedMethod = myClass.getMethod("publicMethod");
        Annotation[] annotations = annotatedMethod.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("Annotation Type: " + annotation.annotationType());
        }
    }
}

