package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reserva;

public class Principal {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int numero = sc.nextInt();
		System.out.println("Data de check-in (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.println("Data de check-out (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		
		if (!checkout.after(checkin)) {
			System.out.println("Erro na reserva: A data de checkout deve ser maior que a data de checkin");			
		}else {
			Reserva reserva = new Reserva(numero, checkin, checkout);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();

			System.out.println("Entre com a data para atualizar a reserva: ");
			System.out.println("Data de check-in (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.println("Data de check-out (dd/MM/yyyy): ");	
			checkout = sdf.parse(sc.next());
		
			String error = reserva.atualizaData(checkin, checkout);
			if(error != null) {
				System.out.println("Erro na Reserva: " + error);
			}else {	
				System.out.println("Reserva: " + reserva);			
			}		
			
		}
		
		
	sc.close();
	
	}

}
