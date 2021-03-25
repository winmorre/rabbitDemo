package turntabl.io.RqueuePublisher.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import turntabl.io.RqueuePublisher.model.MenuModel;
import turntabl.io.RqueuePublisher.publish.QueueSender;

@RestController
@RequestMapping("menu")
public class PublisherController {

    @Autowired
    private  QueueSender queueSender;

//    @Autowired
//    public PublisherController(QueueSender queueSender) {
//        this.queueSender = queueSender;
//    }

    @Value("${message}")
    private String message;

    @PostMapping
    public String publishMenuDetails(@RequestBody MenuModel menu){
        queueSender.send(menu);
        return message;
    }

}
