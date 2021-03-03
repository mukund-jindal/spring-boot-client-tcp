package com.clientSocket.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

@Service
public class TransactionService {

    @Autowired
    public ClientService clientService;
    public static int START_TRANSACTION_REQUEST = 01;
    public static int START_TRANSACTION_RESPONSE = 02;
    // ConcurrentMap<String,>

    static Map<Integer, Object> schemaMapping = new HashMap<>() {
        {
            put(START_TRANSACTION_REQUEST, StartTransactionRequest.class);
            put(START_TRANSACTION_RESPONSE, StartTransactionResponse.class);
        }
    };

    public StartTransactionResponse request(StartTransactionRequest startTransactionRequest) {
        int transactionId = 3;
        ObjectOutputStream writer = clientService.getWriterObject();

        StartTransactionResponse startTransactionResponse = null;
        try {
            writer.writeInt(START_TRANSACTION_REQUEST);
            writer.writeObject(startTransactionRequest);
            writer.flush();
            ObjectInputStream reader = clientService.getReaderObject();
            int getResponse = reader.readInt();
            System.out.println(getResponse);
            if (reader.readInt() == START_TRANSACTION_RESPONSE) {
                startTransactionResponse = (StartTransactionResponse) reader.readObject();
            }

        } catch (Exception e) {
            startTransactionResponse = StartTransactionResponse.builder().idTagInfo(
                    IdTagInfo.builder().status(Status.Invalid).build()

            ).transactionId(transactionId).build();
            e.printStackTrace();

        }
        return startTransactionResponse;

        //byte[] header = ByteBuffer.allocate(4).putInt(START_TRANSACTION_REQUEST).array();
        // writer.write(START_TRANSACTION_REQUEST);

    }
}
