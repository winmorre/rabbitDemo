package turntabl.io.RqueuePublisher.publish;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import turntabl.io.RqueuePublisher.model.MenuModel;

public class QueueSender {
    @Autowired
    private  RabbitTemplate rabbitTemplate;
//
//    @Autowired
//    public QueueSender(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }


    @Value("${exchange}")
    private String exchange;

    @Value("${routing.key}")
    private String routingKey;

    public void send(MenuModel menu){
        rabbitTemplate.convertAndSend(exchange, routingKey, menu);
    }
}
