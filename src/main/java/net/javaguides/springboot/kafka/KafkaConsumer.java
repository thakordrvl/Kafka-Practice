package net.javaguides.springboot.kafka;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Value("${kafka.topic.javaguides}")
    private String kafkaTopic;
    @KafkaListener(topics = "#{@kafkaTopic}", groupId = "myGroup")
    public void consume(String message){
        LOGGER.info(String.format("Message Recieved -> %s",message));
    }
}
