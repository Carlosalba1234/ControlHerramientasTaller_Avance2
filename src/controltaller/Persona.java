package controltaller;
public abstract class Persona {
    private final String identificacion, nombre;
    public Persona(String identificacion, String nombre) {
        if (identificacion == null || identificacion.isBlank() || nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("Identificación y nombre son obligatorios.");
        this.identificacion=identificacion.trim(); this.nombre=nombre.trim();
    }
    public String getIdentificacion(){return identificacion;}
    public String getNombre(){return nombre;}
    public abstract String getDescripcion();
}
