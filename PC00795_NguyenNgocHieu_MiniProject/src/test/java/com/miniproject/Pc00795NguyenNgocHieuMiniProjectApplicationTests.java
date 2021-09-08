package com.miniproject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.miniproject.dao.OrderDAO;
import com.miniproject.dao.OrderDetailDAO;
import com.miniproject.dto.SignupRequest;
import com.miniproject.entity.Account;
import com.miniproject.entity.Order;
import com.miniproject.entity.OrderDetail;
import com.miniproject.entity.Product;
import com.miniproject.rest.controller.AccountRestController;
import com.miniproject.service.AccountService;
import com.miniproject.service.OrderService;
import com.miniproject.service.ProductService;

@SpringBootTest
class Pc00795NguyenNgocHieuMiniProjectApplicationTests {

	@Autowired
	AccountRestController accountRestController;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	ProductService productService; 
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	OrderDetailDAO orderDetailDAO;
	
	@Test
	void signUp1() {
		SignupRequest signuprRequest = new SignupRequest();
		List<String> role = new ArrayList<String>();
		role.add("US");
		signuprRequest.setUsername("NgocHieu");
		signuprRequest.setPassword("1234");
		signuprRequest.setFullname("Nguyễn Ngọc Hiếu");
		signuprRequest.setEmail("hieunnpc00795@fpt.edu.vn");
		signuprRequest.setRole(role);
		accountRestController.create(signuprRequest);
		assertNotNull(accountService.findById(signuprRequest.getUsername()));
	}
	
	@Test
	void changePassword() {
		Account account = accountService.findById("NguyenNgocHieu");
		account.setPassword("1234");
		accountRestController.changepassword(account);
		assertNotEquals("abcd", accountService.findById("NguyenNgocHieu").getPassword());
	}
	
	@Test
	void forgotPassword() {
		Account account = accountService.findById("NgocHieu");
		accountRestController.forgotpassword(account);
		assertNotEquals(account.getPassword(), accountService.findById("NguyenNgocHieu").getPassword());
	}
	
	@Test
	void updateAccount() {
		Account account = accountService.findById("NgocHieu");
		account.setFullname("Ngọc Hiếu");
		accountRestController.updateaccount(account);
		assertNotEquals(account.getFullname(), accountService.findById("NgocHieu"));
	}
	
	@Test
	void order() {
		Order order = new Order();
		OrderDetail orderDetail = new OrderDetail();
		Account account = accountService.findById("NgocHieu");
		Product product = productService.findById(1);
		order.setCreateDate(new Date());
		order.setAddress("Kiên Giang");
		order.setAccount(account);
		orderDAO.save(order);
		orderDetail.setOrder(order);
		orderDetail.setProduct(product);
		orderDetail.setPrice(product.getPrice());
		orderDetail.setQuantity(1);
		orderDetailDAO.save(orderDetail);
	}
	
	@Test
	void orderByUsername() {
		List<Order> order = orderService.findByUsername("NgocHieu");
		assertThat(order).size().isGreaterThan(0);
	}

}
