package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		
	
		try {
		System.out.print("Numero do quarto: ");
		int numeroQuarto = teclado.nextInt();
		System.out.print("Data do Check-in (dd/MM/yyyy): ");
		Date checkin = data.parse(teclado.next());
		System.out.print("Data do Check-out (dd/MM/yyyy): " );
		Date checkout = data.parse(teclado.next());
		
		Reserva reserva = new Reserva(numeroQuarto, checkin, checkout);
		System.out.println("Reserva: " + reserva);
		
		System.out.println();
		System.out.println("Entre com os dados atualizados da reserva: ");
		System.out.print("Data do Check-in (dd/MM/yyyy): ");
		checkin = data.parse(teclado.next());
		System.out.print("Data do Check-out (dd/MM/yyyy): ");
		checkout = data.parse(teclado.next());
		
		reserva.dataAtualizada(checkin, checkout);
		System.out.println("Reserva: " + reserva);
		}catch(ParseException e) {
		System.out.println("Data invalida. Digita da mesma forma que está o exemplo");
		}catch(DomainException e) {
		System.out.println("Erro na reseva: " + e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
	
		
		
	}
}	
	
	

