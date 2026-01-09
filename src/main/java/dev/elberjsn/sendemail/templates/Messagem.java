package dev.elberjsn.sendemail.templates;

import dev.elberjsn.sendemail.utils.FreemarkerUtils;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.Map;

public class Messagem {

    private String name;
    private String messagem;

    public Messagem(String name, String messagem){
        this.name = name;
        this.messagem = messagem;
    }

    public String generateTemplate() throws TemplateException, IOException {

        Map<String,Object> infos = Map.of("name",this.name,"messagem",this.messagem);
        return FreemarkerUtils.parseTemplate(infos,"mensagem.ftl");
    }
}
