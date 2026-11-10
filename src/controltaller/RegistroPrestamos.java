package controltaller;
import javax.swing.*;
import java.awt.*;
public class RegistroPrestamos extends JFrame {
    public RegistroPrestamos(ControlTaller control){
        setTitle("Registro de préstamos");setSize(470,250);setLocationRelativeTo(null);
        JPanel p=new JPanel(new GridLayout(3,2,10,10));p.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        JTextField id=new JTextField(),codigo=new JTextField();
        p.add(new JLabel("Identificación del trabajador:"));p.add(id);
        p.add(new JLabel("Código de herramienta:"));p.add(codigo);
        JButton registrar=new JButton("Registrar préstamo");p.add(new JLabel(""));p.add(registrar);add(p);
        registrar.addActionListener(e->{
            try{Prestamo prestamo=control.registrarPrestamo(id.getText(),codigo.getText());
                JOptionPane.showMessageDialog(this,"Préstamo registrado: "+prestamo+"\nNúmero: "+prestamo.getNumero());
                id.setText("");codigo.setText("");
            }catch(IllegalArgumentException|IllegalStateException ex){JOptionPane.showMessageDialog(this,ex.getMessage());}
        });
    }
}
