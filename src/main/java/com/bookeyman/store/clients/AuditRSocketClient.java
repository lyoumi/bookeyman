package com.bookeyman.store.clients;


import com.bookeyman.store.data.AuditReportPayload;
import com.bookeyman.store.data.AuditReportPayload.ActionType;
import com.bookeyman.store.entity.BookProduct;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.messaging.rsocket.annotation.support.RSocketMessageHandler;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.time.Duration;
import java.time.LocalDateTime;

@Slf4j
@ShellComponent
public class AuditRSocketClient {

    private final RSocketRequester rsocketRequester;

    @Autowired
    public AuditRSocketClient(RSocketRequester.Builder builder,
            @Qualifier("rSocketStrategies") RSocketStrategies strategies,
            @Value("${audit.server.port}") Integer auditServerPort,
            @Value("${audit.server.host}") String auditServerHost) {
        this.rsocketRequester = builder
                .rsocketConnector(connector -> connector.acceptor(
                        RSocketMessageHandler.responder(strategies, new ClientHandler())))
                .tcp(auditServerHost, auditServerPort);
    }

    @ShellMethod("Login with your username and password.")
    public void sendAuditReport(BookProduct book, ActionType actionType) {

        AuditReportPayload auditReportPayload = rsocketRequester
                .route("audit-report")
                .data(new AuditReportPayload(book.getId(), book.getPrice(), actionType, LocalDateTime.now()))
                .retrieveMono(AuditReportPayload.class)
                .block();

        log.info("Incoming audit response: {}", auditReportPayload);
    }

}

@Slf4j
class ClientHandler {

    @MessageMapping("client-status")
    public Flux<String> statusUpdate(String status) {
        log.info("Connection {}", status);
        return Flux.interval(Duration.ofSeconds(5)).map(index -> String.valueOf(Runtime.getRuntime().freeMemory()));
    }
}
