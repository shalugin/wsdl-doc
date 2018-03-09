package wsdl.doc;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import com.predic8.wsdl.Definitions;
import com.predic8.wsdl.WSDLParser;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DocumentationGenerator {

    public void generate(String wsdlUrl, File outputFolder) throws IOException, TemplateException {
        log.info("Parsing '{}' to '{}'", wsdlUrl, outputFolder);

        Configuration configuration = initFreeMarker();

        Files.createDirectories(outputFolder.toPath());
        try (OutputStream fileOutputStream = new FileOutputStream("docs/main.adoc");
             OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
             Writer writer = new OutputStreamWriter(bufferedOutputStream)) {

            Map<String, Object> context = new HashMap<>();
            context.put("serviceName", "AccountService");
            context.put("serviceVersion", "1.2.1");
            context.put("generatedTime", Instant.now());

            WSDLParser parser = new WSDLParser();
            Definitions defs = parser.parse(wsdlUrl);
            context.put("defs", defs);

            Template template = configuration.getTemplate("service.ftlh");
            template.process(context, writer);
        }
    }

    private Configuration initFreeMarker() throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
        String templatePath = getClass().getResource("/templates").getFile();
        cfg.setDirectoryForTemplateLoading(new File(templatePath));
        cfg.setDefaultEncoding(StandardCharsets.UTF_8.name());
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        return cfg;
    }

}
