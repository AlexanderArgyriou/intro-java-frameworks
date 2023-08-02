// mybean
// implement the MyBeanIf

package com.argyriou.customframework;

@CustomBean
public class MyBean implements MyBeanIf{
    @CustomTransaction
    public void identifyYourSelf() {
        System.out.printf("Hello, i am bean %s and i am registered to the bean container%n", MyBean.class);
    }
}
