package com.phonepe.strategy;

import com.phonepe.enums.CommunicationChannel;
import com.phonepe.model.ProviderAccount;

import java.util.List;

public interface AccountSelectionStrategy {
    ProviderAccount selectAccount(List<ProviderAccount> accounts, CommunicationChannel channel);
}
