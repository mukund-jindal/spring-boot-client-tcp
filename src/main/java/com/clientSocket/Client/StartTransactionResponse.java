package com.clientSocket.Client;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class StartTransactionResponse implements Serializable {
        private IdTagInfo idTagInfo;
        private int transactionId;
}