package com.epa.inventarioLog.utils;


import com.epa.inventarioLog.models.dto.TransaccionDto;
import com.epa.inventarioLog.models.mongo.Log;
import org.springframework.beans.BeanUtils;

public class TransaccionUtil {
    public static TransaccionDto entityToDto(Log entidad) {
        TransaccionDto dto = new TransaccionDto();
        BeanUtils.copyProperties(entidad, dto);
        return dto;
    }

    public static Log dtoToEntity(TransaccionDto dto) {
        Log entidad = new Log();
        BeanUtils.copyProperties(dto, entidad);
        return entidad;
    }
}
