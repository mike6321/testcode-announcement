package com.example.context_caching.step03;

import com.example.context_caching.MockClass;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ContextCachingFactory.class)
public abstract class ContextCachingTest {

    @MockBean
    protected MockClass mockClass;

}
