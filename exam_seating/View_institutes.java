package exam_seating;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class View_institutes extends JFrame implements ActionListener,database{
    static JButton submit,back;
    Choice inst_choice;
    View_institutes(){//constructor for login frame
        
        super("Choose Centre");//super must be the first line in the constructor
        getContentPane().setBackground(new Color(227,228,250));//getcontentpane give acces to all the features of frame
        setLayout(null);//it nullifies the default option of taking all axis as centre
        JLabel lbl=new JLabel("Select institute:");
        lbl.setBounds(10,100,100,50);
        add(lbl);
        lbl.setForeground(Color.BLUE);//changes the color of the text

        inst_choice=new Choice();//for dropdown menu
        for(Institute element:institute_vector){
            inst_choice.add(element.centre_name);
        }
        inst_choice.setBounds(250, 117, 200, 20);
        add(inst_choice);
        JLabel head=new JLabel("Generate student allocation list institute wise");
        head.setBounds(50,40,400,50);
        head.setForeground(Color.BLACK);
        head.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(head);
        lbl.setForeground(Color.BLUE);


        setSize(500,500);
        setLocation(400,400);
        setVisible(true);//to see the frame
        submit=new JButton("Select");
        submit.setBounds(400, 400, 80, 20);
        add(submit);
        submit.addActionListener(this);
        back=new JButton("Back");
        back.setBounds(50, 400, 80, 20);
        add(back);
        back.addActionListener(this);
    }

   public void actionPerformed(ActionEvent ae){

        JFrame frame= new JFrame();
        if (ae.getSource() == submit){
      
            String selected_insti=inst_choice.getSelectedItem();
            System.out.println(selected_insti);
            frame.dispose();
            for(Institute element:institute_vector){
                if(selected_insti.equals(element.centre_name)){
                    element.print_list();
                }
            }

           }
        else if(ae.getSource()==back){
            new Admin_success();
            setVisible(false);
        }
}

}
