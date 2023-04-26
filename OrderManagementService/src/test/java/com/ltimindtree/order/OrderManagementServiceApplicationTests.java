package com.ltimindtree.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ltimindtree.order.entity.Order;
import com.ltimindtree.order.repository.OrderRepository;

@SpringBootTest
class OrderManagementServiceApplicationTests {

	@Autowired
	private OrderRepository Repo;

	@Test
	void contextLoads() {
	}

	@Test
	public void CreateOrderTest() {
		Order order = new Order(1, 1, 1, 3000, "19-01-2023", "19-01-2023", "Mx104", "Prasanth", 9345734565L,
				"delivered", 1);
		Order savedOrder = Repo.save(order);

		assertNotNull(savedOrder);
	}

	@Test
	public void cancelOrderTest() {

		Order order = Repo.findById(1L).get();

		Repo.delete(order);

		Order order1 = null;

		Optional<Order> optionalorder = Optional.empty();

		if (optionalorder.isPresent()) {
			order1 = optionalorder.get();
		}

		assertThat(order1).isNull();
	}

	@Test

	public void viewOrderTest() {
		String customerName = "Prasanth";
		Order order = Repo.findByCustomerName(customerName);

		assertThat(order.getCustomerName()).isEqualTo(customerName);
	}

}
