import jakarta.xml.bind.JAXBException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException {
        File archivo = new File("JAXBUtilPruebasEstudiante.txt");
        File archivo2 = new File("JAXBUtilPruebasCurso.txt");

        Estudiante estudiante = new Estudiante("Alejandro",19);
        JAXBUtil.marshal(estudiante,archivo);
        Estudiante estudianteGuardado = JAXBUtil.unmarshal(archivo);
        System.out.println("Nombre estudiante: "+estudianteGuardado.getNombre()+" Edad:"+estudianteGuardado.getEdad());

        List<Estudiante> lista = List.of(
                new Estudiante("Alejandro", 19),
                new Estudiante("Pedro", 30),
                new Estudiante("Juan", 24)
        );
        Curso curso = new Curso("2ºDAM", lista);
        JAXBUtil.marshalCurso(curso,archivo2);
        Curso cursoGuardado = JAXBUtil.unmarshalCurso(archivo2);
        System.out.println("Nombre curso: "+cursoGuardado.getNombreCurso()+" Lista: "+cursoGuardado.getEstudiantes());
    }
}
