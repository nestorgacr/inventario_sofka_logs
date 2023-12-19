package com.epa.inventarioLog.utils;


import com.epa.inventarioLog.models.dto.ErrorDto;
import com.epa.inventarioLog.models.mongo.Error;
import org.springframework.beans.BeanUtils;

public class ErrorUtil {
    public static ErrorDto entityToDto(Error entidad) {
        ErrorDto dto = new ErrorDto();
        BeanUtils.copyProperties(entidad, dto);
        return dto;
    }

    public static Error dtoToEntity(ErrorDto dto) {
        Error entidad = new Error();
        BeanUtils.copyProperties(dto, entidad);
        return entidad;
    }
}
