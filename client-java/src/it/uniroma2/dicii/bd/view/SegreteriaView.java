package it.uniroma2.dicii.bd.view;

import it.uniroma2.dicii.bd.model.domain.Course;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SegreteriaView {
    public static int showMenu() throws IOException {
        System.out.println("*********************************");
        System.out.println("*    POOL DASHBOARD    *");
        System.out.println("*********************************\n");
        System.out.println("*** What should I do for you? ***\n");
        System.out.println("1) Register Enrollment in the course");
        System.out.println("2) Register entry to the pool");
        System.out.println("3) Register a new course");
        System.out.println("4) Register a new swimming pool");
        System.out.println("5) Register a new lesson of a course");
        System.out.println("6) Delete an already recorded lesson");
        System.out.println("7) Visualize all the course");
        System.out.println("8) Report of customers who access the pool and customers who had to access");
        System.out.println("9) Insert a new Client and his information");
        System.out.println("10) Quit");

        Scanner input = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.print("Please enter your choice: ");
            choice = input.nextInt();
            if (choice >= 1 && choice <= 10) {
                break;
            }
            System.out.println("Invalid option");
        }

        return choice;
    }

    public static Course insertCourse() throws IOException, ParseException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il nome del corso: ");
        String Nome = scanner.nextLine();

        System.out.println("Inserisci il numero minimo di partecipanti del corso: ");
        Integer minPartecipanti = scanner.nextInt();

        System.out.println("Inserisci il numero massimo di partecipanti del corso: ");
        Integer maxPartecipanti = scanner.nextInt();
        scanner.nextLine(); // Consuma l'Invio rimasto nel buffer del Scanner

        System.out.println("Inserisci la data di inizio del corso (nel formato YYYY-MM-DD): ");
        String dataInizio = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dataInizioCorso = dateFormat.parse(dataInizio);

        System.out.println("Inserisci la vasca in cui si svolge il corso: ");
        Integer idVasca = scanner.nextInt();


        System.out.println("Inserisci il prezzo del corso: ");
        BigDecimal prezzo = scanner.nextBigDecimal();







        return new Course(Nome, minPartecipanti, maxPartecipanti, idVasca, dataInizioCorso, prezzo);

}
}
