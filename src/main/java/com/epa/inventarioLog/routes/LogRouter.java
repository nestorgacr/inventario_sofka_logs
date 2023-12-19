package com.epa.inventarioLog.routes;


import com.epa.inventarioLog.handlers.LogHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class LogRouter {
    private final LogHandler handler;

    public LogRouter(LogHandler handler) {
        this.handler = handler;
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunctionLog() {
        return RouterFunctions.route()
                .path("/Log", builder ->
                        builder
                                .GET("/Listar/{tamaño}/{pagina}", handler::listar)
                                .GET("/Listar/{idProducto}", handler::listarTransaccionesPorIdProducto)
                                .GET("/ListarVentasAlPorMenor", handler::listarVentasAlPorMenor)
                                .GET("/ListarVentasAlPorMayor", handler::listarVentasAlPorMayor)
                )
                .build();
    }
}
