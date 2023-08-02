// reflect
package com.argyriou.reflect;

import com.argyriou.proxy.Car;

import java.util.Arrays;

public class Reflect {
    public static void main(String[] args) {
        try {
            Class<?> c = Car.class;

            System.out.println("Car annotations :");
            Arrays.stream(c.getAnnotations()).forEach(System.out::println);

            System.out.println("Car methods :");
            Arrays.stream(c.getMethods()).forEach(method -> System.out.println(method.getName()));

            System.out.println("interfaces of car :");
            Arrays.stream(c.getInterfaces()).forEach(intrf -> System.out.println(intrf.getName()));
        }
        catch (Exception e) {
            // swallow
        }
    }
}
