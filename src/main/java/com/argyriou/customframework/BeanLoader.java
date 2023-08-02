// beanloader
// loadallclasses
// loadallbeans

package com.argyriou.customframework;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class BeanLoader {
    private final BeanContainer beanContainer;

    public BeanLoader(BeanContainer beanContainer) {
        this.beanContainer = beanContainer;
    }

    public void loadBeans(String classPath) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Set<Class<?>> classes = loadAllClassesInClassPath(classPath);
        for (Class<?> clazz : classes) {
            if (Arrays.stream(clazz.getAnnotations()).anyMatch(annotation -> annotation instanceof CustomBean)) {
                beanContainer.registerBean(clazz.getConstructor().newInstance());
            }
        }
    }

    private Set<Class<?>> loadAllClassesInClassPath(String classPath) {
        Set<Class<?>> result = new HashSet<>();
        loadAllClassesInClassPath(classPath, result);
        return result;
    }

    private void loadAllClassesInClassPath(String classPath, Set<Class<?>> classes) {
        File pkgF = new File(classPath);
        for (File fileEntry : Objects.requireNonNull(pkgF.listFiles())) {
            if (fileEntry.isDirectory()) {
                loadAllClassesInClassPath(fileEntry.toString(), classes);
            } else {
                try {
                    String path = fileEntry.toString().substring(fileEntry.toString().indexOf("com"));
                    Class<?> clazz = Class.forName(FilenameUtils.removeExtension(path.replace('/', '.')));
                    classes.add(clazz);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

