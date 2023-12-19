package com.epa.inventarioLog.usecase;


import com.epa.inventarioLog.drivenAdapters.repositorios.ILogRepository;
import com.epa.inventarioLog.models.dto.TransaccionDto;
import com.epa.inventarioLog.utils.TransaccionUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ListarLogsUseCase implements PaginacionFuncion {
    private final ILogRepository repositorio;

    public ListarLogsUseCase(ILogRepository repositorio) {
        this.repositorio = repositorio;
    }
    @Override
    public Flux<TransaccionDto> apply(int pagina, int tamanno)
    {
        return repositorio.findAll().skip((long) (pagina - 1) * tamanno)
                .take(tamanno)
                .map(TransaccionUtil::entityToDto);
    }
}
