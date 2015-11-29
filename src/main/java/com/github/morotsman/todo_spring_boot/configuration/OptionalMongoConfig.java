package com.github.morotsman.todo_spring_boot.configuration;

import com.mongodb.MongoClientOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author niklasleopold
 */
@Configuration
public class OptionalMongoConfig {
    
    
    //@Bean
    public MongoClientOptions createClientOptions(){
        return new MongoClientOptions.Builder()
                //.connectTimeout(3000)
                .build();
    }
    
}
