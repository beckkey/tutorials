package com.baeldung.cglib.proxy;


import net.sf.cglib.beans.BeanGenerator;
import org.junit.Test;

import java.lang.reflect.Method;

import static junit.framework.TestCase.assertEquals;

public class BeanGeneratorTest {

    @Test
    public void testBeanGenerator() throws Exception {
        //given
        BeanGenerator beanGenerator = new BeanGenerator();

        //when
        beanGenerator.addProperty("value", String.class);
        Object myBean = beanGenerator.create();
        Method setter = myBean.getClass().getMethod("setValue", String.class);
        setter.invoke(myBean, "some string value set by a cglib");

        //then
        Method getter = myBean.getClass().getMethod("getValue");
        assertEquals("some string value set by a cglib", getter.invoke(myBean));
    }
}
