package ru.geekbrains.paymentservice.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.geekbrains.paymentservice.repository.PaymentRepository;
import ru.geekbrains.paymentservice.repository.ProductRepository;
import ru.geekbrains.soap.payment.GetProductRequest;
import ru.geekbrains.soap.payment.GetProductResponse;

@Endpoint
public class ProductServiceEndpoint {

	private final String NAMESPACE = "http://www.geekbrains.ru/PaymentService";

	private final ProductRepository productRepository;

	public ProductServiceEndpoint(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@PayloadRoot(namespace = NAMESPACE, localPart = "getProductRequest")
	@ResponsePayload
	public GetProductResponse getUser(@RequestPayload final GetProductRequest request) {
		GetProductResponse response = new GetProductResponse();
		response.getProducts().addAll(productRepository.getProducts(request.getPrice()));
		return response;
	}

}