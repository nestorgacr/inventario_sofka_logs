package com.epa.inventarioLog.drivenAdapters.repositorios;

import com.epa.inventarioLog.models.mongo.Log;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ILogRepository extends ReactiveMongoRepository<Log, String> {
   Flux<Log> findByidProducto (String idProducto);

   @Query("{ 'descuento': 0, 'tipo': 'VENTA' }")
   Flux<Log> findVentaAlPorMenor();

   // Filtro cuando el descuento sea mayor a 0 y el tipo sea "VENTA"
   @Query("{ 'descuento': { $gt: 0 }, 'tipo': 'VENTA' }")
   Flux<Log> findVentaAlPorMayor();
}
