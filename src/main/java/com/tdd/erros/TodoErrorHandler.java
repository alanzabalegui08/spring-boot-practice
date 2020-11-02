package com.tdd.erros;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;
import java.nio.charset.Charset;

public class TodoErrorHandler extends DefaultResponseErrorHandler {

    private Logger log =  LoggerFactory.getLogger(TodoErrorHandler.class);

     public void habldeError(ClientHttpResponse response){
         try {
             log.error(response.getStatusCode().toString());
             log.error(StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

}
