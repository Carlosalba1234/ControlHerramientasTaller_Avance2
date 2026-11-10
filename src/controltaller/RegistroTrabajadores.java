package controltaller;
import javax.swing.*;
import java.awt.*;
public class RegistroTrabajadores extends JFrame {
    public RegistroTrabajadores(ControlTaller control){
        setTitle("Registro de trabajadores");setSize(440,300);setLocationRelativeTo(null);
        JPanel p=new JPanel(new GridLayout(5,2,10,10));p.setBorder(BorderFactory.createEmptyBorder(20,25,20,25));
        JTextField id=new JTextField(),nombre=new JTextField(),puesto=new JTextField(),telefono=new JTextField();
        p.add(new JLabel("Identificación:"));p.add(id);p.add(new JLabel("Nombre completo:"));p.add(nombre);
        p.add(new JLabel("Puesto:"));p.add(puesto);p.add(new JLabel("Teléfono:"));p.add(telefono);
        JButton guardar=new JButton("Guardar"),buscar=new JButton("Buscar");
        p.add(guardar);p.add(buscar);add(p);
        guardar.addActionListener(e->{
            try{control.agregarTrabajador(new Trabajador(id.getText(),nombre.getText(),puesto.getText(),telefono.getText()));
                JOptionPane.showMessageDialog(this,"Trabajador registrado.");id.setText("");nombre.setText("");puesto.setText("");telefono.setText("");
            }catch(IllegalArgumentException ex){JOptionPane.showMessageDialog(this,ex.getMessage());}
        });
        buscar.addActionListener(e->{
            Trabajador t=control.buscarTrabajador(id.getText());
            JOptionPane.showMessageDialog(this,t==null?"No encontrado.":t.toString()+" | Tel: "+t.getTelefono());
        });
    }
}
