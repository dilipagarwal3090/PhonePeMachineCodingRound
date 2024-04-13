package com.phonepe.builder;

import com.phonepe.enums.CommunicationChannel;
import com.phonepe.model.CommunicationRequest;
import com.phonepe.model.EmailRequest;
import com.phonepe.model.SmsRequest;
import com.phonepe.model.SoundboxRequest;

public class CommunicationRequestBuilder {
    private String sender;
    private String receiver;
    private String subject;
    private String message;
    private CommunicationChannel channel;

    public CommunicationRequestBuilder() {
        // Default constructor
    }

    public CommunicationRequestBuilder setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public CommunicationRequestBuilder setReceiver(String receiver) {
        this.receiver = receiver;
        return this;
    }

    public CommunicationRequestBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public CommunicationRequestBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public CommunicationRequestBuilder setChannel(CommunicationChannel channel) {
        this.channel = channel;
        return this;
    }

    public CommunicationRequest build() {
        // Implement logic to build CommunicationRequest object based on provided parameters
        switch (channel) {
            case EMAIL:
                return new EmailRequest(sender, receiver, subject, message);
            case SMS:
                return new SmsRequest(receiver, message);
            case SOUNDBOX:
                return (CommunicationRequest) new SoundboxRequest(message);
            default:
                throw new IllegalArgumentException("Invalid communication channel");
        }
    }
}
