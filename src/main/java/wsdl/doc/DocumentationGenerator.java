package wsdl.doc;

import java.io.File;
import java.net.URL;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DocumentationGenerator {

    public void generate(URL wsdlUrl, File outputFolder) {
        log.info("Parsing '{}' to '{}'", wsdlUrl, outputFolder);
    }

}
