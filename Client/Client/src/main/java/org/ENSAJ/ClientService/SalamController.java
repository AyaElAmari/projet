package org.ENSAJ.ClientService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalamController {

    @GetMapping("/Salam")
    public String getSalamController(){
        return "Salam";
    }
}
