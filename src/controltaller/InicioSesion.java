package controltaller;
import javax.swing.*;
import java.awt.*;
public class InicioSesion extends JFrame {
    private final ControlTaller control;
    private final Usuario encargado=new Usuario("admin","Administrador","1234");
    public InicioSesion(ControlTaller control){
        this.control=control;
        setTitle("Control de Herramientas - Inicio de sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,280);setLocationRelativeTo(null);
        JPanel panel=new JPanel(new GridLayout(4,2,12,12));
        panel.setBorder(BorderFactory.createEmptyBorder(30,35,30,35));
        JTextField usuario=new JTextField();
        JPasswordField clave=new JPasswordField();
        JButton entrar=new JButton("Ingresar");
        panel.add(new JLabel("INICIO DE SESIÓN"));panel.add(new JLabel(""));
        panel.add(new JLabel("Usuario:"));panel.add(usuario);
        panel.add(new JLabel("Contraseña:"));panel.add(clave);
        panel.add(new JLabel(""));panel.add(entrar);
        add(panel);
        entrar.addActionListener(e->{
            if(encargado.iniciarSesion(usuario.getText().trim(),new String(clave.getPassword()))){
                new MenuPrincipal(control).setVisible(true);dispose();
            }else JOptionPane.showMessageDialog(this,"Usuario o contraseña incorrectos.","Acceso",JOptionPane.WARNING_MESSAGE);
        });
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(()->new InicioSesion(new ControlTaller()).setVisible(true));
    }
}
