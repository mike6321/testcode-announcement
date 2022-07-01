package com.example.context_caching.step03;

import com.example.context_caching.TestAClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ContextCaching02Test extends ContextCachingTest{

    @Autowired
    private TestAClass testAClass;

    @Test
    void test01() {
        testAClass.message();
    }

}
