package com.wss.assignment.restserver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(HttpStatus httpStatus, String message, Object data){
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("status", httpStatus.value());
        map.put("message", message);
        map.put("data", data);

        return new ResponseEntity<Object>(map,httpStatus);
    }
}
