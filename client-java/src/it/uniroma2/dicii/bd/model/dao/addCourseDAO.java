package it.uniroma2.dicii.bd.model.dao;

import it.uniroma2.dicii.bd.exception.DAOException;
import it.uniroma2.dicii.bd.model.domain.Course;

import java.math.BigDecimal;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class addCourseDAO implements GenericProcedureDAO<Course> { //Utilizzo il design pattern Singleton per maggior controllo dell'accesso a risorse condivise

    private static addCourseDAO instance = null; //Uso per mantenere istanza della classe singleton privata e statica

    private addCourseDAO() {
    } //Costruttore privato

    public static addCourseDAO getInstance() {
        if (instance == null) {
            instance = new addCourseDAO();
        }
        return instance;
    }

    //Aggiungo corso
    @Override
    public Course execute(Object... params) throws DAOException{
        String nomeCorso = (String) params[0];
        Integer minPart = (Integer) params[1];
        Integer maxPart = (Integer) params[2];
        Integer idVasca = (Integer) params[3];
        Date dataInizioCorso = (Date) params[4];
        BigDecimal prezzo = (BigDecimal) params[5];

        //Creo per andare a memorizzare l'idCorso di ritorno(auto increment id) e per memorizzare il mio nuovo corso
        int idCorso;
        Course Corso;
        Connection conn = null;
        CallableStatement cs = null;


        try {
            conn = ConnectionFactory.getConnection();
            cs = conn.prepareCall("{call (inserisci_corso(?,?,?,?,?,?,?))}"); //Vado ad impostare i parametri della chiamata al database
            cs.setString(1, nomeCorso);
            cs.setInt(2, minPart);
            cs.setInt(3, maxPart);
            cs.setDate(6, dataInizioCorso);
            cs.setInt(4, idVasca);
            cs.setBigDecimal(5, prezzo);
            cs.registerOutParameter(7, Types.INTEGER); //Riprendo valore di ritorno
            cs.executeQuery(); //Eseguo chiamata
            idCorso = cs.getInt(7);

        } catch (SQLException e) { //Gestione errore
            throw new DAOException("Errore nell'aggiunta del corso: " + e.getMessage());
        }
        //Eseguo il blocco finally
        finally {
            try {
                //Chiude lo statement della stored procedure
                if (cs != null) {
                    cs.close();
                }

                //Vado a chiudere la connessione al database
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) { //Gestione errore
                throw new DAOException("Errore nell'aggiunta del corso: " + e.getMessage());
            }
        }
        //Creo il nuovo corso
        Corso = new Course(nomeCorso, minPart, maxPart, idVasca, dataInizioCorso, prezzo);
        //Imposto l'id al corso
        Corso.setID_Corso(idCorso);
        return Corso;
    }
}
