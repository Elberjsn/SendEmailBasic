package dev.elberjsn.sendemail.templates;

import dev.elberjsn.sendemail.utils.FreemarkerUtils;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.time.Instant;
import java.util.Map;

public class Alerta {

    private String eventDescription;
    private String timestamp;
    private String location;

    public Alerta(String eventDescription, String timestamp,String location) {
        this.eventDescription = eventDescription;
        this.timestamp = Instant.now().toString();
        this.location = location;
    }

    public String generateTemplate() throws TemplateException, IOException {

        Map<String,Object> infos = Map.of("eventDescription",this.eventDescription,"timestamp",this.timestamp,"location",this.location);
        return FreemarkerUtils.parseTemplate(infos,"alerta.ftl");
    }
}
