package com.example.context_caching.step03;

import com.example.context_caching.TestAClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

public class ContextCaching01Test extends ContextCachingTest{

    @Autowired
    private TestAClass testAClass;
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void test01() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames)
                        .forEach(System.out::println);
        testAClass.message();
        mockClass.method();
    }

}
