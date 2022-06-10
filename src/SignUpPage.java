import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SignUpPage extends JFrame implements ActionListener {
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JPanel jp3 = new JPanel();
    JPanel jp4 = new JPanel();
    JTextField SignUpName = new JTextField();
    JLabel SignUpNameL = new JLabel();
    JTextField SignUpID = new JTextField();
    JButton CheckButton = new JButton();
    JTextField SignUpPW = new JTextField();
    JLabel SignUpPWL = new JLabel();
    JTextField SignUpPWC = new JTextField();
    JLabel SignUpPWCL = new JLabel();
    JButton SignUpButton = new JButton("가입하기");
    JButton SignUpBack = new JButton("취소");
    JComboBox SignUpBirth1 = new JComboBox();
    JComboBox SignUpBirth2 = new JComboBox();
    JComboBox SignUpBirth3 = new JComboBox();
    JComboBox SignUpPNF = new JComboBox();
    JTextField SignUpPN1 = new JTextField();
    public SignUpPage(){
        super("회원가입");
        setVisible(true);
        setSize(1000, 800);
        setLayout(new BorderLayout());
        jp1.setLayout(new GridLayout(6, 3));
        jp2.setLayout(new GridLayout(1, 2));
        jp3.setLayout(new FlowLayout());
        jp4.setLayout(new FlowLayout());

        add(jp1, BorderLayout.CENTER);
        add(jp2, BorderLayout.SOUTH);

        jp1.add(new JLabel("이름"));
        jp1.add(SignUpName);
        jp1.add(SignUpNameL);

        jp1.add(new JLabel("ID"));
        jp1.add(SignUpID);
        jp1.add(CheckButton);

        jp1.add(new JLabel("PW"));
        jp1.add(SignUpPW);
        jp1.add(SignUpPWL);

        jp1.add(new JLabel("PW 확인"));
        jp1.add(SignUpPWC);
        jp1.add(SignUpPWCL);

        jp1.add(new JLabel("생년월일"));
        jp1.add(jp3);
        jp1.add(new JLabel(" "));

        jp1.add(new JLabel("번호"));
        jp1.add(jp4);
        jp1.add(new JLabel(" "));

        jp3.setLayout(new FlowLayout());
        jp3.add(SignUpBirth1);
        jp3.add(new JLabel(" / "));
        jp3.add(SignUpBirth2);
        jp3.add(new JLabel(" / "));
        jp3.add(SignUpBirth3);

        jp4.setLayout(new FlowLayout());
        jp4.add(SignUpPNF);
        jp4.add(new JLabel(" - "));
        jp4.add(SignUpPN1);

        jp2.add(SignUpButton, "가입하기");
        jp2.add(SignUpBack, ("취소"));

        CheckButton.addActionListener(this);
        SignUpButton.addActionListener(this);
        SignUpBack.addActionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if ( actionEvent.getSource() == SignUpButton){
            /*
    이름이 빈칸인지
    ID가 빈칸인지 , 중복확인을 눌렀는지
    PW 가 빈칸인지, 자리수를 맞췃는지
    PWC 가 PW랑 같은지
    생년월일 입력햇는지
    번호 입력했는지
     */
            String a = SignUpPN1.getText();
            File f = new File(a);    // 핸드폰번호를가져와서 디렉토리를 만듬
            if(!f.exists()){
                f.mkdir();
                FileOutputStream Output1 = null;
                FileOutputStream Output2 = null;
                FileOutputStream Output3 = null;
                FileOutputStream Output4 = null;
                try {
                    Output1 = new FileOutputStream("Name.txt");
                    Output2 = new FileOutputStream("ID.txt");
                    Output3 = new FileOutputStream("PW.txt");
                    Output4 = new FileOutputStream("PN1.txt");
                    String data1 = SignUpName.getText();
                    String data2 = SignUpID.getText();
                    String data3 = SignUpPW.getText();
                    String data4 = SignUpPN1.getText();
                    byte data01[] = data1.getBytes();
                    Output1.write(data01);
                    byte data02[] = data2.getBytes();
                    Output2.write(data02);
                    byte data03[] = data3.getBytes();
                    Output3.write(data03);
                    byte data04[] = data4.getBytes();
                    Output4.write(data04);
                }catch (Exception e){
                    System.out.println("ㅁㄹ");
                }
            }
            else {
                System.out.println("같은 정보가 존재합니다");
            }
//            FileOutputStream SignUpOutPut = null;
//            try{
//                SignUpOutPut = new FileOutputStream("SignUpName.txt");
//                String nameData = SignUpName.toString();
//
//            }catch (Exception e){
//                System.out.println(" ㅁㄹ ");
//            }


        }
    }

    //    @Override
//    public void actionPerformed(ActionEvent actionEvent) {
//        if ( actionEvent.getSource() == SignUpBack ){
//            if()
//        }
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent actionEvent) {
//        if ( actionEvent.getSource() == CheckButton ){
//            if()
//        }
//    }
    void SignUpName(){

    }
    void SignUpID(){

    }
    void SignUpPW(){

    }
    void SignUpBirth(){

    }
    void SignUpPN(){

    }
    void SignUpBack(){

    }
    void SignUpPWC(){

    }
    public static void main(String[] args) {
        SignUpPage sup = new SignUpPage();
    }
}
