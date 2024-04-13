package com.phonepe.model;

import com.phonepe.enums.CommunicationChannel;

import java.util.List;
import java.util.UUID;

public class ProviderAccount {
    private String accountId;
    private String providerId;
    private List<CommunicationChannel> channels;
    private boolean active;

    // Constructor
    public ProviderAccount(String providerId, List<CommunicationChannel> channels) {
        this.accountId = UUID.randomUUID().toString();
        this.providerId = providerId;
        this.channels = channels;
        this.active = true;
    }

    public String getAccountId() {
        return this.accountId;
    }
}
