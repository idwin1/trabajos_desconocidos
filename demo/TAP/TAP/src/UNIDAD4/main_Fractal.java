package UNIDAD4;
import javax.swing.JFrame;
import javax.swing.UIManager;
public class main_Fractal {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e) {}
        fracta.Fractal fractal = new fracta.Fractal();
        fractal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
