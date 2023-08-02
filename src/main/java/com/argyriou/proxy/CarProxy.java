// carproxy

package com.argyriou.proxy;

public class CarProxy implements Vehicle {
    private final Car car;

    public CarProxy(Car car) {
        this.car = car;
    }

    @Override
    public void sound() {
        System.out.println("before i make the sound, i have to start the engine");
        System.out.println("Starting the engine ...");
        car.sound();
    }
}
