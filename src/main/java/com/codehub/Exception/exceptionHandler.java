package com.codehub.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class exceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
      public ResponseEntity<Map<String,Object>> hanldeResourceNotFound(ResourceNotFound ex){
          Map<String,Object>map = new HashMap<>();
          map.put("timestamp", LocalDateTime.now());
          map.put("status", HttpStatus.NOT_FOUND.value());
          map.put("message",ex.getMessage());
          return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
      }
       @ExceptionHandler
       public ResponseEntity<Map<String,Object>> hanldegeneriExceptions(Exception ex){
           Map<String,Object>map = new HashMap<>();
           map.put("timestamp", LocalDateTime.now());
           map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
           map.put("message","Something went wrong !!! ");
           return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
       }
}
