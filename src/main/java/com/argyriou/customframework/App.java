// appframe
// createbc
// createbl

package com.argyriou.customframework;

import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        BeanContainer beanContainer = new BeanContainer();
        BeanLoader beanLoader = new BeanLoader(beanContainer);
        beanLoader.loadBeans("./target/classes");

        beanContainer.getAllBeans().forEach(bean -> {
            if (bean instanceof MyBean) {
                ((MyBean) bean).identifyYourSelf();
            }
        });
    }
}
