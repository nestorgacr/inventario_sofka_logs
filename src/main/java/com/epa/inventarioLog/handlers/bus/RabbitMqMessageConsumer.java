package com.epa.inventarioLog.handlers.bus;


import com.epa.inventarioLog.config.RabbitConfig;
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

    private final RabbitConfig eventBus;

    public RabbitMqMessageConsumer(RabbitConfig eventBus) {

        this.eventBus = eventBus;
    }


    @Override
    public void run(String... args) throws Exception {


        receiver.consumeAutoAck(RabbitConfig.QUEUE_TRANSACCION_NAME)
                .map(message -> {

                   // ErrorTransaccion transaction = gson.fromJson(new String(message.getBody()), ErrorTransaccion.class);



                    return null;
                }).subscribe();
   }
}
