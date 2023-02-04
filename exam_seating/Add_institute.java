package exam_seating;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Add_institute extends JFrame implements ActionListener{

    JFrame error_frame = new JFrame("Error");
    JButton finaliseButton, addButton,back_but;
    Choice accountType;
    JTextField get_insti_name, get_insti_loc, get_insti_cap;
    Add_institute(){
        
        setBounds(450, 150, 700, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 650, 300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Add Institutes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 200)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        add(panel); 
        
        JLabel inst_name = new JLabel("Name of institute:");
        inst_name.setBounds(120, 90, 200, 20);
        inst_name.setForeground(Color.GRAY);
        inst_name.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(inst_name);
        
        get_insti_name= new JTextField();
        get_insti_name.setBounds(260, 90, 300, 20);
        panel.add(get_insti_name);
        
        JLabel loc_name = new JLabel("Location of institute:");
        loc_name.setBounds(100, 120, 200, 20);
        loc_name.setForeground(Color.GRAY);
        loc_name.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(loc_name);
        
        get_insti_loc = new JTextField();
        get_insti_loc.setBounds(260, 120, 300, 20);
        panel.add(get_insti_loc);

        JLabel capacity_label = new JLabel("Capacity of institute:");
        capacity_label.setBounds(100, 150, 200, 20);
        capacity_label.setForeground(Color.GRAY);
        capacity_label.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(capacity_label);
        
        get_insti_cap = new JTextField();
        get_insti_cap.setBounds(260, 150, 300, 20);
        panel.add(get_insti_cap);
       
        finaliseButton = new JButton("Finalise");
        finaliseButton.setBackground(Color.BLACK);
        finaliseButton.setForeground(Color.WHITE);
        finaliseButton.setBounds(500, 250, 120, 25);
        finaliseButton.addActionListener(this);
        panel.add(finaliseButton);

        addButton = new JButton("Add next");
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        addButton.setBounds(50, 250, 120, 25);
        addButton.addActionListener(this);
        panel.add(addButton);
        
        JLabel warn = new JLabel("*Institutes cannot be added once finalised!*");
        warn.setBounds(120, 200, 400, 20);
        warn.setForeground(Color.RED);
        warn.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(warn);

        back_but = new JButton("Back");
        back_but.setBackground(Color.BLACK);
        back_but.setForeground(Color.WHITE);
        back_but.setBounds(265, 250, 120, 25);
        back_but.addActionListener(this);
        panel.add(back_but);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == finaliseButton) {
            Admin_success.finalised=true;
            setVisible(false);
            String  inst_name_str= get_insti_name.getText();
            String  inst_loc_str= get_insti_loc.getText();
            String inst_cap_str=get_insti_cap.getText();
            Integer inst_cap_int = Integer.valueOf(inst_cap_str);
            new Institute(inst_name_str,inst_loc_str,inst_cap_int);
            //same old pages open with one less button
            new Admin_success();

        } else if (ae.getSource() == addButton) {
            String  inst_name_str= get_insti_name.getText();
            String  inst_loc_str= get_insti_loc.getText();
            String inst_cap_str=get_insti_cap.getText();
            Integer inst_cap_int = Integer.valueOf(inst_cap_str);
            new Institute(inst_name_str,inst_loc_str,inst_cap_int);

            get_insti_name.setText("");
            get_insti_loc.setText("");
            get_insti_cap.setText("");

        }
        else if (ae.getSource() == back_but) {
            setVisible(false);
            new Admin_success();

        }
    }

    public static void main(String[] args) {
        new Add_institute();
    }
}

