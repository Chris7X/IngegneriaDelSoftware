package it.uniclam.rilevamento_presenze.GraphicalUserInterface;



import it.uniclam.rilevamento_presenze.JDBCDataAccessObject.EventJDBCDAO;
import it.uniclam.rilevamento_presenze.JDBCDataAccessObject.UtenteJDBCDAO;
import it.uniclam.rilevamento_presenze.BeanClass.UtenteBean;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by Chriz 7X on 16/11/2015.
 */
public class UtenteGUI extends JFrame implements ActionListener {

    boolean state_TrueFalse;
    int Return_ID_User;
    int Count;

    JPanel panel;
    JTextField NewMsg;
    //Obj Button IN
    JTextField TextBoxBADGE_IN;
    String String_BADGE_IN="BADGE_IN SEND";
    JLabel LabelBADGE_IN;
    JButton ButtonBADGE_IN;

    //Obj Button IN
    JTextField TextBoxBADGE_OUT;
    String String_BADGE_OUT="BADGE_OUT SEND";
    JLabel LabelBADGE_OUT;
    JButton ButtonBADGE_OUT;

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

    //Obj CodiceUtente.
    JTextField TextBoxCodice;
    String String_Codice="3T1";
    JLabel LabelCodice;
    JButton ButtonCodice;

    //OBJ CurrentTime


    ////////////////JTEXT FILED START///////////////////////////



    ////////////////JTEXT FILED END///////////////////////////


    private Thread start;

    public UtenteGUI() throws UnknownHostException, IOException{
        TextBoxBADGE_IN=new JTextField();
        LabelBADGE_IN=new JLabel();
        ButtonBADGE_IN=new JButton();
        TextBoxBADGE_OUT=new JTextField();
        LabelBADGE_OUT=new JLabel();
        ButtonBADGE_OUT=new JButton();
        panel = new JPanel();
        NewMsg = new JTextField();
        TextBoxCognome=new JTextField();
        LabelCognome=new JLabel();
        ButtonCognome=new JButton();

        TextBoxNome=new JTextField();
        LabelNome=new JLabel();
        ButtonNome=new JButton();

        TextBoxCodice=new JTextField();
        LabelCodice=new JLabel();
        ButtonCodice=new JButton();



        //1°FRAME
        this.setSize(250,250 );
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(null);
        this.add(panel);
        //OBJ BUTTON BADGE_OUT
        ButtonBADGE_IN.setBounds(20,125,100, 30);
        panel.add(ButtonBADGE_IN);
        ButtonBADGE_IN.setText("↑ IN ↑");
        //ButtonBADGE_IN.setEnabled(false);
        ButtonBADGE_IN.addActionListener(this);

        //OBJ BUTTON BADGE_OUT
        ButtonBADGE_OUT.setBounds(125,125,100, 30);
        panel.add(ButtonBADGE_OUT);
        ButtonBADGE_OUT.setText("↓ OUT ↓");
        //ButtonBADGE_OUT.setEnabled(false);
        ButtonBADGE_OUT.addActionListener(this);

        /*OBJ's COGNOME*/
        TextBoxCognome.setBounds(70, 15, 100, 30);//(x,y,larghezza,altezza)
        panel.add(TextBoxCognome);
        TextBoxCognome.setText("CognomeText");
        LabelCognome.setBounds(5,15,100,30);//(x,y,larghezza,altezza)
        panel.add(LabelCognome);
        LabelCognome.setText("COGNOME:");

        /*OBJ's COGNOME*/
        TextBoxNome.setBounds(70, 45, 100, 30);//(x,y,larghezza,altezza)
        panel.add(TextBoxNome);
        TextBoxNome.setText("Nometext");
        LabelNome.setBounds(5,45,100,30);//(x,y,larghezza,altezza)
        panel.add(LabelNome);
        LabelNome.setText("NOME:");

        /*OBJ's TELEFONO*/

        TextBoxCodice.setBounds(70, 75, 100, 30);//(x,y,larghezza,altezza)
        panel.add(TextBoxCodice);
        TextBoxCodice.setText("CodiceID");
        LabelCodice.setBounds(5,75,100,30);//(x,y,larghezza,altezza)
        panel.add(LabelCodice);
        LabelCodice.setText("CODICE:");


        //OBJ OROLOGIO////////////////





        ///////////////////

        this.setTitle("Rilevazione Presenze");
        
        ///////////////////////////////


    }



