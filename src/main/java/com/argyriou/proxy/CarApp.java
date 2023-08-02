// carapp
// jdp

package com.argyriou.proxy;

import java.lang.reflect.Proxy;

public class CarApp {
    public static void main(String[] args) {
        Car car = new Car();
        CarProxy carProxy = new CarProxy(car);

        car.sound();
        carProxy.sound();

        Vehicle v = (Vehicle) Proxy.newProxyInstance(Car.class.getClassLoader(), new Class[]{Vehicle.class}, (proxy, method, arguments) -> {
            if ("sound".equals(method.getName())) {
                System.out.println("before i make the sound, i have to start the engine");
                System.out.println("Starting the engine ...");
            }
            return method.invoke(car, arguments);
        });
        v.sound();
    }
}



