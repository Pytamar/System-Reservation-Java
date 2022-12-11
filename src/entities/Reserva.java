package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {
	
	private Integer numeroQuarto;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reserva() {
		
	}
	
	public Reserva(Integer numeroQuarto, Date checkin, Date checkout) {
		if(!checkout.after(checkin)) {
			throw new DomainException ("A data do Check-out deve ser depois do Check-in.");
		}
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
	
	public void dataAtualizada(Date checkin, Date checkout) {
		Date agora = new Date();
		if(checkin.before(agora) || checkout.before(agora)) {
			throw new DomainException("Data da reserva antes da data atual.");
		}
		if(!checkout.after(checkin)) {
			throw new DomainException ("A data do Check-out deve ser depois do Check-in.");
		}
			
		this.checkin = checkin;
		this.checkout = checkout;	
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ numeroQuarto
				+ ", check-in: "
				+ data.format(checkin)
				+ ", check-out: "
				+ data.format(checkout)
				+ ", "
				+ duracao()
				+ " noite(s)";
}

}
