package controltaller;
public class Trabajador extends Persona {
    private final String puesto, telefono;
    public Trabajador(String id,String nombre,String puesto,String telefono){
        super(id,nombre); this.puesto=puesto; this.telefono=telefono;
    }
    public String getPuesto(){return puesto;}
    public String getTelefono(){return telefono;}
    @Override public String getDescripcion(){return getNombre()+" - "+puesto;}
    @Override public String toString(){return getIdentificacion()+" | "+getDescripcion();}
}
