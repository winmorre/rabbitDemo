package turntabl.io.FinalPublisher.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import turntabl.io.FinalPublisher.model.MenuModel;
import turntabl.io.FinalPublisher.publish.MenuRabbitMqSender;

@RestController
@RequestMapping(value="menu")
public class MenuController {
    @Autowired
    MenuRabbitMqSender menuRabbitMqSender;

    @PostMapping
    public String menu(@RequestBody MenuModel menu){
        menuRabbitMqSender.send(menu);

        return "Message sent successfully to rabbit mq queue";
    }

}
