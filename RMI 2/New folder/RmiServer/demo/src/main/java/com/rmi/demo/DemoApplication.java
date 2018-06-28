package com.rmi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    OrderService orderService(){
        return new OrderServiceImpl();
    }

    @Bean
    RmiServiceExporter exporter(OrderService orderService){
        Class <OrderService> serviceInterface = OrderService.class;
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName(OrderService.class.getSimpleName());
        exporter.setService(orderService);
        exporter.setServiceInterface(serviceInterface);
        exporter.setServicePort(1099);

        return exporter;
    }
}
