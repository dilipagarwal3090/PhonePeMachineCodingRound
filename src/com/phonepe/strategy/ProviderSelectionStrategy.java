package com.phonepe.strategy;

import com.phonepe.enums.CommunicationChannel;
import com.phonepe.model.Provider;

import java.util.List;

public interface ProviderSelectionStrategy {
    Provider selectProvider(List<Provider> providers, CommunicationChannel channel);
}
