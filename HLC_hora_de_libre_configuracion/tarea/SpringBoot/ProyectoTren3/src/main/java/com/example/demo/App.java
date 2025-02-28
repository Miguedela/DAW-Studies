package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Trip trainTrip = context.getBean(Trip.class);

        System.out.println("TrainTrip was created;\n" + trainTrip);

        context.close();
    }
}
