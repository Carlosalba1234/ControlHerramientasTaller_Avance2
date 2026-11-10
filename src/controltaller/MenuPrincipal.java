package controltaller;
import javax.swing.*;
import java.awt.*;
import java.util.List;
public class MenuPrincipal extends JFrame {
    private final ControlTaller control;
    public MenuPrincipal(ControlTaller control){
        this.control=control;
        setTitle("Control de Herramientas - Menú principal");
        setSize(460,500);setLocationRelativeTo(null);setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel=new JPanel(new GridLayout(8,1,8,8));
        panel.setBorder(BorderFactory.createEmptyBorder(20,45,20,45));
        panel.add(new JLabel("MENÚ PRINCIPAL",SwingConstants.CENTER));
        boton(panel,"Registrar trabajadores",()->new RegistroTrabajadores(control).setVisible(true));
        boton(panel,"Registrar herramientas",()->new RegistroHerramientas(control).setVisible(true));
        boton(panel,"Consultar herramientas disponibles",()->mostrar("Herramientas disponibles",control.getDisponibles()));
        boton(panel,"Registrar préstamos",()->new RegistroPrestamos(control).setVisible(true));
        boton(panel,"Registrar devoluciones",()->new RegistroDevoluciones(control).setVisible(true));
        boton(panel,"Consultar préstamos pendientes",()->mostrar("Préstamos pendientes",control.consultarPendientes()));
        boton(panel,"Consultar todos los préstamos",()->mostrar("Todos los préstamos",control.consultarPrestamos()));
        add(panel);
    }
    private void boton(JPanel panel,String texto,Runnable accion){
        JButton b=new JButton(texto);b.addActionListener(e->accion.run());panel.add(b);
    }
    private void mostrar(String titulo,List<?> lista){
        JTextArea area=new JTextArea(16,48);area.setEditable(false);
        if(lista.isEmpty())area.setText("No hay registros.");
        else for(Object item:lista)area.append(item+"\n");
        JOptionPane.showMessageDialog(this,new JScrollPane(area),titulo,JOptionPane.INFORMATION_MESSAGE);
    }
}
