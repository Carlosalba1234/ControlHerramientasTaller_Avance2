package controltaller;
import java.util.ArrayList;
import java.util.List;
public class ControlTaller {
    private final List<Trabajador> trabajadores=new ArrayList<>();
    private final List<Herramienta> herramientas=new ArrayList<>();
    private final List<Prestamo> prestamos=new ArrayList<>();
    private int siguienteNumero=1;
    public void agregarTrabajador(Trabajador t){
        if(buscarTrabajador(t.getIdentificacion())!=null)throw new IllegalArgumentException("Ya existe esa identificación.");
        trabajadores.add(t);
    }
    public void agregarHerramienta(Herramienta h){
        if(buscarHerramienta(h.getCodigo())!=null)throw new IllegalArgumentException("Ya existe ese código.");
        herramientas.add(h);
    }
    public Trabajador buscarTrabajador(String id){
        for(Trabajador t:trabajadores)if(t.getIdentificacion().equalsIgnoreCase(id.trim()))return t;
        return null;
    }
    public Herramienta buscarHerramienta(String codigo){
        for(Herramienta h:herramientas)if(h.getCodigo().equalsIgnoreCase(codigo.trim()))return h;
        return null;
    }
    public Prestamo registrarPrestamo(String id,String codigo){
        Trabajador t=buscarTrabajador(id); Herramienta h=buscarHerramienta(codigo);
        if(t==null)throw new IllegalArgumentException("Trabajador no encontrado.");
        if(h==null)throw new IllegalArgumentException("Herramienta no encontrada.");
        if(!h.isDisponible())throw new IllegalStateException("La herramienta ya está prestada.");
        Prestamo p=new Prestamo(siguienteNumero++,t,h);prestamos.add(p);return p;
    }
    public void registrarDevolucion(int numero){
        for(Prestamo p:prestamos)if(p.getNumero()==numero){p.registrarDevolucion();return;}
        throw new IllegalArgumentException("No existe ese número de préstamo.");
    }
    public List<Trabajador> getTrabajadores(){return new ArrayList<>(trabajadores);}
    public List<Herramienta> getHerramientas(){return new ArrayList<>(herramientas);}
    public List<Herramienta> getDisponibles(){
        List<Herramienta> lista=new ArrayList<>();
        for(Herramienta h:herramientas)if(h.isDisponible())lista.add(h);
        return lista;
    }
    public List<Prestamo> consultarPrestamos(){return new ArrayList<>(prestamos);}
    public List<Prestamo> consultarPendientes(){
        List<Prestamo> lista=new ArrayList<>();
        for(Prestamo p:prestamos)if(p.isPendiente())lista.add(p);
        return lista;
    }
}
