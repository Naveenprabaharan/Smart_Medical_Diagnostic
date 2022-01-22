import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/*
<applet code="Train.class" width="1500" height="1500"></applet>
*/
public class Train extends Applet implements ActionListener{
    TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12;
    Button submit;
    Choice ch1,ch2,ch3,ch4;
public void init(){
setBackground(Color.lightGray);
Label topicname = new Label("RAILWAY RESERVATION ");
Label personal = new Label("PERSONAL DETAILS ");
Label booking = new Label("BOOKING DETAILS ");

Label firstname = new Label("FIRSTNAME");
 tf1 =new TextField();

Label lastname = new Label("LASTNAME");
tf2 =new TextField();

Label age = new Label("AGE");
 tf3 =new TextField();

Label gender= new Label("GENDER");
 tf4 =new TextField();
ch1 = new Choice();
ch1.add("male");
ch1.add("female");
ch1.add("transgender");

Label phonenumber= new Label("PHONENUMBER");
tf5 =new TextField();

Label aadhar = new Label("AADHARNUMBER");
 tf6 =new TextField();

Label address = new Label("ADDRESS");
tf7 =new TextField();

Label source = new Label("SOURCE");
 tf8 =new TextField();
 ch2 = new Choice();
ch2.add("chennai");
ch2.add("madurai");
ch2.add("coimbatore");
ch2.add("trichy");
ch2.add("kanyakumari");

Label dest = new Label("DESTINATION");
tf9 =new TextField();
 ch3 = new Choice();
ch3.add("chennai");
ch3.add("madurai");
ch3.add("coimbatore");
ch3.add("trichy");
ch3.add("kanyakumari");

Label dateoftravel = new Label("DATEOFTRAVEL");
tf10 =new TextField();

Label dateofarrival = new Label("DATEOFARRIVAL");
 tf11 =new TextField();

Label trainclass = new Label("TRAINCLASS");
tf12=new TextField();
ch4 = new Choice();
ch4.add("Firstclass-AC");
ch4.add("Firstclass-Non AC");
ch4.add("Secondclass");
ch4.add("Thirdclass");

submit = new Button("SUBMIT");
submit.setBackground(Color.red);

setLayout(null);

topicname.setBounds(350,5,200,30);
personal.setBounds(350,45,200,30);
booking.setBounds(350,240,200,30);

firstname.setBounds(50,80,120,30);
tf1.setBounds(200,85,120,20);

lastname.setBounds(50,110,120,30);
tf2.setBounds(200,115,120,20);

age.setBounds(50,140,120,30);
tf3.setBounds(200,145,120,20);

gender.setBounds(50,170,120,30);
ch1.setBounds(200,175,120,30);


phonenumber.setBounds(50,200,120,30);
tf5.setBounds(200,205,120,20);

aadhar.setBounds(500,80,120,30);
tf6.setBounds(650,85,120,20);

address.setBounds(500,110,120,30);
tf7.setBounds(650,115,160,70);

source.setBounds(50,270,120,30);
ch2.setBounds(200,275,120,30);

dest.setBounds(50,300,120,30);
ch3.setBounds(200,305,120,30);

dateoftravel.setBounds(500,270,120,30);
tf10.setBounds(650,275,120,20);

dateofarrival.setBounds(500,300,120,30);
tf11.setBounds(650,305,160,20);

trainclass.setBounds(50,330,120,30);
ch4.setBounds(200,335,120,30);

submit.setBounds(350,450,120,40);

add(topicname);
add(personal);
add(booking);
add(firstname);
add(lastname);
add(age);
add(gender);
add(phonenumber);
add(aadhar);
add(address);
add(source);
add(dest);
add(dateoftravel);
add(dateofarrival);
add(trainclass);
add(tf1);
add(tf2);
add(tf3);
add(tf4);
add(tf5);
add(tf6);
add(tf7);
add(tf8);
add(tf9);
add(tf10);
add(tf11);
add(tf12);
add(ch1);
add(ch2);
add(ch3);
add(ch4);
add(submit);

Add_ActionListener();

setFont(new Font("Elephant",Font.PLAIN,14));

}
public void actionPerformed(ActionEvent ae) 
{
    String d_fname = tf1.getText(),d_lname=tf2.getText(),d_age=tf3.getText(),d_gender=ch1.getItem(ch1.getSelectedIndex()),d_ph=tf5.getText(),d_adhar=tf6.getText(),d_address=tf7.getText(),
    d_source=ch2.getItem(ch2.getSelectedIndex()),d_dest=ch3.getItem(ch3.getSelectedIndex()),d_dot=tf10.getText(),d_doa=tf11.getText(),d_tclass=ch4.getItem(ch4.getSelectedIndex()); 


    
    String message = ae.getActionCommand();
    
    database(message,d_fname,d_lname,d_age,d_gender,d_ph,d_adhar,d_address,d_source,d_dest,d_dot,d_doa,d_tclass);
    repaint();
}

public void Add_ActionListener()
    {
        tf1.addActionListener(this);
        tf2.addActionListener(this);
        tf3.addActionListener(this);
        tf4.addActionListener(this);
        tf5.addActionListener(this);
        tf6.addActionListener(this);
        tf7.addActionListener(this);
        tf8.addActionListener(this);
        tf9.addActionListener(this);
        tf10.addActionListener(this);
        tf11.addActionListener(this);
        tf12.addActionListener(this);
      
      
      
        submit.addActionListener(this);
    }
    public void database(String message,String d_fname,String d_lname,String d_age,String d_gender,String d_ph,String d_adhar,String d_address,String d_source,String d_dest,String d_dot,String d_doa,String d_tclass){
            String url="jdbc:mysql://localhost:3306/train";
            String uname="root";
            String pass="6381524434";
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Train.class.getName()).log(Level.SEVERE, null, ex);
            }
            String query = "insert into train values(?,?,?,?,?,?,?,?,?,?,?,?)";
        
            try (Connection con = DriverManager.getConnection(url, uname, pass)) {
                PreparedStatement st = con.prepareStatement(query);           
                st.setString(1, d_fname.toUpperCase().trim());
                st.setString(2, d_lname.toUpperCase().trim());
                st.setString(3, d_age.toUpperCase().trim());
                st.setString(4, d_gender);
                st.setString(5, d_ph.toUpperCase().trim());
                st.setString(6, d_adhar.toUpperCase().trim());
                st.setString(7, d_address.toUpperCase().trim());
                st.setString(8, d_source);
                st.setString(9, d_dest);
                st.setString(10, d_tclass);
                st.setString(11, d_dot.toUpperCase().trim());
                st.setString(12, d_doa.toUpperCase().trim());
                
                 int count = st.executeUpdate();
                 result(message,d_fname,d_lname,d_age,d_gender,d_ph,d_adhar,d_address,d_source,d_dest,d_dot,d_doa,d_tclass);
                 JOptionPane.showMessageDialog(null,"Reservation Successfully!");
                 
                st.close();
              
            }catch(Exception e){System.out.println(e);
            }
        
      
    }
