package controltaller;
public class Herramienta {
    private final String codigo,nombre,categoria;
    private boolean disponible=true;
    public Herramienta(String codigo,String nombre,String categoria){
        if(codigo==null||codigo.isBlank()||nombre==null||nombre.isBlank()||categoria==null||categoria.isBlank())
            throw new IllegalArgumentException("Complete código, nombre y categoría.");
        this.codigo=codigo.trim();this.nombre=nombre.trim();this.categoria=categoria.trim();
    }
    public String getCodigo(){return codigo;}
    public String getNombre(){return nombre;}
    public String getCategoria(){return categoria;}
    public boolean isDisponible(){return disponible;}
    public void setDisponible(boolean valor){disponible=valor;}
    @Override public String toString(){return codigo+" | "+nombre+" | "+categoria+" | "+(disponible?"Disponible":"Prestada");}
}
