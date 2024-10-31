import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

// La anotación @XmlType con el atributo propOrder especifica el orden de los elementos
// en el XML. Esto asegura que nombreCurso aparezca antes de estudiantes en el archivo XML.
@XmlRootElement
@XmlType(propOrder = {"nombreCurso", "estudiantes"})
public class Curso {
    private String nombreCurso;
    private List<Estudiante> estudiantes;

    // Constructor sin argumentos necesario para JAXB
    public Curso(){
    }
    // Constructor con argumentos
    public Curso(String nombreCurso, List<Estudiante> listaEstudiantes){
        this.nombreCurso=nombreCurso;
        this.estudiantes=listaEstudiantes;
    }

    // Getters y setters

    @XmlElement
    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombre(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    // name = "estudiante" se usa para que cada elemento dentro de la lista se represente
    // como <estudiante> en el XML.
    @XmlElement(name = "estudiante")
    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