    @Override
    public void actionPerformed(ActionEvent e) {
        UtenteJDBCDAO amicoDB=new UtenteJDBCDAO();
        UtenteBean amicoClass=new UtenteBean();
        EventJDBCDAO eventDB=new EventJDBCDAO();
        if (e.getSource()==ButtonBADGE_IN){



          //  amicoClass.setCognome(TextBoxCognome.getText());
            //amicoClass.setNome(TextBoxNome.getText());
          //  amicoClass.setCodice(TextBoxCodice.getText());

            //EMAIL mancante
           // amicoDB.findAll();
/*OK //state_TrueFalse=amicoDB.SELECT_NameSurname(TextBoxNome.getText(),TextBoxCognome.getText(),TextBoxCodice.getText());
           // amicoDB.add1(amicoClass);
            if (state_TrueFalse==true) {
                System.out.println("True");//QUERY.ADD

            }
            else {System.out.println("False");}*/
            Return_ID_User=amicoDB.SELECT_NameSurname(TextBoxNome.getText(),TextBoxCognome.getText(),TextBoxCodice.getText());
            // amicoDB.add1(amicoClass);
            if (Return_ID_User!=0) {



                eventDB.SELECT_OrderDate(Return_ID_User);


                System.out.println("TrueEseguito?");//QUERY.ADD
                System.out.println(Return_ID_User);
                int CountEvent_IN_OUT=eventDB.SELECT_CountEvent(Return_ID_User);//Verifica quanti eventi vi sono stati per quell'utente qyel giorno
System.out.println(CountEvent_IN_OUT+"GUIUser");
                if(CountEvent_IN_OUT<2)
                {
                eventDB.addEventIN(Return_ID_User, 1);}
                else {System.out.println("Dipendente non INSERITO nel DB");}
                TextBoxNome.setText(" ");
                TextBoxCognome.setText(" ");
                TextBoxCodice.setText(" ");


            }
            else {System.out.println("False");
                System.out.println(Return_ID_User);}
        }
        if (e.getSource()==ButtonBADGE_OUT){
            //Controllo che prima dell'inserimento ,il dipendente sia presente nel DB
            Return_ID_User=amicoDB.SELECT_NameSurname(TextBoxNome.getText(),TextBoxCognome.getText(),TextBoxCodice.getText());
            if (Return_ID_User!=0) {
                int CountEvent_IN_OUT=eventDB.SELECT_CountEvent(Return_ID_User);//Verifica quanti eventi vi sono stati per quell'utente qyel giorno
                System.out.println(CountEvent_IN_OUT + "GUIUser");
                if(CountEvent_IN_OUT<2)
                {
                    eventDB.addEventOUT(Return_ID_User);}
                else {System.out.println("Dipendente non INSERITO nel DB");}

            }
        }

    }


    public static void main(String[] args) throws UnknownHostException,
            IOException {
        UtenteGUI user=new UtenteGUI();
        user.setVisible(true);
Orologio.main(args);
        user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       /* AmicoJDBCDAO amicoDB=new AmicoJDBCDAO();
        AmicoBean amicoClass=new AmicoBean();
        Scanner sc = new Scanner(System.in);

        System.out.print("Premi invio per continuare. ");
        sc.nextLine();
        amicoClass.setCognome(user.TextBoxCognome.getText());
        amicoClass.setNome(user.TextBoxNome.getText());
        amicoClass.setCodice(user.TextBoxCodice.getText());
        //EMAIL mancante

        amicoDB.add(amicoClass);

        amicoDB.findAll();*/





    }


}
