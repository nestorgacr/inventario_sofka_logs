package com.epa.inventarioLog.usecase;


import com.epa.inventarioLog.drivenAdapters.repositorios.ILogRepository;
import com.epa.inventarioLog.models.dto.TransaccionDto;
import com.epa.inventarioLog.utils.TransaccionUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class ListarLogsPorIdProductoUseCase implements Function<String, Flux<TransaccionDto>> {
    private final ILogRepository repositorio;

    public ListarLogsPorIdProductoUseCase(ILogRepository repositorio) {
        this.repositorio = repositorio;
    }
    @Override
    public Flux<TransaccionDto> apply(String idProducto)
    {
        return repositorio.findByidProducto(idProducto)
                .map(TransaccionUtil::entityToDto);
    }
}
