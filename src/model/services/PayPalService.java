/**
 * 
 */
package model.services;

/**
 * Classe que contem as informacoes do Servico PayPal
 * 
 * @author Matos - 17.06.2023
 *
 */
public class PayPalService implements OnlinePaymentService {
	
	private static final double FEE_PERCENTAGE = 0.02;
	private static final double MONTHLY_INTEREST = 0.01;

	@Override
	public Double paymentFee(Double amount) {
		return amount * FEE_PERCENTAGE;
	}

	@Override
	public Double interest(Double amount, Integer months) {
		return amount * MONTHLY_INTEREST * months;
	}

}
