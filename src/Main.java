import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               Ventana MainForm = new Ventana();
                MainForm.setContentPane(MainForm.getMainPanel());
                MainForm.setBounds(100,100,500,500);
                MainForm.setVisible(true);
                MainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }
        });
    }
}