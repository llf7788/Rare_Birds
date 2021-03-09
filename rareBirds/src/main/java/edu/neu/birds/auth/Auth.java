package edu.neu.birds.auth;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Auth {

    public static final Map<String, String> authMap;

    static  {
        authMap = new HashMap<>();
        authMap.put("/admin", "admin");
        authMap.put("/user", "user");
        authMap.put("/comment", "user");
    }
}
