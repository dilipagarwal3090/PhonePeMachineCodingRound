package com.phonepe.strategy;

import com.phonepe.enums.CommunicationChannel;
import com.phonepe.model.Provider;

import java.util.List;
import java.util.Random;

public class RandomProviderSelectionStrategy implements ProviderSelectionStrategy {
    @Override
    public Provider selectProvider(List<Provider> providers, CommunicationChannel channel) {
        Random random = new Random();
        Provider provider  = providers.get(random.nextInt(providers.size()));
        while(!provider.isActive()) {
            provider = providers.get(random.nextInt(providers.size()));
        }
        return provider;
    }
}
