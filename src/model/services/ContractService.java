/**
 * 
 */
package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

/**
 * Classe que contem as informacoes do Serviço 
 * 
 * @author Matos - 17.06.2023
 *
 */
public class ContractService {

	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {
		
		double valorParcela = contract.getTotalValue() / months;
		
		for(int i = 1; i <= months; i++) {
			
			LocalDate dataParcela = contract.getDate().plusMonths(i);
			double interest = onlinePaymentService.interest(valorParcela, i);
			double fee = onlinePaymentService.paymentFee(valorParcela + interest);
			double valorMensal = valorParcela + interest + fee;
			
			contract.getInstallments().add(new Installment(dataParcela, valorMensal));
		}
	}
}
