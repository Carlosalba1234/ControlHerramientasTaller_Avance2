package controltaller;
import java.time.LocalDate;
public class Prestamo {
    private final int numero;
    private final Trabajador trabajador;
    private final Herramienta herramienta;
    private final LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    public Prestamo(int numero,Trabajador trabajador,Herramienta herramienta){
        this.numero=numero;this.trabajador=trabajador;this.herramienta=herramienta;
        this.fechaPrestamo=LocalDate.now();herramienta.setDisponible(false);
    }
    public int getNumero(){return numero;}
    public Trabajador getTrabajador(){return trabajador;}
    public Herramienta getHerramienta(){return herramienta;}
    public LocalDate getFechaPrestamo(){return fechaPrestamo;}
    public LocalDate getFechaDevolucion(){return fechaDevolucion;}
    public boolean isPendiente(){return fechaDevolucion==null;}
    public void registrarDevolucion(){
        if(!isPendiente())throw new IllegalStateException("El préstamo ya fue devuelto.");
        fechaDevolucion=LocalDate.now();herramienta.setDisponible(true);
    }
    @Override public String toString(){return "#"+numero+" | "+trabajador.getNombre()+" | "+herramienta.getNombre()+" | "+fechaPrestamo+" | "+(isPendiente()?"Pendiente":"Devuelto "+fechaDevolucion);}
}
