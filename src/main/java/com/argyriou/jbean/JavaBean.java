//jbean

package com.argyriou.jbean;

import java.io.Serializable;

/**
 * Is this a Java Bean ?
 */
public class JavaBean implements Serializable {
    private String property;

    public JavaBean() {
    }

    public Object getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}