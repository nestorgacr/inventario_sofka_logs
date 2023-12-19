package com.epa.inventarioLog.usecase;

import com.epa.inventarioLog.drivenAdapters.repositorios.IErrorRepository;
import com.epa.inventarioLog.drivenAdapters.repositorios.ILogRepository;
import com.epa.inventarioLog.models.dto.ErrorDto;
import com.epa.inventarioLog.models.dto.LogDto;
import com.epa.inventarioLog.models.dto.TransaccionDto;
import com.epa.inventarioLog.models.mongo.Error;
import com.epa.inventarioLog.models.mongo.Log;
import com.epa.inventarioLog.utils.ErrorUtil;
import com.epa.inventarioLog.utils.TransaccionUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class RegistrarErrorUseCase implements Function<ErrorDto, Mono<ErrorDto>> {

    private final IErrorRepository repositorio;

    public RegistrarErrorUseCase(IErrorRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Mono<ErrorDto> apply(ErrorDto errorDto) {

        Error error = ErrorUtil.dtoToEntity(errorDto);

        return repositorio.save(error).map(
                ErrorUtil::entityToDto
        );
    }
}
