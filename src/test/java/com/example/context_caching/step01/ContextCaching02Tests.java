package com.example.context_caching.step01;

import com.example.context_caching.TestBClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestBClass.class)
public class ContextCaching02Tests {

    @Autowired
    private TestBClass testBClass;

    @Test
    void test01() {
        testBClass.message();
    }

    @Test
    void test02() {
        testBClass.message();
    }

    @Test
    void test03() {
        testBClass.message();
    }

}
