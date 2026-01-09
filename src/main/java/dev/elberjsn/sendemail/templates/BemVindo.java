package dev.elberjsn.sendemail.templates;

import dev.elberjsn.sendemail.utils.FreemarkerUtils;
import freemarker.template.TemplateException;
import lombok.Data;

import java.io.IOException;
import java.util.Map;

public class BemVindo {

    private String name;
    private String email;
    private String activationLink;

    public BemVindo(String name, String email, String activationLink){
        this.name = name;
        this.email = email;
        this.activationLink = activationLink;
    }

    public String generateTemplate() throws TemplateException, IOException {

        Map<String,Object> infos = Map.of("name",this.name,"email",this.email,"activationLink",this.activationLink);
        return FreemarkerUtils.parseTemplate(infos,"bemVindo.ftl");

    }

}
