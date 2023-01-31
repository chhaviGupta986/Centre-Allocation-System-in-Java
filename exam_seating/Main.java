package exam_seating;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class Home extends JFrame implements ActionListener{
    JButton admin_login, candi_regis,candi_login;
    JFrame f;

    Home(){

        setBounds(105, 105, 700, 400);

        setLayout(new GridLayout());
        setVisible(true);

        
        JPanel panel1 = new JPanel();
        panel1.setBounds(30, 30, 650, 300);
        panel1.setBorder(new TitledBorder(new LineBorder(new Color(0,0,255), 2), "Home Page", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(172, 216, 230)));
        panel1.setBackground(new Color(0,0,255));
        add(panel1);

        //ADMIN LOGIN BUTTON
        admin_login = new JButton("Admin Login");
        admin_login.setBackground(Color.BLACK);
        admin_login.setForeground(Color.WHITE);
        admin_login.setBounds(10, 20, 120, 25);
        admin_login.addActionListener(this);
        panel1.add(admin_login);
        //CANDIDATE REGISTER BUTTON
        candi_regis = new JButton("Candidate Register");
        candi_regis.setBackground(Color.BLACK);
        candi_regis.setForeground(Color.WHITE);
        candi_regis.setBounds(170, 20, 150, 25);
        candi_regis.addActionListener(this);
        panel1.add(candi_regis);
        //CANDIDATE LOGIN
        candi_login = new JButton("Candidate Login");
        candi_login.setBackground(Color.BLACK);
        candi_login.setForeground(Color.WHITE);
        candi_login.setBounds(350, 20, 170, 25);
        candi_login.addActionListener(this);
        panel1.add(candi_login);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == admin_login) {
            setVisible(false);
            new AdminLogin();

        } else if (ae.getSource() == candi_regis) {
            if(Admin_success.finalised==false){
                //centres not added
                f=new JFrame();  
                JOptionPane.showMessageDialog(f,"Registrations not open yet. Check back again soon!");  
            }
            else{
                setVisible(false);
                new CandidateRegister();
            }         
        }
        else if (ae.getSource()== candi_login){
            setVisible(false);
                new CandidateLogin();
        }
    }
}

class AdminLogin extends JFrame implements ActionListener{
    static String Admin_username="admin";
    static String Admin_password="admin123";
    JFrame error_frame = new JFrame("Error");
    JButton loginButton, back;
    Choice accountType;
    JTextField meter, username, name, password;
    AdminLogin(){
        
        setBounds(450, 150, 700, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 650, 300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Admin Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(172, 216, 230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        add(panel);
        
        JLabel heading = new JLabel("Admin Account\n");
        heading.setBounds(50, 40, 300, 40);
        heading.setForeground(Color.RED);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        panel.add(heading);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(100, 130, 140, 20);
        lblusername.setForeground(Color.GRAY);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblusername);
        
        username = new JTextField();
        username.setBounds(260, 130, 150, 20);
        panel.add(username);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(100, 210, 140, 20);
        lblpassword.setForeground(Color.GRAY);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblpassword);
        
        password = new JTextField();
        password.setBounds(260, 210, 150, 20);
        panel.add(password);
        
        loginButton = new JButton("Login");
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBounds(140, 260, 120, 25);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 260, 120, 25);
        back.addActionListener(this);
        panel.add(back);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == loginButton) {

            String susername = username.getText();

            String spassword = password.getText();

            try{
                if(susername.equals(Admin_username) && spassword.equals(Admin_password)){

                    setVisible(false);
                    new Admin_success();
                }
                else{
                    throw new WrongCredsException();
                }
            }
            catch(WrongCredsException e){
                System.out.println(e);
                JOptionPane.showMessageDialog(error_frame, "Incorrect password or username! Please Try again","Error!", JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(error_frame, "Unknown error, try again or contact admin.","Unknown!", JOptionPane.ERROR_MESSAGE);
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Home();
        }
    }
}
class WrongCredsException extends Exception{
    public String toString(){
        return "Incorrect Details entered";
    }
}
class Admin_success extends JFrame implements ActionListener {
    JButton submit,view_institute,add_institute;
    static boolean finalised=false;
    Admin_success(){//constructor for login frame
       
        super("LOGIN");
        getContentPane().setBackground(new Color(227,228,250));
        setLayout(new GridBagLayout());//it nullifies the default option of taking all axis as centre

        setSize(500,200);
        setLocation(400,400);
        setVisible(true);//to see the frame
        if(finalised==false){
            add_institute=new JButton("Add new Institute");
            add_institute.setBounds(400, 400, 80, 20);
            add(add_institute);
            add_institute.addActionListener(this);
        }
        view_institute=new JButton("View Institutes");
        view_institute.setBounds(400, 400, 80, 20);
        add(view_institute);
        view_institute.addActionListener(this);
        submit=new JButton("Home");
        submit.setBounds(400, 400, 80, 20);
        submit.addActionListener(this);
        add(submit);

    } 
        public void actionPerformed(ActionEvent ae){
            if (ae.getSource() == submit){
                setVisible(false);

                new Home();    
            }
            else if(ae.getSource()==add_institute){
                setVisible(false);
                new Add_institute();
            }
            else if(ae.getSource()==view_institute){
                setVisible(false);
                new View_institutes();
            }
    }
}

public class Main{
    public Main(){
        new Home();

}}