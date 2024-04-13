package com.phonepe.model;

import com.phonepe.enums.CommunicationChannel;

public interface CommunicationRequest {
    void sendRequest();

    CommunicationChannel getChannel();
}

