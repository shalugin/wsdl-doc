package wsdl.doc;

import java.io.File;
import java.io.IOException;

import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;

public class DocumentationGeneratorTest {

    @Test
    public void generate() throws IOException, TemplateException {
        DocumentationGenerator documentationGenerator = new DocumentationGenerator();
        String wsdlUrl = "http://www.thomas-bayer.com/axis2/services/BLZService?wsdl";
        File file = new File(getClass().getResource("/").getFile());
        documentationGenerator.generate(wsdlUrl, new File(file.getParent()));
    }
}
