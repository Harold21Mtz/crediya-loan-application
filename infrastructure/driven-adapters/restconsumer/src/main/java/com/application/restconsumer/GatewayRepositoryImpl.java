package com.application.restconsumer;

import com.application.model.gateway.Gateway;
import com.application.model.gateway.gateways.GatewayRepository;
import com.application.restconsumer.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class GatewayRepositoryImpl implements GatewayRepository {

    private final WebClient.Builder webClientBuilder;

    @Override
    public Mono<Gateway> findByDocument(String documentNumber) {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8090/api/v1/usuario/{documentNumber}", documentNumber)
                .retrieve()
                .onStatus(
                        status -> status.value() == 404,
                        response -> Mono.error(new ResourceNotFoundException("Usuario no encontrado con documento: " + documentNumber))
                )
                .bodyToMono(Gateway.class);
    }
}
