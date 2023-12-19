package com.epa.inventarioLog.handlers.bus;


import com.epa.inventarioLog.config.RabbitConfig;
import com.epa.inventarioLog.models.dto.ErrorDto;
import com.epa.inventarioLog.models.dto.LogDto;
import com.epa.inventarioLog.usecase.RegistrarErrorUseCase;
import com.epa.inventarioLog.usecase.RegistrarTransaccionUseCase;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.rabbitmq.Receiver;


@Component
public class RabbitMqMessageConsumer implements CommandLineRunner {

    @Autowired
    private Receiver receiver;

    @Autowired
    private Gson gson;

    private RegistrarTransaccionUseCase registrarTransaccionUseCase;

    private RegistrarErrorUseCase registrarErrorUseCase;

    public RabbitMqMessageConsumer(RabbitConfig eventBus, RegistrarTransaccionUseCase registrarTransaccionUseCase, RegistrarErrorUseCase registrarErrorUseCase) {

        this.registrarTransaccionUseCase = registrarTransaccionUseCase;
        this.registrarErrorUseCase = registrarErrorUseCase;
    }


    @Override
    public void run(String... args) throws Exception {


        receiver.consumeAutoAck(RabbitConfig.QUEUE_TRANSACCION_NAME)
                .map(message -> {

                   LogDto log = gson.fromJson(new String(message.getBody()), LogDto.class);

                    return registrarTransaccionUseCase.apply(log).subscribe();
                }).subscribe();

        receiver.consumeAutoAck(RabbitConfig.QUEUE_ERROR_NAME)
                .map(message -> {

                    ErrorDto error = gson.fromJson(new String(message.getBody()), ErrorDto.class);

                    return registrarErrorUseCase.apply(error).subscribe();
                }).subscribe();
   }
}
