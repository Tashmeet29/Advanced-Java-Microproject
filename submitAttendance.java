Package attend;
Import java.util.*;
Import javax.swing.*;
Import java.awt.*;
Import java.awt.event.*;
Import java.sql.*;

Public class submitAttendance implements ActionListener
{

JFrame f4;
JLabel l, l1, l2, l3, l4, l5, l6, l7, l8, l9;
JRadioButton r;
JButton b1, b2, b3;
String id=””, name=””, email=””, contact=””;
Static String status= “”;
PreparedStatement ps;
ResultSet rs;
Connection co;

submitAttendance()
{
Try
{

Class.forName(“oracle.jdbc.driver.OracleDriver”);

Co=DriverManager.getConnection(“jdbc:oracle:thin:@localhost
:1521:ORCL”, “system”, “Tashmeet05”);

Id= attend.loginStudent.id;

Ps= co.prepareStatement(“select * from login_test

where user_id= ?”);

Ps.setString(1, id);
Rs= ps.executeQuery();
While(rs.next())

{
Id= rs.getString(1);
Name= rs.getString(2);
Email= rs.getString(5);
Contact= rs.getString(4);
Status= rs.getString(7);
}

F4= new JFrame(“submit Attendance”);
L= new JLabel(“Attendance”);
l.setFont(new Font(“Serif”, Font.BOLD, 60));
l1= new JLabel(“ID”);
l1.setFont(new Font(“Serif”, Font.BOLD, 30));
l2= new JLabel(“Name”);
l2.setFont(new Font(“Serif”, Font.BOLD, 30));
l3= new JLabel(“Email”);
l3.setFont(new Font(“Serif”, Font.BOLD, 30));
l4= new JLabel(“Contact No.”);
l4.setFont(new Font(“Serif”, Font.BOLD, 30));
l5= new JLabel(“Attendance”);
l5.setFont(new Font(“Serif”, Font.BOLD, 30));
l6= new JLabel();
l6.setText(id);
l6.setFont(new Font(“Serif”, Font.BOLD, 25));
l7= new JLabel();
l7.setText(name);

l7.setFont(new Font(“Serif”, Font.BOLD, 25));
l8= new JLabel();
l8.setText(email);
l8.setFont(new Font(“Serif”, Font.BOLD, 25));
l9= new JLabel();
l9.setText(contact);
l9.setFont(new Font(“Serif”, Font.BOLD, 25));
r= new JRadioButton();
b1= new JButton(“Submit”);
b2= new JButton(“Check Attendance”);
b3= new JButton(“Back”);

l.setBounds(730, 100, 600, 60);
l1.setBounds(720, 200, 150, 40);
l2.setBounds(720, 260, 150, 40);
l3.setBounds(720, 320, 150, 40);
l4.setBounds(720, 380, 170, 40);
l5.setBounds(720, 440, 150, 40);
l6.setBounds(1000, 200, 150, 40);
l7.setBounds(1000, 260, 250, 40);
l8.setBounds(1000, 320, 400, 40);
l9.setBounds(1000, 380, 200, 40);
r.setBounds(1000, 440, 150, 40);
b1.setBounds(700, 520, 200, 40);
b2.setBounds(940, 520, 200, 40);
b3.setBounds(850, 580, 200, 40);

f4.setLayout(null);
f4.add(l);
f4.add(l1);
f4.add(l2);
f4.add(l3);
f4.add(l4);
f4.add(l5);
f4.add(l6);
f4.add(l7);
f4.add(l8);
f4.add(l9);
f4.add®;
f4.add(b1);
f4.add(b2);
f4.add(b3);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
f4.setSize(1800, 1000);
f4.setVisible(true);

if(status.equals(“absent”))
{

r.setText(“Absent”);
r.setFont(new Font(“Serif”, Font.BOLD, 25));
}
Else
{
r.setText(“Present”);
r.setFont(new Font(“Serif”, Font.BOLD, 25));
}

}catch(Exception ee)
{
System .out.println(“Exception : “+ee);
}
}

Public void actionPerformed(ActionEvent e)
{
If(e.getSource()== b1)
{
Int count=0;

Try
{
If(r.isSelected())
{

If(status.equals(“absent”))
{
r.setText(“Present”);
status= “present”;

ps= co.prepareStatement(“update

login_test set status=? Where user_id=?”);

ps.setString(1, status);
ps.setString(2, id);
ps.executeUpdate();

JOptionPane.showMessageDialog(f4, “You attendance is
successfully updated as Present”, “Status”,
JOptionPane.INFORMATION_MESSAGE);

}
Else if(status.equals(“present”))
{

JOptionPane.showMessageDialog(f4, “You already submitted
attendance”, “Status”, JOptionPane.INFORMATION_MESSAGE);

}

}
Else
{

JOptionPane.showMessageDialog(f4, “Your attendance is not
Updated, please click the attendence button”, “Status”,
JOptionPane.INFORMATION_MESSAGE);

}
}
Catch(Exception ee)
{
System .out.println(“Exception : “+ee);
}
}
Else if(e.getSource()== b2)
{
F4.setVisible(false);
New checkAttendance();
}
Else if(e.getSource()== b3)
{
F4.setVisible(false);
New loginStudent();
}
}
Public static void main(String[] args) {
New submitAttendance();
}
}
