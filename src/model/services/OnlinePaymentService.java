/**
 * 
 */
package model.services;

/**
 * Interface - Pagamento Online
 * 
 * @author Matos - 17.06.2023
 *
 */
public interface OnlinePaymentService {

	Double paymentFee(Double amount);
	Double interest(Double amount, Integer months);
	
}
