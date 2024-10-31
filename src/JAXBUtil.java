import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class JAXBUtil {
    // Crea un archivo XML con las propiedades privadas de un solo estudiante y lo escribe
    // en el archivo pasado como parámetro
    public static void marshal(Estudiante estudiante, File file) throws JAXBException {
        // Inicializar contexto JAXB para la clase Estudiante.
        JAXBContext context = JAXBContext.newInstance(Estudiante.class);
        // Crear un marshaller (Marshaller):
        // El marshaller es el objeto que realizará la conversión del objeto Java en el archivo XML.
        Marshaller marshaller = context.createMarshaller();
        // Configurar el marshaller para un formato de salida más legible:
        // Esta configuración opcional permite que el XML resultante esté formateado
        // con saltos de línea e indentación para que sea más legible. Sin esta propiedad,
        // el XML se generaría en una sola línea.
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // Convertir el objeto en XML y escribirlo en el archivo:
        marshaller.marshal(estudiante, file);
    }

    // Devuelve un objeto de la clase Estudiante construido a partir de las
    // propiedades guardadas en el archivo pasado como parámetro en formato XML
    public static Estudiante unmarshal(File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Estudiante.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Estudiante) unmarshaller.unmarshal(file);
    }


    public static void marshalCurso(Curso curso, File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Curso.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(curso, file);
    }

    public static Curso unmarshalCurso(File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Curso.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Curso) unmarshaller.unmarshal(file);
    }
}