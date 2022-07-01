package com.example.context_caching.step01;

import com.example.context_caching.TestAClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = TestAClass.class)
@SpringBootTest(classes = TestAClass.class)
public class ContextCaching01Tests {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private TestAClass testAClass;

    @Test
    void test01() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.asList(beanDefinitionNames)
                .forEach(System.out::println);
        testAClass.message();
    }

    @Test
    void test02() {
        testAClass.message();
    }

    @Test
    void test03() {
        testAClass.message();
    }

}
