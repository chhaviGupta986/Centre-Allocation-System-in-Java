package exam_seating;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class Candidatelogin_success extends JFrame implements database, ActionListener{
    String print_centre,print_centreloc,print_instcode,print_roll,print_name;
    JButton home_but,ok;
    Candidatelogin_success(String username){
        super("Candidate Page");
        for(Student element:student_vector){
            if(username.equals(element.susername)){
                print_centre=element.alloted;
                print_name=element.student_name;
                print_roll=element.roll_num;
                //INSTTITUTE ID KA KYA TYPE HOGA///
                for(Institute element1:institute_vector){
                    if(element1.centre_name.equals(element.alloted)){
                        print_centreloc=element1.location;
                        print_instcode=""+element1.insti_code;
                    }
                }
                
            }
        }
        
        setBounds(450, 150, 700, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new CardLayout());
        setVisible(true);
        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 650, 300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Candidate-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(172, 216, 230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        add(panel);
        JLabel heading = new JLabel("My Account\n");
        heading.setBounds(50, 40, 300, 40);
        heading.setForeground(Color.RED);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        panel.add(heading);
        home_but = new JButton("Home");
        home_but.setBackground(Color.BLACK);
        home_but.setForeground(Color.WHITE);
        home_but.setBounds(10, 300, 120, 25);
        home_but.addActionListener(this);
        panel.add(home_but);
        ok = new JButton("Ok");
        ok.setBackground(Color.BLACK);
        ok.setForeground(Color.WHITE);
        ok.setBounds(340, 300, 120, 25);
        ok.addActionListener(this);
        panel.add(ok);
        JLabel logined_name = new JLabel("Name:");
        logined_name.setBounds(50, 100, 150, 25);
        logined_name.setForeground(Color.BLACK);
        logined_name.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(logined_name);
        JLabel logined_name1 = new JLabel(print_name);
        logined_name1.setBounds(300, 100, 150, 25);
        logined_name1.setForeground(Color.BLACK);
        logined_name1.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(logined_name1);

        JLabel logined_roll = new JLabel("Roll No.:");
        logined_roll.setBounds(50, 140, 150, 25);
        logined_roll.setForeground(Color.BLACK);
        logined_roll.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(logined_roll);
        JLabel logined_roll1 = new JLabel(print_roll);
        logined_roll1.setBounds(300, 140, 150, 25);
        logined_roll1.setForeground(Color.BLACK);
        logined_roll1.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(logined_roll1);

        JLabel centre_allocated = new JLabel("Centre Allocated:");
        centre_allocated.setBounds(50, 180, 150, 25);
        centre_allocated.setForeground(Color.BLACK);
        centre_allocated.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(centre_allocated);
        JLabel centre_allocated1 = new JLabel(print_centre);
        centre_allocated1.setBounds(300, 180, 150, 25);
        centre_allocated1.setForeground(Color.BLACK);
        centre_allocated1.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(centre_allocated1);

        JLabel location = new JLabel("Location:");
        location.setBounds(50, 220, 300, 25);
        location.setForeground(Color.BLACK);
        location.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(location);
        JLabel location1 = new JLabel(print_centreloc);
        location1.setBounds(300, 220, 150, 25);
        location1.setForeground(Color.BLACK);
        location1.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(location1);

        JLabel insti_id = new JLabel("Institute Id:");
        insti_id.setBounds(50, 260, 3150, 25);
        insti_id.setForeground(Color.BLACK);
        insti_id.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(insti_id);
        JLabel insti_id1 = new JLabel(print_instcode);
        insti_id1.setBounds(300, 260, 150, 25);
        insti_id1.setForeground(Color.BLACK);
        insti_id1.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(insti_id1);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ok) {
            setVisible(false);
            

        } else if (ae.getSource() == home_but) {
            setVisible(false);
            new Home();
        }
    }
}
