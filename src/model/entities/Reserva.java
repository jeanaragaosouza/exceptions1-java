package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	private Integer numeroQuarto;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");
	
	public void Reserva() {
		
	}

	public Reserva(Integer numeroQuarto, Date checkin, Date checkout) {		
		this.numeroQuarto = numeroQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}
	
	
	public long duracao() {
		
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);		
	}
	
	public String atualizaData(Date checkin, Date checkout) {
		
		Date agora = new Date();
		
		if(checkin.before(agora) || checkout.before(agora)) {
			return "Erro na reserva: A data de reserva deve ser maior que a data de checkin";
		}if (!checkout.after(checkin)) {
			return "Erro na reserva: A data de check-out deve ser maior que a data de checkin";
		}
	
	this.checkin = checkin;
	this.checkout = checkout;	
	return null;	
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ numeroQuarto
				+ ", check-in: "
				+ sdf.format(checkin)
				+ ", check-out: "
				+ sdf.format(checkout)
				+ ", "
				+ duracao()
				+ " noites";
	}
	
	
}
