package org.example.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collections;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Library library = context.getBean("libraryBean", Library.class);

        library.getBook();
        context.close();
    }
}
