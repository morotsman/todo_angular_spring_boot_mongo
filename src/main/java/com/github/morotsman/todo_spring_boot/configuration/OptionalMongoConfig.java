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
        MongoClientOptions options = new MongoClientOptions.Builder()
                //.connectTimeout(3000)
                .build();
        System.out.println("****************Mongo Options*********************");
        System.out.println(options);
        System.out.println("**************************************************");
        
        return options;
    }
    
}
