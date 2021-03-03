package com.clientSocket.Client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StartTransactionRequest implements Serializable {
    public String connectorId;
    public String idTag;
    public int meterStart;
    public int reservationId;
    public long timestamp;
}