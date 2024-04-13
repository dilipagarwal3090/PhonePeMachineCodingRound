package com.phonepe.factory;

import com.phonepe.enums.CommunicationChannel;
import com.phonepe.model.Provider;
import lombok.NonNull;

import java.util.List;
import java.util.Map;

public class ProviderFactory {
    public static Provider createProvider(@NonNull final String name,
                                          @NonNull final Map<CommunicationChannel, String> apiEndpoints
    ) {
        return new Provider(name, apiEndpoints);
    }
}
