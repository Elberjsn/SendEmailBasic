package dev.elberjsn.sendemail.utils;

import com.google.gson.Gson;
import dev.elberjsn.sendemail.core.Email;
import dev.elberjsn.sendemail.services.EmailServices;
import dev.elberjsn.sendemail.templates.Alerta;
import dev.elberjsn.sendemail.templates.BemVindo;
import dev.elberjsn.sendemail.templates.Messagem;
import dev.elberjsn.sendemail.templates.NovaSenha;
import freemarker.template.TemplateException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Instant;
import java.util.Objects;

@Component
public class GetQueue {

    EmailServices services;
    public GetQueue(EmailServices services) {
        this.services = services;
    }

    @RabbitListener(queues = {"email.bemvindo.queue","email.novaSenha.queue","email.alerta.queue","email.mensagem.queue"})
    public void receiveMessage(String data, @Header(AmqpHeaders.CONSUMER_QUEUE) String filaOrigem) throws TemplateException, IOException {
        System.out.println("Recebido da fila " + filaOrigem + ": " + data);
        String[] fila= filaOrigem.split("\\.");

        if (Objects.equals(fila[0], "email")){

            Email email = new Gson().fromJson(data, Email.class);

            switch (fila[1]){
                case "bemvindo":
                    services.sendEmail(email, new BemVindo(email.nameTo(),email.toMail(),email.link()).generateTemplate(), "Bem Vindo ao nosso sistema!");
                    break;
                case "novaSenha":
                    services.sendEmail(email, new NovaSenha("2", email.link(), email.nameTo()).generateTemplate(), "Resete sua senha!");
                    break;
                case "alerta":
                    services.sendEmail(email, new Alerta(email.subBody(), email.time() ,email.local()).generateTemplate(), "");
                    break;
                default:
                    services.sendEmail(email,new Messagem(email.nameTo(),email.subBody()).generateTemplate(), "");
                    break;
            }

        }


    }
}
