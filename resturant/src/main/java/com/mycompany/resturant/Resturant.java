
package com.mycompany.resturant;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.logging.Logger;
import javax.print.PrintException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import  javax.swing.JRadioButton;
import  javax.swing.JTextArea;
import  javax.swing.JTextField;

public class Resturant extends JFrame{
    
    JLabel Customer,Name,Contact,Food,Drinks,Res;
    JTextField tcustomer,tname,tcontact;
    JComboBox c1,c2;
    JComboBox d1,d2;
    JTextArea area1;
    JButton reset,print,reciept;
    
    int total;
    
    Resturant(){
        
        Res = new JLabel("DOG RESTURANT");
        Res.setBounds(30, 15, 120, 30);
        
        Customer = new JLabel("Customer NO : ");
        Customer.setBounds(20, 50, 120, 30);
        
        Name = new JLabel("Name : ");
        Name.setBounds(20, 100, 120, 30);
        
        Contact = new JLabel("Contact : ");
        Contact.setBounds(20, 150, 120, 30);
        
        Food = new JLabel("Food :");
        Food.setBounds(20, 200, 120, 30);
        
        Drinks = new JLabel("Drinks : ");
        Drinks.setBounds(20, 250, 120, 30);
        
        
        //TF
        tcustomer = new JTextField();
        tcustomer.setBounds(150,50,200,30);
        
        tname = new JTextField();
        tname.setBounds(150,100,200,30);
        
        tcontact = new JTextField();
        tcontact.setBounds(150,150,200,30);
        
        //CBB
        String Foo[] = {"   ","Pizza","Pasta","Steak"};
        c1 = new JComboBox(Foo);
        c1.setBounds(150,200,120,30);
        
        String Dri[] = {"   ","Coke","Water","Juice","    "};
        c2 = new JComboBox(Dri);
        c2.setBounds(150,250,120,30);
        
        String FAmount[] = {"   ","1","2","3","4","5","6","7","8","9","10"};
        d1 = new JComboBox(FAmount);
        d1.setBounds(300,200,120,30);
        
        String DAmount[] = {"   ","1","2","3","4","5","6","7","8","9","10"};
        d2 = new JComboBox(DAmount);
        d2.setBounds(300,250,120,30);
        
        //TA
        area1 = new JTextArea();
        area1.setBounds(100,500,80,40);
        area1.setSize(260,260);
        
        //BT
        print = new JButton("print");
        print.setBounds(100,400,80,40);
        reset = new JButton("reset");
        reset.setBounds(200,400,80,40);
        reciept = new JButton("reciept");
        reciept.setBounds(300,400,80,40);
        
        
        getContentPane().add(area1);
        getContentPane().add(print);
        getContentPane().add(reset);
        getContentPane().add(reciept);
        
        getContentPane().add(Res);
        getContentPane().add(Customer);
        getContentPane().add(Name);
        getContentPane().add(Contact);
        getContentPane().add(Food);
        getContentPane().add(Drinks);
        
        getContentPane().add(tcustomer);
        getContentPane().add(tname);
        getContentPane().add(tcontact);
        
        getContentPane().add(c1);
        getContentPane().add(c2);

        getContentPane().add(d1);
        getContentPane().add(d2);
        
        setLayout(null);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,1000);
//        getContentPane().setBackground(Color.YELLOW);
        
        
        
        reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tname.setText("");
                tcontact.setText("");
                tcustomer.setText("");
            }
        });
        
        print.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    area1.print();
                }
                catch(PrinterException ex){
                    System.out.println(ex.getMessage());
                }
            }
        });
        
        
        if(c1.getSelectedItem() == "Pizza"){
            int p = 299;
            total =Integer.parseInt((String)c1.getSelectedItem());
            for(int i = 0 ;i < total ;i++){
                total = p*total;
            }
//            return total;
        }
        
        reciept.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                area1.setText("Customer Name : "+tname.getText()+"\nCustomer Contact : "+tcontact.getText());
                area1.setText(area1.getText()+"\nFoods : \n"+c1.getSelectedItem()+"                       "+d1.getSelectedItem()+"                      "+total);
                area1.setText(area1.getText()+"\nDrinks : \n"+c2.getSelectedItem()+"                      "+d2.getSelectedItem());
            }
        });
        

    }
    
    public static void main(String[] args) {
        new Resturant();
        
    }
}
