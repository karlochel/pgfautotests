package org.tests.petstore.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.json.JSONObject;


public class JsonParser {

   private final static ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule())
           .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

   public String classToJsonString(Object classToParse){
       try{
           return objectMapper.writeValueAsString(classToParse);
       } catch (JsonProcessingException ex) {
           throw new RuntimeException("Unable to parse object to Json string", ex);
       }
   }

    public JSONObject classToJsonObject(Object classToParse){
       String jsonString;
        try{
            jsonString = objectMapper.writeValueAsString(classToParse);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException("Unable to parse object to Json string", ex);
        }
        return new JSONObject(jsonString);
    }
}
