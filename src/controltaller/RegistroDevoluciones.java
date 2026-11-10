package controltaller;
import javax.swing.*;
import java.awt.*;
public class RegistroDevoluciones extends JFrame {
    public RegistroDevoluciones(ControlTaller control){
        setTitle("Registro de devoluciones");setSize(420,190);setLocationRelativeTo(null);
        JPanel p=new JPanel(new GridLayout(2,2,10,10));p.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        JTextField numero=new JTextField();JButton devolver=new JButton("Registrar devolución");
        p.add(new JLabel("Número de préstamo:"));p.add(numero);p.add(new JLabel(""));p.add(devolver);add(p);
        devolver.addActionListener(e->{
            try{control.registrarDevolucion(Integer.parseInt(numero.getText().trim()));
                JOptionPane.showMessageDialog(this,"Devolución registrada. Herramienta disponible.");numero.setText("");
            }catch(NumberFormatException ex){JOptionPane.showMessageDialog(this,"Ingrese un número válido.");}
            catch(IllegalArgumentException|IllegalStateException ex){JOptionPane.showMessageDialog(this,ex.getMessage());}
        });
    }
}