public void paint(Graphics g){
}
public void result(String message,String d_fname,String d_lname,String d_age,String d_gender,String d_ph,String d_adhar,String d_address,String d_source,String d_dest,String d_dot,String d_doa,String d_tclass){
    Label detail = new Label ("Reservation Details");
    Label fname=new Label("FirstName :"+d_fname);
    Label lname = new Label ("LastName :"+d_lname);
    Label age = new Label ("Age :"+d_age);
    Label gender = new Label ("Gender :"+d_gender);
    Label ph =  new Label ("Phone No :"+d_ph);
    Label adhar = new Label ("Adhar No :"+d_adhar);
    Label address = new Label ("Address :"+d_address);
    Label source = new Label ("Source :"+d_source);
    Label Dest = new Label ("Destination :"+d_dest);
    Label trainClass = new Label ("Train_class :"+d_tclass);
    Label dot = new Label ("Date Of Travel :"+d_dot);
    Label doa = new Label ("Date Of Arrival :"+d_doa);
    detail.setBounds(980,30,300,20);
    fname.setBounds(1000,80,300,20);
    lname.setBounds(1000,120,300,20);
    age.setBounds(1000,160,300,20);
    gender.setBounds(1000,200,300,20);
    ph.setBounds(1000,240,300,20);
    adhar.setBounds(1000,280,300,20);
    address.setBounds(1000,320,300,20);
    source.setBounds(1000,360,300,20);
     Dest.setBounds(1000,400,300,20);
    trainClass.setBounds(1000,440,300,20);
    dot.setBounds(1000,480,300,20);
    doa.setBounds(1000,520,300,20);
    add(detail);
    add(fname);
    add(lname);
    add(age);
    add(gender);
    add(ph);
    add(adhar);
    add(address);
    add(source);
    add(Dest);
    add(trainClass);
    add(dot);
    add(doa); 
}
}