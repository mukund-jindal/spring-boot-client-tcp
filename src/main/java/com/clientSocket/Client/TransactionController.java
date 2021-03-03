package com.clientSocket.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    @PostMapping("/transactionRequest")
    public StartTransactionResponse request(@RequestBody StartTransactionRequest startTransactionRequest){
        return transactionService.request(startTransactionRequest);
    }
}
