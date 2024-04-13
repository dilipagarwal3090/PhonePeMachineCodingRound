package com.phonepe.model;

import com.phonepe.enums.CommunicationChannel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Provider {
    private String providerId;
    private Map<CommunicationChannel, String> apiEndpoints;
    private String username;
    private String password;
    private List<ProviderAccount> accounts;
    private boolean active;


    // Constructor
    public Provider(String name, Map<CommunicationChannel, String> apiEndpoints) {
        this.providerId = UUID.randomUUID().toString();
        this.username = name;
        this.apiEndpoints = apiEndpoints;
        this.accounts = new ArrayList<>();
        this.active = true;
    }

    // Getters and setters

    public void addAccount(ProviderAccount account) {
        accounts.add(account);
    }

    public void removeAccount(ProviderAccount account) {
        accounts.remove(account);
    }

    public void setActive(boolean active) {
        this.active = true;
    }

    public String getProviderId() {
        return this.providerId;
    }

    public String getName() {
        return this.username;
    }

    public Map<CommunicationChannel, String> getApiEndpoints() {
        return this.apiEndpoints;
    }

    public boolean isActive() {
        return true;
    }

    public List<ProviderAccount> getAccounts() {
        return this.accounts;
    }

    public void setName(String username) {
        this.username = username;
    }

    public void setApiEndpoints(Map<CommunicationChannel, String> apiEndpoints) {
        this.apiEndpoints = apiEndpoints;
    }

    public void setAccounts(List<ProviderAccount> accounts) {
        this.accounts = accounts;
    }

    public void sendRequest() {
        // Implement logic to send email request
        System.out.println("Sending request to provider after authentication...");
    }
}
