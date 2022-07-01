package com.example.context_caching.step02;

import com.example.context_caching.TestAClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        TestAClass.class
})
public class ContextCaching02Test {

    @Autowired
    private TestAClass testAClass;

    @Test
    void test01() {
        testAClass.message();
    }

}
