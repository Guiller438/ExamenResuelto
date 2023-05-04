import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame{
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField txtid;
    private JTextField txtnombre1;
    private JTextField txtedad;
    private JTextField txtprioridad;
    private JTextField txtamigos;
    private JButton agregarPersonaButton;
    private JTextArea areapredefinidos;
    private JButton btnpredefinidos;
    private JPanel mainPanel;
    private JScrollPane Scrollbar;
    private JTextField txtidbuscar;
    private JButton buscarporid;
    private JButton buscarMayoresA50Button;
    private JComboBox cboActivoEspera;
    private JTextArea areabuscar;
    private JButton activarPrimerUsuarioButton;
    private JButton activarTodosLosUsuariosButton;
    private JTextArea areaActivos;
    private JTabbedPane tabbedPane2;
    private JButton eliminarElPrimerUsuarioButton;
    private JButton eliminarTodosLosUsuariosButton;
    private JTextArea eliminadosArea;
    private JButton restablecerPrimerUsuarioButton;
    private JButton restablecerTodosLosUsuariosButton;
    private JTextArea areaReestablecidos;
    private JTextArea Activos;

    RedSocial redSocial = new RedSocial();

    public Ventana() {
        agregarPersonaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Persona p = new Persona(Integer.parseInt(txtid.getText()),
                                        Integer.parseInt(txtedad.getText()),
                                        Integer.parseInt(txtprioridad.getText()),
                                        Integer.parseInt(txtamigos.getText()),
                                        txtnombre1.getText());
                redSocial.AgregarPersona(p);
                areapredefinidos.setText(redSocial.toStringEspera());
            }
        });
        btnpredefinidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redSocial.DatosPredefinidos();
                areapredefinidos.setText("Los datos quemados son: " + redSocial.toStringEspera());
                //System.out.println("redSocial = " + redSocial.toString());
            }
        });

        buscarporid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Persona personaEncontradaEspera = redSocial.BuscarIDEspera(Integer.parseInt(txtidbuscar.getText()));
                Persona personaEncontradaActivos = redSocial.BuscarIDActivos(Integer.parseInt(txtidbuscar.getText()));
                System.out.println(""+cboActivoEspera.getSelectedIndex());
                if(cboActivoEspera.getSelectedIndex() == 1){
                    if(personaEncontradaEspera != null){
                        areabuscar.setText(personaEncontradaEspera.toString());
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontro el ID en la lista de espera");
                    }
                }else{
                    if(personaEncontradaActivos != null){
                        areabuscar.setText(personaEncontradaActivos.toString());
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontro el ID en la lista de activos");
                    }
                }

            }
        });
        buscarMayoresA50Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cboActivoEspera.getSelectedIndex() == 1){
                        if(!redSocial.buscarPrioridadEspera().isEmpty()) {
                            areabuscar.setText(redSocial.buscarPrioridadEspera().toString());
                         }else{
                            JOptionPane.showMessageDialog(null, "No se encontro el ID en la lista de espera");
                         }
                    }else{
                        if( redSocial.buscarPrioridadAcitvos() != null){
                            areabuscar.setText(redSocial.buscarPrioridadAcitvos().toString());
                        }else{
                            JOptionPane.showMessageDialog(null, "No se encontro el ID en la lista de activos");
                    }
                    }
            }
        });
        activarPrimerUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redSocial.ActivarUsuario();
                areaActivos.setText(redSocial.toStringActivos());
                Activos.setText(redSocial.toStringActivos());
            }
        });
        activarTodosLosUsuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redSocial.ActivarTodos();
                areaActivos.setText(redSocial.toStringActivos());
                Activos.setText(redSocial.toStringActivos());
            }
        });
        eliminarElPrimerUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!redSocial.PersonasActivas.isEmpty()){
                    redSocial.EliminarUsuario();
                    eliminadosArea.setText(redSocial.toStringEliminados());
                    JOptionPane.showMessageDialog(null, "Se elimino el primer usuario");
                    Activos.setText(redSocial.toStringActivos());
                }else {
                    JOptionPane.showMessageDialog(null, "No hay usuarios activos");
                }

            }
        });
        eliminarTodosLosUsuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!redSocial.PersonasActivas.isEmpty()){
                    redSocial.EliminarUsuarios();
                    eliminadosArea.setText(redSocial.toStringEliminados());
                    JOptionPane.showMessageDialog(null, "Se eliminaron todos los usuarios");
                    Activos.setText(redSocial.toStringActivos());
                }else {
                    JOptionPane.showMessageDialog(null, "No hay usuarios activos");
                }

            }
        });
        restablecerPrimerUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!redSocial.Eliminados.isEmpty()){
                   redSocial.RestablecerPersona();
                   areaReestablecidos.setText(redSocial.toStringEliminados());
                   Activos.setText(redSocial.toStringActivos());
                }else {
                    JOptionPane.showMessageDialog(null, "No hay usuarios por reestablecer");
                }
            }
        });
        restablecerTodosLosUsuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!redSocial.Eliminados.isEmpty()){
                    redSocial.RestablecerPersonas();
                    areaReestablecidos.setText(redSocial.toStringEliminados());
                    Activos.setText(redSocial.toStringActivos());
                }else {
                    JOptionPane.showMessageDialog(null, "No hay usuarios por reestablecer");
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}
