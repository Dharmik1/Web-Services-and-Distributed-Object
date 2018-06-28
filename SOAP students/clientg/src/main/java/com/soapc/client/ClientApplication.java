package com.soapc.client;

//import com.soapc.client.schemas.school.StudentDetailsRequest;
//import com.soapc.client.schemas.school.StudentDetailsResponse;
import hello.wsdl.StudentDetailsRequest;
import hello.wsdl.StudentDetailsResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import com.example.howtodoinjava.schemas.school.StudentDetailsRequest;
//import com.example.howtodoinjava.schemas.school.StudentDetailsResponse;

@SpringBootApplication
public class ClientApplication{

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(SOAPConnector soapConnector) {
        return args -> {
            String name = "Dharmik";//Default Name
            if(args.length>0){
                name = args[0];
            }
            StudentDetailsRequest request = new StudentDetailsRequest();
            request.setName(name);
            StudentDetailsResponse response =(StudentDetailsResponse) soapConnector.callWebService("http://localhost:8080/service/student-details", request);
            System.out.println("Got Response As below ========= : ");
            System.out.println("Name : "+response.getStudent().getName());
            System.out.println("Gender : "+response.getStudent().getGender());
            System.out.println("Class : "+response.getStudent().getClazz());
            System.out.println("Address : "+response.getStudent().getAddress());
        };
    }
}
