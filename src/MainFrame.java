import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private JTextField tfNome;
    private JPanel jname;
    private JLabel tlNome;
    private JLabel jlSobrenome;
    private JTextField tfSobrenome;
    private JButton eviarButton;
    private JButton limparButton;
    private JComboBox comboBox1;

    public MainFrame() {

        setContentPane(jname);
        setTitle("Bem-vindo");
        setSize(300, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();




    }

}
