

package com.soap.countriesclient;

        import hello.wsdl.Country;
        import hello.wsdl.GetCountryResponse;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.annotation.Bean;

        import javax.management.MXBean;

@SpringBootApplication
public class  CountriesclientApplication {

    public static void main(String[] args) {
        SpringApplication.run( CountriesclientApplication.class, args);
    }
    @Bean
    CommandLineRunner lookup(Client countryClient){
        return args -> {
            String name = "Poland";
            if(args.length>0){
                name = args[0];

            }
            GetCountryResponse response = countryClient.getCountryResponse(name);
            Country country = response.getCountry();
            System.out.println("Country : " + country.getName());
            System.out.println("Capital : "+country.getCapital());
            System.out.println("Currency : "+country.getCurrency());
            System.out.println("Population : "+country.getPopulation());


        };
    }

}
