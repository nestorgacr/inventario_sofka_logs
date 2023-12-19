package com.epa.inventarioLog.usecase;


import reactor.core.publisher.Flux;

@FunctionalInterface
public interface PaginacionFuncion<T> {
    Flux<T> apply(int pagina, int tamanno);
}
