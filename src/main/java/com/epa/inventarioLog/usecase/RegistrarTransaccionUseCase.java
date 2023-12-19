package com.epa.inventarioLog.usecase;

import com.epa.inventarioLog.drivenAdapters.repositorios.ILogRepository;
import com.epa.inventarioLog.models.dto.LogDto;
import com.epa.inventarioLog.models.dto.TransaccionDto;
import com.epa.inventarioLog.models.mongo.Log;
import com.epa.inventarioLog.utils.TransaccionUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


import java.util.function.Function;

@Service
public class RegistrarTransaccionUseCase implements Function<LogDto, Mono<TransaccionDto>> {

    private final ILogRepository repositorio;

    public RegistrarTransaccionUseCase(ILogRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Mono<TransaccionDto> apply(LogDto logDto) {

        Log log = TransaccionUtil.dtoToEntity(logDto.getData());


        return repositorio.save(log).map(
                TransaccionUtil::entityToDto
        );
    }
}
