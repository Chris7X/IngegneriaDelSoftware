package it.uniclam.rilevamento_presenze;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by Chriz 7X on 16/11/2015.
 */
public class UtenteGUI extends JFrame implements ActionListener {

    JPanel panel;
    JTextField NewMsg;
    //Obj Cognome
    JTextField TextBoxSELECT;
    String String_SELECT="SELECT SEND";
    JLabel LabelSELECT;
    JButton ButtonSELECT;

    //Obj Cognome
    JTextField TextBoxCognome;
    String String_Cognome="C1";
    JLabel LabelCognome;
    JButton ButtonCognome;

    //Obj Nome
    JTextField TextBoxNome;
    String String_Nome="N1";
    JLabel LabelNome;
    JButton ButtonNome;

    //Obj Tel.
    JTextField TextBoxTelefono;
    String String_Telefono="3T1";
    JLabel LabelTelefono;
    JButton ButtonTelefono;


    public UtenteGUI() throws UnknownHostException, IOException{
        TextBoxSELECT=new JTextField();
        LabelSELECT=new JLabel();
        ButtonSELECT=new JButton();
        panel = new JPanel();
        NewMsg = new JTextField();
        TextBoxCognome=new JTextField();
        LabelCognome=new JLabel();
        ButtonCognome=new JButton();

        TextBoxNome=new JTextField();
        LabelNome=new JLabel();
        ButtonNome=new JButton();

        TextBoxTelefono=new JTextField();
        LabelTelefono=new JLabel();
        ButtonTelefono=new JButton();



        //1°FRAME
        this.setSize(1024,1024 );
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(null);
        this.add(panel);
        //OBJ BUTTON SELECT
        ButtonSELECT.setBounds(200,525,100, 30);
        panel.add(ButtonSELECT);
        ButtonSELECT.setText("Salva & Nuovo");
        //ButtonSELECT.setEnabled(false);
        ButtonSELECT.addActionListener(this);

        /*OBJ's COGNOME*/
        TextBoxCognome.setBounds(70, 15, 100, 30);//(x,y,larghezza,altezza)
        panel.add(TextBoxCognome);
        TextBoxCognome.setText("dd");
        LabelCognome.setBounds(5,15,100,30);//(x,y,larghezza,altezza)
        panel.add(LabelCognome);
        LabelCognome.setText("COGNOME:");

        /*OBJ's COGNOME*/
        TextBoxNome.setBounds(70, 45, 100, 30);//(x,y,larghezza,altezza)
        panel.add(TextBoxNome);
        TextBoxNome.setText("");
        LabelNome.setBounds(5,45,100,30);//(x,y,larghezza,altezza)
        panel.add(LabelNome);
        LabelNome.setText("NOME:");

        /*OBJ's TELEFONO*/
        ButtonTelefono.setBounds(200,75,100, 30);
        panel.add(ButtonTelefono);
        ButtonTelefono.setEnabled(false);
        ButtonTelefono.setText("SEARCH");
        ButtonTelefono.addActionListener(this);
        TextBoxTelefono.setBounds(70, 75, 100, 30);//(x,y,larghezza,altezza)
        panel.add(TextBoxTelefono);
        TextBoxTelefono.setText("");
        LabelTelefono.setBounds(5,75,100,30);//(x,y,larghezza,altezza)
        panel.add(LabelTelefono);
        LabelTelefono.setText("TELEFONO:");

        this.setTitle("Anagrafica");

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==ButtonSELECT){
            UtenteJDBCDAO amicoDB=new UtenteJDBCDAO();
            UtenteBean amicoClass=new UtenteBean();


            amicoClass.setCognome(TextBoxCognome.getText());
            amicoClass.setNome(TextBoxNome.getText());
            amicoClass.setTelefono(TextBoxTelefono.getText());

            //EMAIL mancante
            amicoDB.findAll();

            amicoDB.add1(amicoClass);

        }

    }

    public static void main(String[] args) throws UnknownHostException,
            IOException {
        UtenteGUI user=new UtenteGUI();
        user.setVisible(true);
        user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       /* AmicoJDBCDAO amicoDB=new AmicoJDBCDAO();
        AmicoBean amicoClass=new AmicoBean();
        Scanner sc = new Scanner(System.in);

        System.out.print("Premi invio per continuare. ");
        sc.nextLine();
        amicoClass.setCognome(user.TextBoxCognome.getText());
        amicoClass.setNome(user.TextBoxNome.getText());
        amicoClass.setTelefono(user.TextBoxTelefono.getText());
        //EMAIL mancante

        amicoDB.add(amicoClass);

        amicoDB.findAll();*/





    }
}
