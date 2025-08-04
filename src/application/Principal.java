package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.ExcecaoDominio;

public class Principal {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			System.out.print("Número do quarto: ");
			int numero = sc.nextInt();
			System.out.println("Data de check-in (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.println("Data de check-out (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());
			
			Reserva reserva = new Reserva(numero, checkin, checkout);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();

			System.out.println("Entre com a data para atualizar a reserva: ");
			System.out.println("Data de check-in (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.println("Data de check-out (dd/MM/yyyy): ");	
			checkout = sdf.parse(sc.next());
		
			reserva.atualizaData(checkin, checkout);
			System.out.println("Reserva: " + reserva);			
		} catch (ParseException e) {
			System.out.println("Formato da data inválido!");
		} catch (ExcecaoDominio e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro não esperado!");
		}
	
		sc.close();
	
	}

}
