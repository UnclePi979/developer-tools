package uncle.pi.developertools.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uncle.pi.developertools.service.XmlService;

@RestController
@RequestMapping("/api/xml")
@RequiredArgsConstructor
public class XMLFormatController {
    private final XmlService xmlService;

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