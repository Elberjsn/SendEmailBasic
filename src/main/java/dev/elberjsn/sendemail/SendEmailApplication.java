package dev.elberjsn.sendemail;

import dev.elberjsn.sendemail.core.Email;
import dev.elberjsn.sendemail.services.EmailServices;
import dev.elberjsn.sendemail.templates.BemVindo;
import freemarker.template.TemplateException;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@EnableRabbit
@SpringBootApplication
public class SendEmailApplication {

    public static void main(String[] args) throws TemplateException, IOException {
        SpringApplication.run(SendEmailApplication.class, args);


    }
}
