package com.clientSocket.Client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IdTagInfo {
    private long expiryDate;
    private String parentIdTag;
    private Status status;
}
