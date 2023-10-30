Package attend;

Import java.util.*;

Import java.util.regex.Matcher;

Import java.util.regex.Pattern;

Import javax.swing.*;

Import java.awt.*;

Import java.awt.event.*;

Import java.sql.*;

Public class addStudent implements ActionListener

{

JFrame f2;

JLabel l, l1, l2, l3, l4, l5;

JTextField t1, t2, t3, t4, t5;

JButton b1, b2;

String name=””, password=””, contact=””, email=””,
address=””;

PreparedStatement ps;

ResultSet rs;

Connection co;

addStudent()

{

Try

{

F2= new JFrame(“Main Page”);

L= new JLabel(“Add Student”);

l.setFont(new Font(“Serif”, Font.BOLD, 60));

l1= new JLabel(“Name”);

l1.setFont(new Font(“Serif”, Font.BOLD, 25));

l2= new JLabel(“Password”);

l2.setFont(new Font(“Serif”, Font.BOLD, 25));

l3= new JLabel(“Contact”);

l3.setFont(new Font(“Serif”, Font.BOLD, 25));

l4= new JLabel(“Email”);

l4.setFont(new Font(“Serif”, Font.BOLD, 25));

l5= new JLabel(“Address”);

l5.setFont(new Font(“Serif”, Font.BOLD, 25));

t1= new JTextField();

t2= new JTextField();

t3= new JTextField();

t4= new JTextField();

t5= new JTextField();

b1= new JButton(“Add”);

b2= new JButton(“Back”);

l.setBounds(760, 100, 600, 60);

l1.setBounds(750, 200, 150, 40);

l2.setBounds(750, 260, 150, 40);

l3.setBounds(750, 320, 150, 40);
l4.setBounds(750, 380, 150, 40);
l5.setBounds(750, 440, 150, 40);

t1.setBounds(950, 200, 150, 40);
t2.setBounds(950, 260, 150, 40);
t3.setBounds(950, 320, 150, 40);
t4.setBounds(950, 380, 150, 40);
t5.setBounds(950, 440, 150, 40);
b1.setBounds(700, 520, 200, 40);
b2.setBounds(940, 520, 200, 40);
f2.setLayout(null);

f2.add(l);
f2.add(l1);
f2.add(l2);
f2.add(l3);
f2.add(l4);
f2.add(l5);
f2.add(t1);
f2.add(t2);
f2.add(t3);
f2.add(t4);
f2.add(t5);
f2.add(b1);
f2.add(b2);

b1.addActionListener(this);
b2.addActionListener(this);
f2.setSize(1800, 1000);

f2.setVisible(true);
Class.forName(“oracle.jdbc.driver.OracleDriver”);
Co=DriverManager.getConnection(“jdbc:oracle:thin:@localhost
:1521:ORCL”, “system”, “Tashmeet05”);

}catch(Exception ee)

{ System .out.println(“Exception : “+ee);}
}
Public void actionPerformed(ActionEvent e)
{
If(e.getSource()== b1)
{
Try
{
Name= t1.getText();
Password= t2.getText();
Contact= t3.getText();
Email= t4.getText();
Address= t5.getText();

String email_regex= “^[a-zA-Z0-9_+&*-]+(?:\\.” + “[a-zA-Z0-
9_+&*-]+)*@” + “(?:[a-zA-Z0-9-]+\\.)+[a-z” + “A-Z]{2,7}$”;
Pattern pt= Pattern.compile(email_regex);
If(!pt.matcher(email).matches())

{

JOptionPane.showMessageDialog(f2,

“Enter valid Email”, “Incorrect Email”,
JOptionPane.ERROR_MESSAGE);

}

Else if(name== “” || password== “” || contact== “” || email== “” ||
address== “”)
{
JOptionPane.showMessageDialog(f2, “Enter All Entries”, “Empty
Entry”, JOptionPane.INFORMATION_MESSAGE);

}

Else

{

Int count=0;

Ps= co.prepareStatement(“select count(*)

from login_test where password=? Or email=?”);

Ps.setString(1, password);

Ps.setString(2, email);

Rs= ps.executeQuery();

While(rs.next()){

Count= rs.getInt(1);

}

If(count != 0)

{

JOptionPane.showMessageDialog(f2, “Please try another email
or password”, “Invalid Entry”,
JOptionPane.INFORMATION_MESSAGE);

}

Else

{

Ps= co.prepareStatement(“insert into
login_test(user_name, password, contact, email, address, status)
values(?, ?, ?, ?, ?, ?)”);

Ps.setString(1, name);
Ps.setString(2, password);

Ps.setString(3, contact);
Ps.setString(4, email);
Ps.setString(5, address);
Ps.setString(6, “absent”);
Ps.executeUpdate();
Ps.close();

Ps= co.prepareStatement(“select * from login_test where
password= ?”);

Ps.setString(1, password);
Rs= ps.executeQuery();

Int s=0;

While(rs.next()){
S = rs.getInt(1);
}
JOptionPane.showMessageDialog(f2, “you successfully added and
your ID is “+s, “Student Added”,
JOptionPane.INFORMATION_MESSAGE);
New mainPage();
}
}
}catch(Exception ee)

{

JOptionPane.showMessageDialog(f2, “Enter
Valid Entries “, “Invalid Entry”, JOptionPane.ERROR_MESSAGE);
}
}

Else if(e.getSource()== b2)
{
F2.setVisible(false);
New mainPage();
}
}
Public static void main(String[] args) {
New addStudent();
}

}
