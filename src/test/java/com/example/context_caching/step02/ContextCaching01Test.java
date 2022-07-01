package com.example.context_caching.step02;

import com.example.context_caching.MockClass;
import com.example.context_caching.TestAClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        TestAClass.class
})
public class ContextCaching01Test {

    @MockBean
    private MockClass mockClass;
    @Autowired
    private TestAClass testAClass;

    @Test
    void test01() {
        testAClass.message();
    }

}
