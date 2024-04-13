package com.phonepe;

import com.phonepe.enums.CommunicationChannel;
import com.phonepe.model.CommunicationRequest;
import com.phonepe.model.Provider;
import com.phonepe.model.ProviderAccount;
import com.phonepe.strategy.AccountSelectionStrategy;
import com.phonepe.strategy.ChannelAccountSelectionStrategy;
import com.phonepe.strategy.ProviderSelectionStrategy;
import com.phonepe.strategy.RandomProviderSelectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class CommunicationLayer {
    private static CommunicationLayer instance;
    private List<Provider> providers;

    private ProviderSelectionStrategy providerSelectionStrategy;
    private AccountSelectionStrategy accountSelectionStrategy;

    private CommunicationLayer() {
        this.providers = new ArrayList<>();
        providerSelectionStrategy = new RandomProviderSelectionStrategy();
        accountSelectionStrategy = new ChannelAccountSelectionStrategy();
    }

    public static CommunicationLayer getInstance() {
        if (instance == null) {
            instance = new CommunicationLayer();
        }
        return instance;
    }

    public void addProvider(Provider provider) {
        this.providers.add(provider);
    }

    public Provider getProvider(String providerId) {
        for (Provider provider : providers) {
            if (provider.getProviderId().equals(providerId)) {
                return provider;
            }
        }
        return null;
    }

    public void updateState(String providerId, boolean active) {
        Provider provider = getProvider(providerId);
        if (provider != null) {
            provider.setActive(active);
        }
    }

    public void updateProvider(Provider provider) {
        Provider existingProvider = getProvider(provider.getProviderId());
        if (existingProvider != null) {
            existingProvider.setName(provider.getName());
            existingProvider.setApiEndpoints(provider.getApiEndpoints());
            existingProvider.setActive(provider.isActive());
            existingProvider.setAccounts(provider.getAccounts());
        }
    }

    public void processRequest(CommunicationRequest request) {
        CommunicationChannel channel = request.getChannel();

        // Choose provider using random selection strategy
        Provider selectedProvider = providerSelectionStrategy.selectProvider(providers, channel);

        if (selectedProvider != null) {
            // Choose account based on the communication channel type
            ProviderAccount selectedAccount = accountSelectionStrategy.selectAccount(selectedProvider.getAccounts(), channel);
            if (isAuthenticatedRequest() && selectedAccount != null) {
                // Send request using the selected provider and account
                System.out.println("Sending request using provider: " + selectedProvider.getName() + " and account: " + selectedAccount.getAccountId());
                selectedProvider.sendRequest();
            } else {
                System.out.println("No account found for channel: " + channel);
            }
        } else {
            System.out.println("No provider found for channel: " + channel);
        }
    }

    // To authenticate the request
    private boolean isAuthenticatedRequest() {
        return true;
    }
}

