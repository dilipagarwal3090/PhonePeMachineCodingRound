package com.phonepe.strategy;

import com.phonepe.enums.CommunicationChannel;
import com.phonepe.model.ProviderAccount;

import java.util.List;

public class EmailTypeAccountSelectionStrategy implements AccountSelectionStrategy {
    @Override
    public ProviderAccount selectAccount(List<ProviderAccount> accounts, CommunicationChannel channel) {
        // Implement logic to select account based on email type
        // For now, just return the first account in the list
        return accounts.get(0);
    }
}