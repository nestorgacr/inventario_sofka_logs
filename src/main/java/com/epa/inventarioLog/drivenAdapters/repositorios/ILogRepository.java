package com.epa.inventarioLog.drivenAdapters.repositorios;

import com.epa.inventarioLog.models.mongo.Log;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILogRepository extends ReactiveMongoRepository<Log, String> {
}
