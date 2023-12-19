package com.epa.inventarioLog.usecase;


import com.epa.inventarioLog.drivenAdapters.repositorios.IErrorRepository;
import com.epa.inventarioLog.drivenAdapters.repositorios.ILogRepository;
import com.epa.inventarioLog.models.dto.ErrorDto;
import com.epa.inventarioLog.models.dto.TransaccionDto;
import com.epa.inventarioLog.utils.ErrorUtil;
import com.epa.inventarioLog.utils.TransaccionUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ListarErroresUseCase implements PaginacionFuncion {
    private final IErrorRepository repositorio;

    public ListarErroresUseCase(IErrorRepository repositorio) {
        this.repositorio = repositorio;
    }
    @Override
    public Flux<ErrorDto> apply(int pagina, int tamanno)
    {
        return repositorio.findAll().skip((long) (pagina - 1) * tamanno)
                .take(tamanno)
                .map(ErrorUtil::entityToDto);
    }
}
