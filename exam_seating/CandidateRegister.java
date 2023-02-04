package exam_seating;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
public class CandidateRegister extends JFrame implements ActionListener{

    JFrame error_frame= new JFrame("centre error");
    JButton create, back;
    Choice centre_choice1,centre_choice2,centre_choice3;
    JTextField meter, username, name, password;
    CandidateRegister(){
        
        setBounds(450, 150, 700, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new CardLayout());
        
        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 650, 300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Register-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0,0,200)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        add(panel);
        
        JLabel heading = new JLabel("Enter your centre preferences:\n");
        heading.setBounds(100, 40, 300, 20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(heading);
        
        centre_choice1 = new Choice();
        JLabel heading1 = new JLabel("First preference:");
        heading1.setBounds(100, 70, 140, 20);
        heading1.setForeground(Color.GRAY);
        heading1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(heading1);

        int n=Institute.location_list.size();
        for(int i=0;i<n;i++){
            centre_choice1.add(Institute.location_list.get(i));
        }

        centre_choice1.setBounds(260, 70, 150, 20);
        panel.add(centre_choice1);
        centre_choice2 = new Choice();
        JLabel heading2 = new JLabel("Second preference:");
        heading2.setBounds(100, 100, 140, 20);
        heading2.setForeground(Color.GRAY);
        heading2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(heading2);

        centre_choice2.setBounds(260, 100, 150, 20);
        for(int i=0;i<n;i++){
            centre_choice2.add(Institute.location_list.get(i));
        }
        panel.add(centre_choice2);
        centre_choice3 = new Choice();
        JLabel heading3 = new JLabel("Third preference:");
        heading3.setBounds(100, 130, 140, 20);
        heading3.setForeground(Color.GRAY);
        heading3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(heading3);

        centre_choice3.setBounds(260, 130, 150, 20);
        for(int i=0;i<n;i++){
            centre_choice3.add(Institute.location_list.get(i));
        }
        panel.add(centre_choice3);

        meter = new JTextField();
        meter.setBounds(260, 90, 150, 20);
        meter.setVisible(false);
        panel.add(meter);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(100, 180, 140, 20);
        lblusername.setForeground(Color.GRAY);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblusername);
        
        username = new JTextField();
        username.setBounds(260, 180, 150, 20);
        panel.add(username);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100, 210, 140, 20);
        lblname.setForeground(Color.GRAY);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblname);
        
        name = new JTextField();
        name.setBounds(260, 210, 150, 20);
        panel.add(name);       
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(100, 240, 140, 20);
        lblpassword.setForeground(Color.GRAY);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblpassword);
        
        password = new JTextField();
        password.setBounds(260, 240, 150, 20);
        panel.add(password);

        create = new JButton("Register");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setBounds(140, 300, 120, 25);
        create.addActionListener(this);
        panel.add(create);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 300, 120, 25);
        back.addActionListener(this);
        panel.add(back);

        centre_choice1.addItemListener(null);
        centre_choice2.addItemListener(null);
        centre_choice3.addItemListener(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            try{
                String c1 = centre_choice1.getSelectedItem();
                String c2 = centre_choice2.getSelectedItem();
                String c3 = centre_choice3.getSelectedItem();
                String susername = username.getText();
                String sname = name.getText();
                String spassword = password.getText();
                name.setText("");
                password.setText("");
                username.setText("");
                if(Student.usernameTaken(susername)==false){
                    if(c1==c2 || c2==c3 || c3==c1){
                        //choice repeated
                        throw new ChoiceRepeatedException();
                    }
                    else{
                        
                        new Student(sname,susername,spassword,c1,c2,c3);
                    }
                }
            }
            catch(ChoiceRepeatedException e){
                JOptionPane.showMessageDialog(error_frame,"Cant have any two preferences with same choice of location. Please change your preference.","Action not allowed", JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(error_frame, "Unknown error, try again or contact admin.","Unknown!", JOptionPane.ERROR_MESSAGE);
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            
            new Home();
        }
    }

}
class ChoiceRepeatedException extends Exception{}

