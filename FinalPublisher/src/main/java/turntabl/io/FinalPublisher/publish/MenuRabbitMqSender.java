package turntabl.io.FinalPublisher.publish;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import turntabl.io.FinalPublisher.model.MenuModel;

@Service
public class MenuRabbitMqSender {
    @Autowired
    private AmqpTemplate template;
    @Value("${menu.rabbitmq.exchange}")
    private String exchange;
    @Value("${menu.rabbitmq.key}")
    private String routingkey;

    public void send(MenuModel menu){
        template.convertAndSend(exchange, routingkey,menu);
        System.out.println("Send message =  " + menu);
    }
}
