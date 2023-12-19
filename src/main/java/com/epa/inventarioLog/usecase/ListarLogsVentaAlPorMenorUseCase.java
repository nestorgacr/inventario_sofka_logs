package com.epa.inventarioLog.usecase;


import com.epa.inventarioLog.drivenAdapters.repositorios.ILogRepository;
import com.epa.inventarioLog.models.dto.TransaccionDto;
import com.epa.inventarioLog.utils.TransaccionUtil;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
public class ListarLogsVentaAlPorMenorUseCase implements ListarProductosSinFiltro {
    private final ILogRepository repositorio;

    public ListarLogsVentaAlPorMenorUseCase(ILogRepository repositorio) {
        this.repositorio = repositorio;
    }
    @Override
    public Flux<TransaccionDto> apply()
    {

        return repositorio.findVentaAlPorMenor()
                .map(TransaccionUtil::entityToDto);
    }
}
