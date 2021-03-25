package turntabl.io.RqueueSubscriber.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Component;
import turntabl.io.RqueueSubscriber.model.MenuModel;

import java.util.logging.Logger;

@Component
public class RabbitMqReceiver implements RabbitListenerConfigurer {
     private static  final Logger logger = Logger.getLogger(RabbitMqReceiver.class.getName());


    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {

    }
    @RabbitListener(queues="${menu.rabbitmq.queue}")
    public void receivedMessage(MenuModel menu){
        logger.info("Menu details received is ..... " + menu);
    }
}
