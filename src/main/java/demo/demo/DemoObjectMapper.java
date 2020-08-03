package demo.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import demo.demo.entity.Demo;

public class DemoObjectMapper {
    private static String jsonTest = "{\"id\":1,\"name\":\"test\"}";

    public static void convertObjectToString() {
        try {
            Demo demo = new Demo(1, "test");
            ObjectMapper mapper = new ObjectMapper();
            String test = mapper.writeValueAsString(demo);
            System.out.println(test);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void convertStringToObject() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Demo demo = mapper.readValue(jsonTest, Demo.class);
            System.out.println(demo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        convertStringToObject();
    }

}
