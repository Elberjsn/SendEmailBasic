package dev.elberjsn.sendemail.services;

import dev.elberjsn.sendemail.core.Email;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.naming.Context;
import java.io.UnsupportedEncodingException;

@Service
public class EmailServices {

    private static final String EMAIL_TEMPLATE = "email.html";
    private static final String ATTACHMENT_PATH = "template/image/base.png";
    private static final String PNG_IMG = "img.png";

    private final JavaMailSender javaMailSender;

    public EmailServices(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(Email email, String template,String subject){

        try{
            final MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
            final MimeMessageHelper emailSend;
            emailSend = new MimeMessageHelper(mimeMessage,true,"UTF-8");

            emailSend.setTo(email.toMail());
            if (subject.isEmpty()){
                emailSend.setSubject(email.subject());
            }else {
                emailSend.setSubject(subject);
            }

            emailSend.setFrom(new InternetAddress(email.fromMail(),email.nameTo()));

            emailSend.setText(template,true);

            javaMailSender.send(mimeMessage);

        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Email enviado com sucesso!");
    }

}
