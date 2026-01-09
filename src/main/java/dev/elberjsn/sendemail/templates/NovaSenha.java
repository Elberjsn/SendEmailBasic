package dev.elberjsn.sendemail.templates;

import dev.elberjsn.sendemail.utils.FreemarkerUtils;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.Map;

public class NovaSenha {

    private String expiryLink;
    private String resetLink;
    private String name;

    public NovaSenha(String expiryLink,String resetLink,String name) {
        this.expiryLink = expiryLink;
        this.resetLink = resetLink;
        this.name = name;
    }

    public String generateTemplate() throws TemplateException, IOException {

        Map<String,Object> infos = Map.of("name",this.name,"expiryLink",this.expiryLink,"resetLink",resetLink);
        return FreemarkerUtils.parseTemplate(infos,"novaSenha.ftl");
    }
}
