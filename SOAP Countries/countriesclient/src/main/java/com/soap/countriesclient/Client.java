package com.soap.countriesclient;

import hello.wsdl.GetCountryResponse;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import hello.wsdl.GetCountryRequest;
import hello.wsdl.GetCountryResponse;

import java.util.logging.Logger;

public class Client extends WebServiceGatewaySupport {


    public GetCountryResponse getCountryResponse(String countryname) {
        GetCountryRequest request = new GetCountryRequest();
        request.setName(countryname);


        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws",
                        request,
                        new SoapActionCallback("http://localhost:8080/ws"));

        return response;
    }

}
