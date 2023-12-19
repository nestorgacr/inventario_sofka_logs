package com.epa.inventarioLog.drivenAdapters.repositorios;

import com.epa.inventarioLog.models.mongo.Error;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IErrorRepository extends ReactiveMongoRepository<Error, String> {
}
