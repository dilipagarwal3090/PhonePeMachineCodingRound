package com.phonepe;

import com.phonepe.builder.CommunicationRequestBuilder;
import com.phonepe.enums.CommunicationChannel;
import com.phonepe.factory.ProviderFactory;
import com.phonepe.model.CommunicationRequest;

import com.phonepe.model.Provider;
import com.phonepe.model.ProviderAccount;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create some providers
        Provider provider1 = ProviderFactory.createProvider("Provider1", Map.of(
                CommunicationChannel.EMAIL, "http://provider1.com/email",
                CommunicationChannel.SMS, "",
                CommunicationChannel.SOUNDBOX, ""
                ));
        Provider provider2 = ProviderFactory.createProvider("Provider2", Map.of(
                CommunicationChannel.EMAIL, "",
                CommunicationChannel.SMS, "http://provider2.com/sms",
                CommunicationChannel.SOUNDBOX, ""
                ));

        Provider provider3 = ProviderFactory.createProvider("Provider3", Map.of(
                CommunicationChannel.EMAIL, "http://provider3.com/email",
                CommunicationChannel.SMS, "http://provider3.com/sms",
                CommunicationChannel.SOUNDBOX, ""
                ));

        // Create some provider accounts
        ProviderAccount account1 = new ProviderAccount(provider1.getProviderId(), List.of(CommunicationChannel.EMAIL, CommunicationChannel.SMS));
        ProviderAccount account2 = new ProviderAccount(provider2.getProviderId(), List.of(CommunicationChannel.EMAIL));

        // Add accounts to providers
        provider1.addAccount(account1);
        provider2.addAccount(account2);

        // Add providers to the communication layer
        CommunicationLayer communicationLayer = CommunicationLayer.getInstance();
        communicationLayer.addProvider(provider1);
        communicationLayer.addProvider(provider2);

        // Update state of a provider
        communicationLayer.updateState(provider1.getProviderId(), false);

        provider2.setName("UpdatedProvider2");
        communicationLayer.updateProvider(provider2);

        CommunicationRequest emailRequest = new CommunicationRequestBuilder()
                .setSender("sender@example.com")
                .setReceiver("receiver@example.com")
                .setSubject("Test Email")
                .setMessage("This is a test email.")
                .setChannel(CommunicationChannel.EMAIL)
                .build();

        // Process communication request
        communicationLayer.processRequest(emailRequest);

        // Create another communication request
        CommunicationRequest smsRequest = new CommunicationRequestBuilder()
                .setReceiver("8619113671")
                .setMessage("Test SMS")
                .setChannel(CommunicationChannel.SMS)
                .build();

        communicationLayer.processRequest(smsRequest);
    }
}
