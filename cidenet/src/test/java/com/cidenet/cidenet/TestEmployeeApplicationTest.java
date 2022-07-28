package com.cidenet.cidenet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.cidenet.cidenet.Business.Business;
import com.cidenet.cidenet.controller.EmployeesController;
import com.cidenet.cidenet.model.EmployeesModel;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestEmployeeApplicationTest {

	@Autowired
	private EmployeesController controller;

	@Test
    public void generateEmail(){
		Business bus = new Business();
		EmployeesModel model = new EmployeesModel(null, "Velasquez", null, "Danna", null, null, null, "Colombia", null, null, null, null);
		assertEquals("danna.velasquez@cidenet.com.co",bus.generateEmail(model));
	}

	@Test
    public void ValidateAreas(){
		Business bus = new Business();
	    assertEquals(true, bus.ValidateAreas("Financiera"));
		assertNotEquals(true, bus.ValidateAreas("Tecnologia"));
	}

	@Test
    public void ValidateIdType(){
		Business bus = new Business();
	    assertEquals(true, bus.ValidateIdType("Pasaporte"));
	}

	@Test
    public void ValidateCountryEmploy(){
		Business bus = new Business();
	    assertNotEquals(true, bus.ValidateCountryEmploy("Venezuela"));
	}
	
	@Test
	public void ValidateAdmissionDate(){
		Business bus = new Business();
		LocalDate fecha = LocalDate.parse("2022-12-28");
		assertEquals(false, bus.ValidateAdmissionDate(fecha));
	}
}

