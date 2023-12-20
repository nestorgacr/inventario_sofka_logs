package com.epa.inventarioLog.routes;

import com.epa.inventarioLog.handlers.ErrorHandler;
import com.epa.inventarioLog.handlers.LogHandler;
import com.epa.inventarioLog.models.dto.ErrorDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
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

@RouterOperation(
        path = "/Error/Listar/{tamaño}/{pagina}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        beanClass = ErrorHandler.class,
        beanMethod = "listar",
        method = RequestMethod.GET,
        operation = @Operation(
                tags = "Errores",
                parameters = {
                        @Parameter(name = "tamano", in = ParameterIn.PATH, required = true, description = "Tamaño de la página"),
                        @Parameter(name = "pagina", in = ParameterIn.PATH, required = true, description = "Página")
                },
                responses = {
                        @ApiResponse(
                                responseCode = "200",
                                description = "Listado de errores",
                                content = @Content(array = @ArraySchema(schema = @Schema(implementation = ErrorDto.class)))
                        )
                }
        )
)
    public RouterFunction<ServerResponse> routerFunctionError() {
        return RouterFunctions.route()
                .path("/Error", builder ->
                        builder
                                .GET("/Listar/{tamano}/{pagina}", handler::listar)
                )
                .build();
    }
}
