import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<BD> misAlumnosBD = new ArrayList<>();
        misAlumnosBD.add(new BD("C", 2324, "López García", "Luis","BD-1"));
        misAlumnosBD.add(new BD("C", 2327, "García Pérez", "María","BD-2" ));
        misAlumnosBD.add(new BD("C", 2328, "Pérez Pérez", "José","BD-1"));

        ArrayList<IS> misAlumnosIS = new ArrayList<>();
        misAlumnosIS.add(new IS("C", 2324, "López García", "Luis", "IS-1"));
        misAlumnosIS.add(new IS("C", 2326, "Álvarez Pérez", "Luisa", "IS-3"));
        misAlumnosIS.add(new IS("C", 2328, "Pérez Pérez", "José", "IS-1"));

        ArrayList<Alumno> todosLosAlumnos = new ArrayList<>();
        todosLosAlumnos.addAll(misAlumnosBD);
        todosLosAlumnos.addAll(misAlumnosIS);

        System.out.println("Alumnos: ");
        for (Alumno a : todosLosAlumnos) {
            System.out.println(a);
        }

        // Ordenar la lista de todos los alumnos por código (segundo atributo)
        System.out.println("Alumnos ordenados: ");
        Collections.sort(todosLosAlumnos, new Comparator<Alumno>() {
            @Override
            public int compare(Alumno alumno1, Alumno alumno2) {
                return Integer.compare(alumno1.getNumCod(), alumno2.getNumCod());
            }
        });

        // Imprimir la lista de todos los alumnos ordenados por código
        for (Alumno alumno : todosLosAlumnos) {
            System.out.println(alumno);
        }

        String nombreArchivo1 = "Alumnos_BD.ser";
        String nombreArchivo2 = "Alumnos_IS.ser";
        try{
            ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(nombreArchivo1));
            ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(nombreArchivo2));

            for (Alumno alumnoBD : misAlumnosBD) {
                oos1.writeObject(alumnoBD);
            }
            oos1.close();
            System.out.println("Archivo creado correctamente con el nombre " + nombreArchivo1);

            for (Alumno alumnoIS : misAlumnosIS) {
                oos2.writeObject(alumnoIS);
            }
            oos2.close();

            System.out.println("Archivo creado correctamente con el nombre " + nombreArchivo2);

        } catch (IOException e) {
            System.out.println("No se ha podido crear el archivo.");
            System.out.println(e);
        }

        String nombreArchivo3 = "Resultado.ser";
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo3));
            for (Alumno alumnos : todosLosAlumnos) {
                oos.writeObject(alumnos);
            }
            oos.close();
            System.out.println("Archivo creado correctamente con el nombre " + nombreArchivo3);
        } catch (IOException e) {
            System.out.println("No se ha podido crear el archivo.");
            System.out.println(e);
        }


    }
}