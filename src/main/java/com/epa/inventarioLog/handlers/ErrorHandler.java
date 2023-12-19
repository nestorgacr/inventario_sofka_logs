package com.epa.inventarioLog.handlers;


import com.epa.inventarioLog.models.dto.ErrorDto;
import com.epa.inventarioLog.models.dto.TransaccionDto;
import com.epa.inventarioLog.usecase.ListarErroresUseCase;
import com.epa.inventarioLog.usecase.ListarLogsUseCase;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ErrorHandler {
    private final ListarErroresUseCase listarErroresUseCase;

    public ErrorHandler(ListarErroresUseCase listarErroresUseCase) {
        this.listarErroresUseCase = listarErroresUseCase;
    }


    public Mono<ServerResponse> listar(ServerRequest request)
    {

        String pagina = request.pathVariable("pagina");
        String tamanno = request.pathVariable("tamaño");

        int numeroPagina = Integer.parseInt(pagina);
        int tamanoPagina = Integer.parseInt(tamanno);

      Flux<ErrorDto> list = listarErroresUseCase.apply(numeroPagina, tamanoPagina);

        return ServerResponse.ok()
                .body(list, TransaccionDto.class);
    }


}
