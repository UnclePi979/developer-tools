package uncle.pi.developertools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.InputSource;
import uncle.pi.developertools.service.XmlService;

import java.io.StringReader;

@RestController
@RequestMapping("/api/xml")
public class XMLFormatController {

    @Autowired
    private XmlService xmlService;

    @PostMapping("/format")
    public ResponseEntity<String> formatXML(@RequestBody String xml) {
        try {
            String formattedXml = xmlService.format(xml);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_XML).body(formattedXml);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Invalid XML");
        }
    }

    @PostMapping("/compress")
    public ResponseEntity<String> compressXml(@RequestBody String xml) {
        try {
            String compressedXml = xmlService.compress(xml);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_XML).body(compressedXml);
        } catch (Exception e) {
            // bad request for invalid XML input
            return ResponseEntity.badRequest().body("Invalid XML input");
        }
    }

}