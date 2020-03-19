package com.dubbo.review.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {

        AtomicInteger atomicInteger=new AtomicInteger(1);
        int a=atomicInteger.getAndIncrement();

        System.out.println("a="+a);
    }

}
