package it.gft.skillmanager.controller;


import it.gft.skillmanager.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
public class LoginController {



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login() {
        String r = "{" +
                "    \"jwt\": \"eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjp7InVzZXJuYW1lIjoiVTBKOTU0MCIsImF1dGhvcml0aWVzIjpbeyJjb2RpY2UiOiJZQVpNMDAifV0sIm5vbWUiOiJQYW9sbyIsImNvZ25vbWUiOiJSb3NzaSJ9fQ.51WZSYl5S0qMYqGqGR6sfaC1djtLLlb_gba23ugC8Ds\"," +
                "    \"user\": {" +
                "        \"username\": \"a74z\"," +
                "        \"authorities\": [" +
                "            {" +
                "                \"codice\": \"YAZM00\"" +
                "            }" +
                "        ]," +
                "        \"nome\": \"Alessio\"," +
                "        \"cognome\": \"Baldini\"," +
                "        \"type\":\"SM\"" +
                "    }" +
                "}";
        return r;
        }
    }

