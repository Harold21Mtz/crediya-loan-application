package com.application.model.status.gateways;

import reactor.core.publisher.Mono;

public interface StatusRepository {
    Mono<Long> findStatusByName(String name);
}
