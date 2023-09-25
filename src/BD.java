import java.io.Serializable;

class BD extends Alumno implements Serializable {
    private String clase;
    public BD(String letraCod, int numCod, String apellidos, String nombre, String clase) {
        super(letraCod, numCod, apellidos, nombre);
        this.clase = clase;
    }

    @Override
    public String toString() {
        return super.toString() +
                "clase='" + clase + '\'' +
                '}';
    }
}