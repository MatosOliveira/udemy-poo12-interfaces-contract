/**
 * 
 */
package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe que contem as informacoes da(s) parcela(s)
 * 
 * @author Matos - 17.06.2023
 *
 */
public class Installment {

	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private LocalDate dueDate;
	private Double amount;
	
	public Installment() {
	}

	public Installment (LocalDate dueDate, Double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return dueDate.format(dtf) +  " - " + String.format("%.2f", amount);
	}
	
	
}
