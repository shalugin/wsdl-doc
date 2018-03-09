package wsdl.doc;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.Test;

public class DocumentationGeneratorTest {

    @Test
    public void generate() throws MalformedURLException {
        DocumentationGenerator documentationGenerator = new DocumentationGenerator();
        URL wsdlUrl = new URL("https://graphical.weather.gov/xml/SOAP_server/ndfdXMLserver.php?wsdl");
        File file = new File(getClass().getResource("/").getFile());
        documentationGenerator.generate(wsdlUrl, new File(file.getParent()));
    }
}
