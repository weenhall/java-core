package com;

import static org.junit.Assert.assertTrue;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.junit.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Unit test for simple App.
 */
public class AppTest {
    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
        try {
            BigDecimal b1=BigDecimal.ONE;
            BigDecimal b2=BigDecimal.ZERO;
            System.out.println(b2.compareTo(b1));

            Class c1=Class.forName("com.AppTest");
            Object obj=c1.newInstance();
            System.out.println(obj.getClass().getName());

            int a = 1 / 0;
        } catch (Exception e) {
            logger.error("ERROR", e);
            e.printStackTrace();
        }
    }

    @Test
    public void testQueue() {
        Queue<Integer> nums = new LinkedList<>();
        //添加元素
        nums.offer(0);
        nums.offer(1);
        nums.offer(2);
        nums.offer(3);
        nums.offer(4);
        nums.offer(5);
        System.out.println("遍历元素:");
        nums.forEach(System.out::println);
        //返回第一个元素并删除
        Integer first = nums.poll();
        System.out.println("取出队列的第一个元素,并将其删除:" + first);
        System.out.println("遍历元素:");
        nums.forEach(System.out::println);

        System.out.println("取出第一个元素:" + nums.element());
        System.out.println("遍历元素:");
        nums.forEach(System.out::println);
    }

    @Test
    public void testCurrentTimeMillis() throws DatatypeConfigurationException {
        Calendar cld=Calendar.getInstance();
        int cyear=cld.get(Calendar.YEAR);
        cld.clear();
        cld.set(Calendar.YEAR,cyear);
        GregorianCalendar cla = new GregorianCalendar();
        cla.setTime(cld.getTime());
        XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cla);
        xgc.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
        System.out.println(xgc);
    }

    @Test
    public void test()  {
        AtomicInteger a=new AtomicInteger();
        a.set(1);
        System.out.println();
    }
}
