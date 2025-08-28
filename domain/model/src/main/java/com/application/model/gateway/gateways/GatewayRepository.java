package com.application.model.gateway.gateways;

import com.application.model.gateway.Gateway;
import reactor.core.publisher.Mono;

public interface GatewayRepository {
    Mono<Gateway> findByDocument(String documentNumber);
}
