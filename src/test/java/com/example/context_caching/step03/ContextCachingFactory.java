package com.example.context_caching.step03;

import com.example.Item;
import com.example.context_caching.TestAClass;
import com.example.context_caching.TestBClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextCachingFactory {

    @Bean
    public TestAClass testAClass() {
        return new TestAClass();
    }

    @Bean
    public TestBClass testBClass() {
        return new TestBClass();
    }

    @Bean
    public Item item() {
        return new Item();
    }

}
