package com.clientSocket.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/request")
    @ResponseBody
    public String getRequest(@RequestParam String id){
        return clientService.getRequest(id);
    }
}
