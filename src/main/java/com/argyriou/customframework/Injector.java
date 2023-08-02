// injector
// performDIproxy
package com.argyriou.customframework;

import java.lang.reflect.Proxy;
import java.util.Arrays;

public class Injector {
    private final BeanContainer beanContainer;

    public Injector(BeanContainer beanContainer) {
        this.beanContainer = beanContainer;
    }

    public void performDI() {
        beanContainer.getAllBeans().forEach(
                bean -> {
                    Arrays.stream(bean.getClass().getDeclaredFields()).forEach(
                            field -> {
                                if (Arrays.stream(field.getAnnotations())
                                        .anyMatch(annotation -> annotation instanceof CustomInject)) {
                                    Object beanToInjectOnField = beanContainer.getBean(field.getType());
                                    MyBeanIf v = (MyBeanIf) Proxy.newProxyInstance(MyBean.class.getClassLoader(), new Class[]{MyBeanIf.class}, (proxy, method, arguments) -> {
                                        if (Arrays.stream(beanToInjectOnField.getClass().getMethod("identifyYourSelf")
                                                .getAnnotations()).anyMatch(annotation -> annotation instanceof CustomTransaction)) {
                                            System.out.println("Transaction begin");
                                            Object result = method.invoke(beanToInjectOnField, arguments);
                                            System.out.println("Transaction end");
                                            return result;
                                        } else {
                                            return method.invoke(beanToInjectOnField, arguments);
                                        }
                                    });
                                    field.setAccessible(true);
                                    try {
                                        field.set(bean, v);
                                    } catch (IllegalAccessException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            });
                }
        );
    }
}

