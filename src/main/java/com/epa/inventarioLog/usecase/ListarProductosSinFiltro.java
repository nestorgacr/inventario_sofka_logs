package com.epa.inventarioLog.usecase;


import reactor.core.publisher.Flux;

@FunctionalInterface
public interface ListarProductosSinFiltro<T> {
    Flux<T> apply();
}
