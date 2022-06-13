import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SignUpPage extends JFrame implements ActionListener {
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JPanel jp3 = new JPanel();
    JPanel jp4 = new JPanel();
    JTextField SignUpName = new JTextField();
    JLabel SignUpNameL = new JLabel("이름을 입력하세요");
    JTextField SignUpID = new JTextField();
    JButton CheckButton = new JButton(" 중복 확인 ");
    JPasswordField SignUpPW = new JPasswordField(16);

    JLabel SignUpPWL = new JLabel("비밀번호를 입력하세요");
    JPasswordField SignUpPWC = new JPasswordField(16);
    JLabel SignUpPWCL = new JLabel();
    JButton SignUpButton = new JButton("가입하기");
    JButton SignUpBack = new JButton("취소");
    JLabel CheckLabel = new JLabel("아이디를 입력하세요");

    JComboBox SignUpYear = new JComboBox();
    JComboBox SignUpMonth = new JComboBox();
    JComboBox SignUpDay = new JComboBox();
    JTextField SignUpPN1 = new JTextField();
    int CheckButtonCount = 0;
//    011 010 016 017 018 019
    public SignUpPage(){
        super("회원가입");
        setVisible(true);
        setSize(1000, 800);
        setLayout(new BorderLayout());
        jp1.setLayout(new GridLayout(6, 3));
        jp2.setLayout(new GridLayout(1, 2));
        jp3.setLayout(new FlowLayout());

        add(jp1, BorderLayout.CENTER);
        add(jp2, BorderLayout.SOUTH);

        jp1.add(new JLabel("이름"));
        jp1.add(SignUpName);
        jp1.add(SignUpNameL);

        jp1.add(new JLabel("ID"));
        jp1.add(SignUpID);
        jp1.add(jp4);

        jp4.setLayout(new GridLayout( 2, 1));
        jp4.add(CheckButton);
        jp4.add(CheckLabel);

        jp1.add(new JLabel("PW"));
        jp1.add(SignUpPW);
        jp1.add(SignUpPWL);

        jp1.add(new JLabel("PW 확인"));
        jp1.add(SignUpPWC);
        jp1.add(SignUpPWCL);

        jp1.add(new JLabel("생년월일"));
        jp1.add(jp3);
        jp1.add(new JLabel("생년월일을 입력하세요"));

        jp1.add(new JLabel("번호"));
        jp1.add(SignUpPN1);
        jp1.add(new JLabel("전화번호를 입력하세요"));

        SignUpYear.addItem("년");
        SignUpMonth.addItem("달");
        SignUpDay.addItem("일");
        for ( int i = 1900; i <2023; i ++){
            SignUpYear.addItem(i);
        }
        for ( int j = 1; j< 13; j++){
            SignUpMonth.addItem(j);
        }
        for (int k = 1; k <= 31; k++){
            SignUpDay.addItem(k);
        }

        jp3.setLayout(new FlowLayout());
        jp3.add(SignUpYear);
        jp3.add(new JLabel(" / "));
        jp3.add(SignUpMonth);
        jp3.add(new JLabel(" / "));
        jp3.add(SignUpDay);

        jp2.add(SignUpButton, "가입하기");
        jp2.add(SignUpBack, ("취소"));


        CheckButton.addActionListener(this);
        SignUpButton.addActionListener(this);
        SignUpBack.addActionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        SignUpID.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                CheckButtonCount = 0;
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String textID = SignUpID.getText();

        if (actionEvent.getSource() == CheckButton) {
            //            String data_path = System.getProperty("user.dir") + "/Datadir/" ;
            File f = new File("Data");
            try {
                // 폴더에 들어가서 ID txt를 찾아서 중복되는지 확인
//                System.out.println(f.list());
                String[] dataDirList = f.list();
                for (String list : dataDirList) {
                    FileInputStream IDCheck = new FileInputStream(f.getPath() + "/" + list + "/ID.txt");

                    byte a[] = new byte[IDCheck.available()];

                    while (IDCheck.read(a) != -1) { }
                    String data = new String(a);
                    if (SignUpID.getText().equals(data)) {
//                CheckButton을 눌렀을떄 데이터를 정리검색해서 입력한 값이랑 같은게 있는지
                        CheckLabel.setText("중복된 아이디가 존재합니다.");
                        break;
                    } else {
                        CheckLabel.setText("사용 가능합니다.");
                        CheckButtonCount += 1;
                    }
                }

            } catch (Exception a) {
                System.out.println(a);
            }
        }


        if (actionEvent.getSource() == SignUpButton) {
            String textName = SignUpName.getText();
            String textPW = String.valueOf(SignUpPW.getPassword());
            String a = SignUpPN1.getText();
            String data_path = System.getProperty("user.dir") + "/Data/";
            File f = new File(data_path + a);    // 핸드폰번호를가져와서 디렉토리를 만듬

//            switch(textName.length()){
//                case 0:
//                    SignUpNameL.setText("이름을 입력하세요");
//                    break;
//                default:
//                    SignUpNameL.setText("이름이 입력됐습니다");
//            }
//            switch(textID.length()){
//                case 0:
//                    CheckLabel.setText("아이디를 입력하세요");
//                    break;
//                default:
//                    CheckLabel.setText("중복확인을 누르세요");
//                    break;
//            }
            if(textPW.length() >= 8 && textPW.length() <= 16 && textName.length() >= 1
                    && textID.length() >= 1 && a.length() == 8)
                System.out.println("정보는 모두 입력됐다");
                if(String.valueOf(SignUpPW.getPassword()).equals(String.valueOf(SignUpPWC.getPassword()))){
                    SignUpPWL.setText("비밀번호가 같습니다");
                    System.out.println(" PW와 PW확인이 같다  ");
                    if(SignUpDay.getSelectedItem().toString() != "일" && SignUpMonth.getSelectedItem().toString() != "달"
                    && SignUpYear.getSelectedItem().toString() != "년"){
                        System.out.println("날짜를 다 골랐다 ");
                        if ( CheckButtonCount >= 1){
                            if (!f.exists()) {
                                f.mkdir();
                                FileOutputStream Output1 = null;
                                FileOutputStream Output2 = null;
                                FileOutputStream Output3 = null;
                                FileOutputStream Output4 = null;
                                FileOutputStream Output5 = null;
                                try {
                                    String f_path = f.getPath();
                                    f_path = f_path + "/";

                                    Output1 = new FileOutputStream(f_path + "Name.txt");
                                    Output2 = new FileOutputStream(f_path + "ID.txt");
                                    Output3 = new FileOutputStream(f_path + "PW.txt");
                                    Output4 = new FileOutputStream(f_path + "PN.txt");
                                    Output5 = new FileOutputStream(f_path + "Birth.txt");

                                    String data1 = SignUpName.getText();
                                    String data2 = SignUpID.getText();
                                    String data3 = SignUpPW.getText();
                                    String data4 = SignUpPN1.getText();
                                    String data5 = SignUpYear.getSelectedItem().toString() + SignUpMonth.getSelectedItem().toString() +
                                            SignUpDay.getSelectedItem().toString();

                                    byte data01[] = data1.getBytes();
                                    Output1.write(data01);
                                    byte data02[] = data2.getBytes();
                                    Output2.write(data02);
                                    byte data03[] = data3.getBytes();
                                    Output3.write(data03);
                                    byte data04[] = data4.getBytes();
                                    Output4.write(data04);
                                    byte data05[] = data5.getBytes();
                                    Output5.write(data05);
                                    System.out.println(" 회원가입 완료 ");

                                } catch (Exception e) {
                                    System.out.println("ㅁㄹ");
                                }
                            }
                            }else{
                                System.out.println(" 저장 실패 ");
                            }

                    }

                }
            else {
//                SignUpPWL.setText("비밀번호는 8자 이상 16자 이하로 입력하세요");
            }
            /*
    중복확인을 눌렀는지
    생년월일 내용을 텍스트에추가
     */

        }
    }
    public static void main(String[] args) {
        SignUpPage sup = new SignUpPage();
    }
}
