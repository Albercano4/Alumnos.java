import java.io.Serializable;

public class Alumno implements Serializable {

    private String letraCod;
    private int numCod;
    private String apellidos;
    private String nombre;


    public Alumno(String letraCod, int numCod, String apellidos, String nombre) {
        this.letraCod = letraCod;
        this.numCod = numCod;
        this.apellidos = apellidos;
        this.nombre = nombre;

    }

    @Override
    public String toString() {
        return "Alumno{" +
                "Código='" + letraCod + numCod +
                ", apellidos='" + apellidos + '\'' +
                ", nombre='" + nombre + '\'' +
                ' ';
    }

    public int getNumCod() {
        return numCod;
    }
}
