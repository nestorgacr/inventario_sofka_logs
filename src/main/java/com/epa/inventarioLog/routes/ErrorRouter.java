package com.epa.inventarioLog.routes;

import com.epa.inventarioLog.handlers.ErrorHandler;
import com.epa.inventarioLog.handlers.LogHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ErrorRouter {
    private final ErrorHandler handler;

    public ErrorRouter(ErrorHandler handler) {
        this.handler = handler;
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunctionError() {
        return RouterFunctions.route()
                .path("/Error", builder ->
                        builder
                                .GET("/Listar/{tamaño}/{pagina}", handler::listar)
                )
                .build();
    }
}
