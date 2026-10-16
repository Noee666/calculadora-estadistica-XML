import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
/**
 * Proporciona herramientas para leer un archivo xml.
 *
 * @author Martin Noe
 * @version 1.0.0
 * @since 15-10-2026
 */
public class LectorXML {
    /**
     * Extrae los elementos contenidos en una etiqueta.
     *
     * @param ruta ubicación del archivo xml
     * @param xmlTagName nombre de la etiqueta con los valores deseados
     * @return lista de valores numéricos decimales extraídos del xml
     * @throws Exception si la extracción no se pudo completar correctamente
     */
    public static List<Double> extraerElemento(Path ruta, String xmlTagName) throws Exception {

        List<Double> elementos;

        if (!(Files.exists(ruta) && Files.isReadable(ruta))) {
            throw new Exception("No se puede abrir el documento XML o no existe: " + ruta);
        } else if (!Files.isRegularFile(ruta)) {
            throw new Exception(ruta + " No es un archivo XML");
        }


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse (ruta.toFile());
        doc.getDocumentElement().normalize();

        NodeList nodos = doc.getElementsByTagName(xmlTagName);
        if (nodos.getLength() == 0) {
            throw new Exception(String.format("La variable '%s' no coincide con ninguna etiqueta del archivo.xml ", xmlTagName));
        }
        

        elementos = new ArrayList<>();

        for (int i = 0; i < nodos.getLength(); i++) {
            String elemento = nodos.item(i).getTextContent().trim();
            try {
                elementos.add(Double.parseDouble(elemento));
            } catch (NumberFormatException e) {
                throw new Exception(String.format("El valor [%s] en la etiqueta [%s] no es numérico", elemento, xmlTagName));
            }
        }
        return elementos;
    }
}
