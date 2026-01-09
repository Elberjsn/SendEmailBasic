package dev.elberjsn.sendemail.utils;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class FreemarkerUtils {

    private static final Configuration conf = new Configuration(Configuration.VERSION_2_3_31);
    private static final String TEMPLATE_PATH = "src/main/resources/templates";

    public static String parseTemplate(Map infos , String templateName) throws IOException, TemplateException {
        conf.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
        conf.setDefaultEncoding("UTF-8");
        conf.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_31));

        Template tmp = conf.getTemplate(templateName);
        StringWriter writer = new StringWriter();
        tmp.process(infos ,writer);
        writer.flush();
        writer.close();
        return writer.toString();


    }

}
