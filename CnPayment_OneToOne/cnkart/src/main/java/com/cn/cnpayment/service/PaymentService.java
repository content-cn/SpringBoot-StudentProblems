package com.cn.cnpayment.service;

import javax.transaction.Transactional;
import com.cn.cnpayment.dal.PaymentDAL;
import com.cn.cnpayment.exception.ElementAlreadyExistException;
import com.cn.cnpayment.exception.InvalidInputException;
import com.cn.cnpayment.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;;
import com.cn.cnpayment.entity.Payment;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

	@Autowired
	PaymentDAL paymentDAL;

	@Transactional
	public Payment getPaymentById(int id) {

		Payment payment=paymentDAL.getById(id);

		if(payment==null)
		{
			throw new NotFoundException("No payment found with id:  "+id);
		}
		return payment;
	}

	@Transactional
	public List<Payment> getPaymentByPaymentType(String paymentType) {

		ArrayList<String> validPayments = new ArrayList<String>() {{
				add("Cash");
				add("Cheques");
				add("DebitCard");
				add("CreditCard");
			}};
		Boolean isValidPayment=false;
		for(String validPayment : validPayments)
		{
			if(validPayment.equalsIgnoreCase(paymentType))
			{
				isValidPayment=true;
				break;
			}
		}
		if(isValidPayment==false)
		{
			throw new InvalidInputException("Payment type "+ paymentType + "is incorrect");
		}
		List<Payment> payment = paymentDAL.getByPaymentType(paymentType);

		if(payment==null)
		{
			throw new NotFoundException("No payments found having paymentType: "+paymentType);
		}
		return payment;
	}

	@Transactional
	public List<Payment> getPaymentByDescriptionKeyword(String keyword) {

		List<Payment> payments = paymentDAL.getByPaymentDescription(keyword);
		if(payments==null)
		{
			throw new NotFoundException("No payments found, with description having keyword: "+keyword);
		}
		return payments;
	}

	@Transactional
	public List<Payment> getAllPaymentsByCurrency(String currency) {

		ArrayList<String> validCurrencies = new ArrayList<String>() {{
			add("Rupee");
			add("Dollar");
			add("Yen");
			add("Pound");
		}};
		Boolean isValidCurrency=false;
		for(String validCurrency : validCurrencies)
		{
			if(validCurrency.equalsIgnoreCase(currency))
			{
				isValidCurrency=true;
				break;
			}
		}
		if(isValidCurrency==false)
		{
			throw new InvalidInputException("Currency "+ currency + "is invalid.");
		}
		List<Payment> payment = paymentDAL.getAllPaymentsByCurrency(currency);

		if(payment==null)
		{
			throw new NotFoundException("No payments found having currency : "+currency);
		}
		return payment;
	}

	@Transactional
	public List<Payment> getAllPayments() {

		List<Payment> payment = paymentDAL.getAllPayments();
		if(payment==null)
		{
			throw new NotFoundException("No payments found.");
		}
		return payment;
	}

	@Transactional
	public Payment savePayment(Payment newPayment) {

		List<Payment> allPayments = getAllPayments();
		for(Payment payment : allPayments)
		{
			if(payment.getId()==newPayment.getId())
			{
				throw new ElementAlreadyExistException("This payment already exist.");
			}
		}
		return paymentDAL.save(newPayment);
	}

	@Transactional
	public void update(Payment updatePayment) {
		 paymentDAL.update(updatePayment);
	}

	@Transactional
	public void updateDescription(int id, String description) {
		paymentDAL.updateDescription(id,description);
	}

	@Transactional
	public void delete(int id) {
		paymentDAL.delete(id);
	}

}

