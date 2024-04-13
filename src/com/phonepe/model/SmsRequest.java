package com.phonepe.model;

import com.phonepe.enums.CommunicationChannel;

/**
 * SMS Request
 */
public class SmsRequest implements CommunicationRequest {
    private String mobileNumber;
    private String message;

    public SmsRequest(String receiver, String message) {
        this.mobileNumber = receiver;
        this.message = message;
    }

    @Override
    public void sendRequest() {
        System.out.println("Sending SMS request...");
    }

    @Override
    public CommunicationChannel getChannel() {
        return CommunicationChannel.SMS;
    }
}