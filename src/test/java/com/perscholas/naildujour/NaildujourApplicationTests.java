package com.perscholas.naildujour;

import com.perscholas.naildujour.models.Beverage;
import com.perscholas.naildujour.models.User;
import com.perscholas.naildujour.models.Order;
import com.perscholas.naildujour.models.Polish;
import com.perscholas.naildujour.services.PolishService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
class NaildujourApplicationTests {


	@Test
	void contextLoads() {
	}

	//Beverage Tests
	@Test
	void testBeverageGetter() {
		Beverage testBev = new Beverage("wine", "alcoholic");
		Beverage testBev2 = new Beverage("water", "non-alcoholic");

		assertEquals("wine", testBev.getName());
		assertEquals("non-alcoholic", testBev2.getType());

	}

	@Test
	void testBeverageSetter() {
		Beverage testBev = new Beverage("coke", null);
		testBev.setName("kool-aide");
		assertEquals("kool-aide", testBev.getName());

		testBev.setType("non-alcoholic");
		assertEquals("non-alcoholic", testBev.getType());
	}



}
