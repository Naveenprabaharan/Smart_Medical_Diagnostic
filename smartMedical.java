import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/*

/*
<applet code="train.class" width="1500" height="1500"></applet>
*/
public class smartMedical extends Applet implements ActionListener {
    TextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12;
    Button submit;
    Choice ch1;

    public void init() {
        setBackground(Color.green);
        Label topicname = new Label("SMART MEDICAL DIAGNOSTIC SYSTEM");
        Label personal = new Label("PERSONAL DETAILS ");
        Label booking = new Label("DIAGNOSTIC DETAILS ");

        Label firstname = new Label("FIRSTNAME");
        tf1 = new TextField();

        Label lastname = new Label("LASTNAME");
        tf2 = new TextField();

        Label age = new Label("AGE");
        tf3 = new TextField();

        Label gender = new Label("GENDER");
        tf4 = new TextField();
        ch1 = new Choice();
        ch1.add("male");
        ch1.add("female");
        ch1.add("transgender");

        Label phonenumber = new Label("PHONENUMBER");
        tf5 = new TextField();

        Label aadhar = new Label("AADHARNUMBER");
        tf6 = new TextField();

        Label address = new Label("ADDRESS");
        tf7 = new TextField();

        Label CheckingInfo = new Label("DIAGNOSTIC INFO");
        tf8 = new TextField();

        Label dateoftravel = new Label("CHECKUP DATE");
        tf10 = new TextField();

        Label dateofarrival = new Label("NEXT CHECKUP DATE");
        tf11 = new TextField();

        submit = new Button("SUBMIT");
        submit.setBackground(Color.red);

        setLayout(null);

        topicname.setBounds(350, 5, 200, 30);
        personal.setBounds(350, 45, 200, 30);
        booking.setBounds(350, 240, 200, 30);

        firstname.setBounds(50, 80, 120, 30);
        tf1.setBounds(200, 85, 120, 20);

        lastname.setBounds(50, 110, 120, 30);
        tf2.setBounds(200, 115, 120, 20);

        age.setBounds(50, 140, 120, 30);
        tf3.setBounds(200, 145, 120, 20);

        gender.setBounds(50, 170, 120, 30);
        ch1.setBounds(200, 175, 120, 30);

        phonenumber.setBounds(50, 200, 120, 30);
        tf5.setBounds(200, 205, 120, 20);

        aadhar.setBounds(500, 80, 120, 30);
        tf6.setBounds(650, 85, 120, 20);

        address.setBounds(500, 110, 120, 30);
        tf7.setBounds(650, 115, 160, 70);

        CheckingInfo.setBounds(50, 270, 120, 30);
        tf8.setBounds(200, 275, 150, 80);

        dateoftravel.setBounds(500, 270, 120, 30);
        tf10.setBounds(650, 275, 170, 20);

        dateofarrival.setBounds(500, 300, 150, 30);
        tf11.setBounds(650, 305, 170, 20);

        submit.setBounds(350, 450, 120, 40);

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
        add(CheckingInfo);
        add(dateoftravel);
        add(dateofarrival);
        add(tf1);
        add(tf2);
        add(tf3);
        add(tf4);
        add(tf5);
        add(tf6);
        add(tf7);
        add(tf8);
        add(tf10);
        add(tf11);
        add(ch1);
        add(submit);
        Add_ActionListener();
        setFont(new Font("Elephant", Font.PLAIN, 14));
    }

    public void actionPerformed(ActionEvent ae) {
        String d_fname = tf1.getText(), d_lname = tf2.getText(), d_age = tf3.getText(),
                d_gender = ch1.getItem(ch1.getSelectedIndex()), d_ph = tf5.getText(), d_adhar = tf6.getText(),
                d_address = tf7.getText(), d_dot = tf10.getText(), d_doa = tf11.getText(),
                d_CheckingInfo = tf8.getText();

        String message = ae.getActionCommand();

        database(message, d_fname, d_lname, d_age, d_gender, d_ph, d_adhar, d_address, d_CheckingInfo, d_dot, d_doa);
        repaint();
    }

    public void database(String message, String d_fname, String d_lname, String d_age, String d_gender, String d_ph,
            String d_adhar, String d_address, String d_CheckingInfo, String d_dot, String d_doa) {
        String url = "jdbc:mysql://localhost:3306/chINfo";
        String uname = "root";
        String pass = "sqlroot";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Train.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "insert into chINfo values(?,?,?,?,?,?,?,?,?,?)";

        try (Connection con = DriverManager.getConnection(url, uname, pass)) {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, d_fname.toUpperCase().trim());
            st.setString(2, d_lname.toUpperCase().trim());
            st.setString(3, d_age.toUpperCase().trim());
            st.setString(4, d_gender);
            st.setString(5, d_ph.toUpperCase().trim());
            st.setString(6, d_adhar.toUpperCase().trim());
            st.setString(7, d_address.toUpperCase().trim());
            st.setString(8, d_CheckingInfo);
            st.setString(9, d_dot.toUpperCase().trim());
            st.setString(10, d_doa.toUpperCase().trim());

            int count = st.executeUpdate();
            // result(message,d_fname,d_lname,d_age,d_gender,d_ph,d_adhar,d_address,d_source,d_dest,d_dot,d_doa,d_tclass);
            JOptionPane.showMessageDialog(null, "Reservation Successfully!");

            st.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void Add_ActionListener() {
        tf1.addActionListener(this);
        tf2.addActionListener(this);
        tf3.addActionListener(this);
        tf4.addActionListener(this);
        tf5.addActionListener(this);
        tf6.addActionListener(this);
        tf7.addActionListener(this);
        tf8.addActionListener(this);
        tf10.addActionListener(this);
        tf11.addActionListener(this);
        submit.addActionListener(this);
    }

    public void paint(Graphics g) {
    }

}