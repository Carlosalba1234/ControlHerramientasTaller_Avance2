package controltaller;
import javax.swing.*;
import java.awt.*;
public class RegistroHerramientas extends JFrame {
    public RegistroHerramientas(ControlTaller control){
        setTitle("Registro de herramientas");setSize(440,280);setLocationRelativeTo(null);
        JPanel p=new JPanel(new GridLayout(4,2,10,10));p.setBorder(BorderFactory.createEmptyBorder(20,25,20,25));
        JTextField codigo=new JTextField(),nombre=new JTextField(),categoria=new JTextField();
        p.add(new JLabel("Código:"));p.add(codigo);p.add(new JLabel("Nombre:"));p.add(nombre);
        p.add(new JLabel("Categoría:"));p.add(categoria);
        JButton guardar=new JButton("Guardar"),buscar=new JButton("Buscar");p.add(guardar);p.add(buscar);add(p);
        guardar.addActionListener(e->{
            try{control.agregarHerramienta(new Herramienta(codigo.getText(),nombre.getText(),categoria.getText()));
                JOptionPane.showMessageDialog(this,"Herramienta registrada.");codigo.setText("");nombre.setText("");categoria.setText("");
            }catch(IllegalArgumentException ex){JOptionPane.showMessageDialog(this,ex.getMessage());}
        });
        buscar.addActionListener(e->{
            Herramienta h=control.buscarHerramienta(codigo.getText());
            JOptionPane.showMessageDialog(this,h==null?"No encontrada.":h.toString());
        });
    }
}
