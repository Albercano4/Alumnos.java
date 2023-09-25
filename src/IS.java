import java.io.Serializable;

class IS extends Alumno implements Serializable {
    private String clase;
    public IS(String letraCod, int numCod, String apellidos, String nombre, String clase) {
        super(letraCod, numCod, apellidos, nombre);
        this.clase = clase;
    }

    @Override
    public String toString() {
        return super.toString()  +
                " clase='" + clase + '\'' +
                '}';
    }
}