package it.uniclam.rilevamento_presenze.GraphicalUserInterface;
import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class LoginGUI extends JFrame {
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField nomeUtente;
	public JTextField password;
	public JPanel err_pan;

	
    private void setCenter(){
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2,dim.height/2-getSize().height/2);
	}
    
    public void closeBridge(){
    	this.setVisible(false);
    	this.dispose();
    }
    
	public LoginGUI(){

		setSize(280,150);
		setLocation(600,300);
		   
		setTitle("LogIn");
		toFront();
		   
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2,2));
	    
	    panel.add(new JLabel("NomeUtente"));
	    panel.add(nomeUtente = new JTextField(""));
	    
	    panel.add(new JLabel("PassWord"));
	    panel.add(password = new JPasswordField(""));
	    add(panel, BorderLayout.CENTER);
	    
	    JPanel buttonPanel = new JPanel();
	    JButton invia = new JButton("invia");
	    JButton recovery = new JButton("recupera");
	    MyListener list = new MyListener();
		invia.addMouseListener(list);
		SecondListener lis2 = new SecondListener();
		recovery.addMouseListener(lis2);
		add(buttonPanel, BorderLayout.SOUTH);
		
		buttonPanel.add(invia);
		buttonPanel.add(recovery);
	    err_pan = new JPanel();
        err_pan.add(new JLabel("ERRORE"));
        err_pan.setVisible(false);
        buttonPanel.add(err_pan);
        setCenter();	
}



class MyListener implements MouseListener {
 public MyListener (){
	 
 }

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		String input_name = nomeUtente.getText();
		String input_password = password.getText();

		//System.exit(0);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}


class SecondListener implements MouseListener {
 public SecondListener (){
	 
 }

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
}