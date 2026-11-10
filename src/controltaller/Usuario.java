package controltaller;
public class Usuario extends Persona {
    private final String clave;
    public Usuario(String usuario,String nombre,String clave){
        super(usuario,nombre); this.clave=clave;
    }
    public boolean iniciarSesion(String usuario,String clave){
        return getIdentificacion().equals(usuario) && this.clave.equals(clave);
    }
    @Override public String getDescripcion(){return "Encargado: "+getNombre();}
}
