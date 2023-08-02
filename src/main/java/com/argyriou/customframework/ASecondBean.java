// createsecondbean
// change field to interface
package com.argyriou.customframework;

@CustomBean
public class ASecondBean {
    @CustomInject
    private MyBeanIf myBean;

    public void testDependencies() {
        if (myBean != null) {
            myBean.identifyYourSelf();
        } else {
            System.out.println("Bean is not injected");
        }
    }
}
