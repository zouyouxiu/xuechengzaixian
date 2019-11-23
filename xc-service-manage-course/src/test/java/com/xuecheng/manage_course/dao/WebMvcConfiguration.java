package com.xuecheng.manage_course.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.lang.annotation.Target;

@Configuration
public class WebMvcConfiguration {

    @MyAnno // 会把所有标注有此注解的Bean都收入囊中，请List装（因为会有多个）
    @Autowired
    public List<Person> persons;

    @MyAnno
    @Bean
    public Person person1() {
        System.out.println("person1");
        return new Person("fsx01", 16);
    }
    @MyAnno
    @Bean
    public Person person2() {
        System.out.println("person1");
        return new Person("fsx02", 18);
    }

    // 自定义注解：上面标注有@Qualifier注解
    @Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Qualifier
    @interface MyAnno {
    }



}
