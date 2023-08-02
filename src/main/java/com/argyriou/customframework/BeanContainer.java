// beancontainer

package com.argyriou.customframework;

import java.util.ArrayList;
import java.util.List;

public class BeanContainer {
    private final List<Object> beans = new ArrayList<>();

    public void registerBean(Object bean) {
        beans.add(bean);
    }

    public Object getBean(Class<?> clazz) {
        return beans.stream()
                .filter(bean -> clazz.equals(bean.getClass()))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public List<Object> getAllBeans() {
        return beans;
    }
}

