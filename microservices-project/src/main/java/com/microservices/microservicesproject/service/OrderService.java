package com.microservices.microservicesproject.service;

import com.microservices.microservicesproject.common.Payment;
import com.microservices.microservicesproject.common.TransactionRequest;
import com.microservices.microservicesproject.common.TransactionResponse;
import com.microservices.microservicesproject.entity.Order;
import com.microservices.microservicesproject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private RestTemplate template;

    @Autowired
    private OrderRepository repository;

    public TransactionResponse saveOrder(TransactionRequest request){
        String response ="";
        Order order= request.getOrder();
        Payment payment=request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        //rest call

        Payment paymentResponse = template.postForObject("http://PAYMENT_SERVICE/localhost:9191/payment/doPayment",payment,Payment.class);

        response = paymentResponse.getPaymentStatus().equals("success")?"payment processing successful and order placed":"there is failure in payment api, order added to cart";
        repository.save(order);
         return new TransactionResponse(order,paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
    }
}
