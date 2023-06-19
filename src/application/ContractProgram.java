/**
 * 
 */
package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PayPalService;

/**
 * @author Matos
 *
 */
public class ContractProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre os dados do contrato: ");
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate data = LocalDate.parse(sc.next(), fmt);
		
		System.out.print("Valor do contrato: ");
		double valorContrato = sc.nextDouble();
		
		System.out.println("\nEntre com o numero de parcelas: ");
		int n = sc.nextInt();
		
		Contract contrato = new Contract(numero, data, valorContrato);
		ContractService contractService = new ContractService(new PayPalService());
		
		contractService.processContract(contrato, n);
		
		
		System.out.println("\nParcelas: ");
		for(Installment parc: contrato.getInstallments()) {
			System.out.println(parc.toString());
		}
		
		sc.close();
	}

}
