package uncle.pi.developertools.service;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * @Usage:
 * @Author: by Daniel
 * @Date: 2024/4/24 01:48
 */
public interface XmlService {

    String format(String xml) throws ParserConfigurationException, IOException, SAXException, TransformerException;

    String compress(String xml);
}
