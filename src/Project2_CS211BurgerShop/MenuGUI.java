package Project2_CS211BurgerShop;

// Created by Taesik Kim for the practice of CS 211 project

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class MenuGUI {
	
   static final int W=800,H=600;//width and height of JFrame
   private JFrame f; 
   private JPanel p;
   private JLabel title,b1,b2,b3,topping1,topping2,topping3,rate;
   private String menuTitle;
   
   String pr;
   int x=W+50, y=17;  // coordinate of promotion display
   
   String myFranchise ="";      
   ImagePanel imagePanel1;
   ImagePanel imagePanel2;
   ImagePanel imagePanel3;
   
    MenuGUI(String myFranchise,String promotion,String name1,String price1,String top1, String name2,String price2,String top2,String name3,String price3,String top3, double exchangeRate, double temperature){
		 SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");  
		    Date date = new Date();  
		    String d= formatter.format(date);
		    
    pr=promotion;
    
	f=new JFrame(myFranchise);
	f.setSize(W+100, H);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setAlwaysOnTop(true);
	
	p=new JPanel();  
	
    menuTitle="                  Burger211 - "+ myFranchise ;
	title=new JLabel(menuTitle);
	title.setFont(new Font("Serif", Font.PLAIN, 40));
    title.setForeground(Color.RED);
	title.setBounds(80,0,W,H/6);
         
    b1=new JLabel(name1+"/ "+price1);
	b1.setFont(new Font("Serif", Font.PLAIN, 30));
	b1.setBounds(200,105,W,H/6);
    
    b2=new JLabel(name2+"/ "+price2);
	b2.setFont(new Font("Serif", Font.PLAIN, 30));
	b2.setBounds(200,240,W,H/6);
    
    b3=new JLabel(name3+"/ "+price3);
	b3.setFont(new Font("Serif", Font.PLAIN, 30));
	b3.setBounds(200,370,W,H/6);
	p.setLayout(null);
    
    topping1 = new JLabel(top1);
    topping1.setBounds(200, 167, 800,50);
    topping1.setForeground(Color.RED);
	topping1.setFont(new Font("Serif", Font.ITALIC, 27));
   
    topping2 = new JLabel(top2);
    topping2.setBounds(200, 300, 800,50);
    topping2.setForeground(Color.RED);
	topping2.setFont(new Font("Serif", Font.ITALIC, 27));

    topping3 = new JLabel(top3);
    topping3.setBounds(200, 430, 800,50);
    topping3.setForeground(Color.RED);
	topping3.setFont(new Font("Serif", Font.ITALIC, 27));

	rate = new JLabel("Exchange Rate: 1:"+String.format("%.1f",exchangeRate) + " Degree:"+ String.format("%.1f", temperature)+"\u00B0"+"F" + " (As of "+d+")");

	rate.setBounds(W-600, H-100, 600,40);
	rate.setForeground(Color.BLACK);
	rate.setFont(new Font("Serif", Font.ITALIC, 18));
    
  // Images
    imagePanel1 = new ImagePanel("Burger1.png");
    imagePanel2 = new ImagePanel("Burger2.png");
    imagePanel3 = new ImagePanel("Burger3.png"); 
    
    imagePanel1.setBounds(50,120,150,100);
    imagePanel2.setBounds(50,250,150,100);
    imagePanel3.setBounds(50,380,150,100);
  
	f.add(imagePanel1);
    f.add(imagePanel2);
    f.add(imagePanel3); 
    
    PromotionPanel promotionPanel= new PromotionPanel();
    promotionPanel.setBounds(50,80, W-10,30);
    f.add(promotionPanel);
    
	p.add(title);
	p.add(b1);
	p.add(b2);
	p.add(b3);
    p.add(topping1);
    p.add(topping2);
    p.add(topping3);
    p.add(rate); 
	f.add(p); 
 	f.setVisible(true);	
  }

class ImagePanel extends JPanel {

    Image img;
    public void paintComponent(Graphics g) {
       super.paintComponent(g);
       g.drawImage(img, 0, 0, null);    
    }
    public ImagePanel(Image img) {
       this.img = img;
       Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));      
       setPreferredSize(size);
       setMinimumSize(size);
       setMaximumSize(size);
       setSize(size);
       setLayout(null);}
     
      public ImagePanel(String img) {
      this(new ImageIcon(img).getImage());}
 }

 class PromotionPanel extends JPanel {
    public void paintComponent(Graphics g) {
    super.paintComponent(g);  
    g.drawRect(0,0,W,25);  
    g.setColor(Color.RED);  
    g.fillRect(0,0,W,25);  
    g.setFont(new Font("Serif", Font.ITALIC, 23));
    g.setColor(Color.WHITE); 
    x-=1;
    int length=pr.length();
    if (x<-(length*8)) {x=W+50;}
    g.drawString(pr, x, y+2);   
    try{
        Thread.sleep(5);  // if the text is moving too past/slow, modify here. 2 meant 2 millisecond delayed. 1000 = 1 second
      } catch (Exception exc){}   
     repaint();
    }
 
  }
 }