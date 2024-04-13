package com.phonepe.model;

import com.phonepe.enums.CommunicationChannel;

public class EmailRequest implements CommunicationRequest {
    private String sender;
    private String receiver;
    private String subject;
    private String message;

    public EmailRequest(String sender, String receiver, String subject, String message) {
    }

    // Constructor, getters, and setters

    @Override
    public void sendRequest() {
        // Implement logic to send email request
        System.out.println("Sending email request...");
    }

    @Override
    public CommunicationChannel getChannel() {
        return CommunicationChannel.EMAIL;
    }
}
