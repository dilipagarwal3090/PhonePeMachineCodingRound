package com.phonepe.model;

import com.phonepe.enums.CommunicationChannel;

public class SoundboxRequest implements CommunicationRequest {
    public SoundboxRequest(String message) {
    }

    @Override
    public void sendRequest() {
        // Implement logic to send email request
        System.out.println("Sending soundbox request...");
    }

    @Override
    public CommunicationChannel getChannel() {
        return CommunicationChannel.SOUNDBOX;
    }
}
