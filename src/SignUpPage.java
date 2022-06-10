import javax.swing.*;
import java.awt.*;

public class SignUpPage extends JFrame{
    void SignUpPage(){
        setVisible(true);
        setLayout(new BorderLayout());
        setSize(500, 350);
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        add(jp1, BorderLayout.CENTER);
        add(jp2, BorderLayout.SOUTH);
        jp1.setLayout(new GridLayout(6,3));
        jp2.setLayout(new GridLayout(1,2));
    }
    void SignUpName(){

    }

    public static void main(String[] args) {
        SignUpPage sup = new SignUpPage();
    }
}
