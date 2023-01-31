package exam_seating;
import java.util.*;
import javax.swing.*;
//import javax.swing.border.*;
//import java.awt.*;
//import java.awt.event.*;
interface database{
    static Vector<Institute> institute_vector = new Vector<Institute>();
    static Vector<Student> student_vector=new Vector<Student>();
}

class Student extends JFrame implements database {
    static JFrame error_frame2= new JFrame("Error");
    static JFrame taken= new JFrame("taken");
    String student_name;
    String centre_choice1,centre_choice2,centre_choice3;
    String susername,spassword;//student username password
    String alloted;
    String roll_num;
    Student(String name,String uname,String pass,String choice_1,String choice_2,String choice_3 ){
        student_name=name;
        susername=uname;
        spassword=pass;
        centre_choice1=choice_1;
        centre_choice2=choice_2;
        centre_choice3=choice_3;
        student_vector.add(this);
        Allocate();
        System.out.println("INSTITUTE ALLOTED="+alloted);

    }
    void Allocate(){
        try{
        //after every student object creation- i will call studentobj.Allocate()
        //dont forget to call usernameTaken before.
        //no parameters coz student.obj krke call kreneg so i already know centre choices
        for(Institute element:institute_vector){
            if(element.location.equalsIgnoreCase(centre_choice1)){
                //found insttitute/s whose location match with choice 1
                if(element.count<element.capacity){
                    this.alloted=element.centre_name;
                    element.add_to_roll++;
                    this.roll_num=""+(((element.insti_code)*1000)+element.add_to_roll);
                    element.count++;
                    //everytime that any institute gets allocated: incremeent that institute.add_to_roll
                    //and add it to that institutes code and that bcoms roll number.
                    System.out.println("CHOICE 1: count:"+element.count+"capacity:"+element.capacity);
                    return; // if first choice got allocated then fxn ends
                }
                // if iss institute ka capacity full so not alloted, then return didnt happen.
                //but control still inside this for loop until all institutes checked. so if aage jaake one more
                //institute on first choice found, then it will be alloctaed and returned and if not..
                //then go on to second choice wala for loop.
                //if it didnt match with choiuce 1, idc, continue next iteration
            }
        }
        //now next for loop for second choice selction.
        for(Institute element:institute_vector){
            if(element.location.equalsIgnoreCase(centre_choice2)){
                //found insttitute/s whose location match with choice 2
                if(element.count<element.capacity){
                    this.alloted=element.centre_name;
                    element.add_to_roll++;
                    this.roll_num=""+(((element.insti_code)*1000)+element.add_to_roll);
                    System.out.println("CHOICE 2: count:"+element.count+"capacity:"+element.capacity);
                    element.count++;
                    return; // if second choice got allocated then fxn ends
                }
            }
        }
        for(Institute element:institute_vector){
            if(element.location.equalsIgnoreCase(centre_choice3)){
                
                //found insttitute/s whose location match with choice 3
                if(element.count<element.capacity){
                    this.alloted=element.centre_name;
                    element.add_to_roll++;
                    this.roll_num=""+(((element.insti_code)*1000)+element.add_to_roll);
                    //element.students_allocated.add(this);
                    element.count++;
                    System.out.println("CHOICE 3: count:"+element.count+"capacity:"+element.capacity);
                    return; // if third choice got allocated then fxn ends
                }
            }
        }
        //comes here if nothing allotted.
        throw new ChoiceFullException();
    }
        catch(ChoiceFullException e){
            JOptionPane.showMessageDialog(error_frame2, "Institute could not be allocated: please contact administrator for more details.","Error!", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(error_frame2, "Unexpected error: please contact administrator for more details.","Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    //student has been created. username password also set.
    //now we have to allot. check if choice 1 is full and so on.
    //first find from the vector, elements whose location matches centre_choice.
    //check if username already exist
    static boolean usernameTaken(String username){
        //used during registeration time, right after getting username entered value
        boolean taken=false;
        
        for(Student student:student_vector){
            //System.out.println("student username:"+student.susername);

                if(student.susername.equals(username)){
                    
                    taken=true;
                   
                    JOptionPane.showMessageDialog(error_frame2, "Username is taken! Try different username","Error!", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            return taken;
        }
    static boolean verifyuser(String username,String password){
        //used during login time
        boolean verified=false;
            for(Student student:student_vector){
                
                if(student.susername.equals(username)==true){
                    if(student.spassword.equals(password)==false){
                        break;
                    }
                    else{
                        verified=true;
                        break;
                    }
                }
            }

        return verified;
    }
}

class Institute extends JFrame implements database{
    static Vector<String> location_list=new Vector<>();//list of locations obtained
    
    String centre_name;
    JTable jt;
    String location;
    int capacity;
    int insti_code;
    int count=0;
    int add_to_roll=610;
    static JFrame error_frame= new JFrame("Error");
    JFrame f;
    Institute(String centre_name,String location,int capacity){
        int j=institute_vector.size();
        this.capacity=capacity;
        this.centre_name=centre_name;
        this.location=location;
        institute_vector.add(this);
        if(location_list.contains(location)==false){
            //if centre not already there
            location_list.add(location);
        }
        insti_code=110+j;//3 digit
        ++j;
    }
    //institute has been created and sent to vector of institute as element.
    void print_list(){//two loops
        //for every element in the institue vector, for every element in the student vector,
        //if instituteelement.centre==studentelement.alloted
        //create new vector,add it to new vector. this is vector corresponding to 
        //that particular institute indexiwise.
        f=new JFrame(centre_name);
        String column[]={"ROLL NO.","STUDENT NAME"};
        
        String data[][]=new String[count][];
        int i=0;
        try{
            for(Institute element:institute_vector){ 
                if(centre_name.equalsIgnoreCase(element.centre_name)){
                    for(Student st:student_vector){
                        if(st.alloted.equals(centre_name)){
                            //found student who needs to be printed.
                            String toAdd[]={st.roll_num,st.student_name};
                            data[i]=toAdd;
                            i++;
                            
                        }
                    }break;
                }}                   
                
            
            jt=new JTable(data,column);    
            jt.setBounds(30,40,200,300);          
            JScrollPane sp=new JScrollPane(jt);    
            f.add(sp);          
            f.setSize(300,400);    
            f.setVisible(true);   
        }
        catch(Exception e){
            //if any unexpected unthought of exception hpns
            System.out.println(e);
            JOptionPane.showMessageDialog(error_frame, "Unknown error, try again or contact admin.","Unknown!", JOptionPane.ERROR_MESSAGE);
        }

    }
}

class ChoiceFullException extends Exception{
    public String toString(){
        return "Msg to Admin:All institutes are filled. Need more institues!";
    }
}


