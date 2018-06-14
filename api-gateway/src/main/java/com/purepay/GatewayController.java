package com.purepay;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by AndreaValenziano on 28/05/18.
 */
@RestController
public class GatewayController {

   @GetMapping("/")
    public String gateway(){
       return "HUB PUREPAY";
   }
}
