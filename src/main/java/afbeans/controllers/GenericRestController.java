package afbeans.controllers;

import org.springframework.http.HttpHeaders;

/***

 Created by 
 @author dkammara on Thursday - 11/14/2019

 */
public class GenericRestController {

    public HttpHeaders getDefaultResponseHeaders(){
        HttpHeaders responseHeaders=new HttpHeaders();
        return responseHeaders;
    }
}
