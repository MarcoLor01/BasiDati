package it.uniroma2.dicii.bd.controller;

import it.uniroma2.dicii.bd.domain.ListaCorsi;
import it.uniroma2.dicii.bd.exception.DAOException;
import it.uniroma2.dicii.bd.model.dao.ConnectionFactory;
import it.uniroma2.dicii.bd.model.dao.addCourseDAO;
import it.uniroma2.dicii.bd.model.domain.Course;
import it.uniroma2.dicii.bd.model.domain.Role;
import it.uniroma2.dicii.bd.view.SegreteriaView;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class SegreteriaController implements Controller{
    @Override
    public void start() {
        try {
            ConnectionFactory.changeRole(Role.SEGRETERIA);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

        while(true) {
            int choice;
            try {
                choice = SegreteriaView.showMenu();
            } catch(IOException e) {
                throw new RuntimeException(e);
            }

            switch(choice) {
                case 1 -> RegistraIscrizione();
                case 2 -> RegistraIngresso();
                case 3 -> RegistraCorso();
                case 4 -> RegistraVasca();
                case 5 -> RegistraLezione();
                case 6 -> EliminaLezione();
                case 7 -> VisualizzaCorsiDisponibili();
                case 8 -> ReportUtenti();
                case 9 -> InserisciCliente();
                case 10 -> VisualizzaVasche();
                case 11 -> VisualizzaIscrizioniAdUnCorso();
                case 12 -> VisualizzaIngressi();
                case 13 -> System.exit(0);
                default -> throw new RuntimeException("Invalid choice");
            }
        }
    }

    private void RegistraIscrizione(){

    }
    private void RegistraIngresso(){

    }
    private void RegistraCorso(){
        Course insertCourse, newCourse;
        try {
            insertCourse = SegreteriaView.insertCourse();
            // creazione di un nuovo oggetto Course con i valori ottenuti da insertCourse
            newCourse = new Course(
                    insertCourse.getNome(),
                    insertCourse.getMinPart(),
                    insertCourse.getMaxPart(),
                    insertCourse.getIdVasca(),
                    insertCourse.getDataInizioCorso(),
                    insertCourse.getPrezzo()
            );
            // chiamata al metodo addCourse della classe addCourseDAO per aggiungere il nuovo corso
            addCourseDAO.getInstance().execute(newCourse);
        } catch (IOException | DAOException | ParseException e) { // gestione delle eccezioni
            throw new RuntimeException(e); //Se si verifica un'eccezione, verrà sollevata un'eccezione RuntimeException,
                                            // che può essere catturata e gestita da un blocco catch esterno al metodo RegistraCorso().
        }
    }
        private void RegistraVasca(){

    }
    private void RegistraLezione(){

    }
    private void EliminaLezione(){

    }
    private void VisualizzaCorsiDisponibili(){

    }

    private void ReportUtenti(){

    }
    private void InserisciCliente(){

    }

    private void VisualizzaVasche(){

    }

    private void VisualizzaIscrizioniAdUnCorso(){

    }

    private void VisualizzaIngressi(){

    }

}
