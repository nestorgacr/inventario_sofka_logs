package com.epa.inventarioLog.usecase;


import com.epa.inventarioLog.drivenAdapters.repositorios.ILogRepository;
import com.epa.inventarioLog.models.dto.TransaccionDto;
import com.epa.inventarioLog.utils.TransaccionUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ListarLogsVentaAlPorMayorUseCase implements ListarProductosSinFiltro {
    private final ILogRepository repositorio;

    public ListarLogsVentaAlPorMayorUseCase(ILogRepository repositorio) {
        this.repositorio = repositorio;
    }
    @Override
    public Flux<TransaccionDto> apply()
    {

        return repositorio.findVentaAlPorMayor()
                .map(TransaccionUtil::entityToDto);
    }
}
