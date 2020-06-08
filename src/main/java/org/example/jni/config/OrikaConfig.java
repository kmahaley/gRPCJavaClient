package org.example.jni.config;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.example.NMVnext.GRPCBook;
import org.example.jni.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrikaConfig {

    @Bean
    public MapperFacade orikaMapper() {

        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Book.class, GRPCBook.Book.class)
                .byDefault()
                .register();

        return mapperFactory.getMapperFacade();
    }
}
