import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Estudiante {

    private String nombre;


    private int edad;

    // Constructor sin argumentos necesario para JAXB // (Sin este constructor JAXB no funcionará)
    public Estudiante() {
    }

    // Constructor con argumentos
    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters y setters

    // Cambiaremos '@XmlElement' de las propiedades privadas y lo escribiremos en los getters
    // ya que entran en conflicto si está del revés y ocurrirá un error
    @XmlElement
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
