package com.epa.inventarioLog.handlers;


import com.epa.inventarioLog.models.dto.TransaccionDto;
import com.epa.inventarioLog.usecase.ListarLogsPorIdProductoUseCase;
import com.epa.inventarioLog.usecase.ListarLogsUseCase;
import com.epa.inventarioLog.usecase.ListarLogsVentaAlPorMayorUseCase;
import com.epa.inventarioLog.usecase.ListarLogsVentaAlPorMenorUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LogHandler {
    private final ListarLogsUseCase listarLogsUseCase;
    private final ListarLogsPorIdProductoUseCase listarLogsPorIdProductoUseCase;

    private final ListarLogsVentaAlPorMenorUseCase listarLogsVentaAlPorMenorUseCase;

    private final ListarLogsVentaAlPorMayorUseCase listarLogsVentaAlPorMayorUseCase;

    public LogHandler(ListarLogsUseCase listarLogsUseCase, ListarLogsPorIdProductoUseCase listarLogsPorIdProductoUseCase, ListarLogsVentaAlPorMenorUseCase listarLogsVentaAlPorMenorUseCase, ListarLogsVentaAlPorMayorUseCase listarLogsVentaAlPorMayorUseCase) {
        this.listarLogsUseCase = listarLogsUseCase;
        this.listarLogsPorIdProductoUseCase = listarLogsPorIdProductoUseCase;
        this.listarLogsVentaAlPorMenorUseCase = listarLogsVentaAlPorMenorUseCase;
        this.listarLogsVentaAlPorMayorUseCase = listarLogsVentaAlPorMayorUseCase;
    }



    public Mono<ServerResponse> listar(ServerRequest request)
    {

        String pagina = request.pathVariable("pagina");
        String tamanno = request.pathVariable("tamaño");

        int numeroPagina = Integer.parseInt(pagina);
        int tamanoPagina = Integer.parseInt(tamanno);

      Flux<TransaccionDto> list = listarLogsUseCase.apply(numeroPagina, tamanoPagina);

        return ServerResponse.ok()
                .body(list, TransaccionDto.class);
    }

    public Mono<ServerResponse> listarTransaccionesPorIdProducto(ServerRequest request)
    {

        String idProducto = request.pathVariable("idProducto");

        Flux<TransaccionDto> list = listarLogsPorIdProductoUseCase.apply(idProducto);

        return ServerResponse.ok()
                .body(list, TransaccionDto.class);
    }

    public Mono<ServerResponse> listarVentasAlPorMenor(ServerRequest request)
    {


        Flux<TransaccionDto> list = listarLogsVentaAlPorMenorUseCase.apply();

        return ServerResponse.ok()
                .body(list, TransaccionDto.class);
    }

    public Mono<ServerResponse> listarVentasAlPorMayor(ServerRequest request)
    {


        Flux<TransaccionDto> list = listarLogsVentaAlPorMayorUseCase.apply();

        return ServerResponse.ok()
                .body(list, TransaccionDto.class);
    }


}
