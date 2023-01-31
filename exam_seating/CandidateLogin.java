package exam_seating;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class CandidateLogin extends JFrame implements ActionListener{

    JFrame error_frame = new JFrame("Error");
    JButton loginButton, back;
    Choice accountType;
    JTextField meter, username, name, password;
    CandidateLogin(){
        
        setBounds(450, 150, 700, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 650, 300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0,0,255), 2), "Login Page", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(172, 216, 230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        add(panel);
        
        meter = new JTextField();
        meter.setBounds(260, 90, 150, 20);
        meter.setVisible(false);
        panel.add(meter);
        
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
        
        JLabel heading = new JLabel("Candidate Login\n");
        heading.setBounds(100, 40, 300, 40);
        heading.setForeground(Color.RED);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        panel.add(heading);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginButton) {
            
            String susername = username.getText();
            String spassword = password.getText();
            try{
                if(Student.verifyuser(susername,spassword)){
                    //if successful
                    setVisible(false);
                    new Candidatelogin_success(susername);
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
                //if any other exceptoin hasnt been handled
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Home();
        }
    }
}
