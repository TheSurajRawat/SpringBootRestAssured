package com.stackroute.restAssured;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest
public class EmployeeRestAPITest {

	@Test
	public void  testWelcome() {
		System.out.println(RestAssured.given()
							.get("http://localhost:8080/")
							.asPrettyString());
	}
	@Test
	public void testEmployeAddNew() {
		RestAssured.given()
					.queryParam("empId", 101)
					.queryParam("employeeName","Deepak")
					.queryParam("empCity", "Ghaziabad")
					.when()
					.post("http://localhost:8080/employee/addnew")
					.then()
					.assertThat()
					.statusCode(201);
	}
	@Test
	public void testAddnewEmployee() {
		String empBody = "{\"empId\":102, \"employeeName\":\"Rohit\", \"empCity\":\"Mumbai\"}";
		RestAssured.given()
					.body(empBody)
					.contentType(ContentType.JSON)
					.post("http://localhost:8080/employee/addnewobj")
					.then()
					.assertThat()
					.statusCode(201);
	}
	@Test
	public void addEmployeeForDelete() {
		String empBody = "{\"empId\":\"103\", \"employeeName\":\"Shikher\", \"empCity\":\"Mumbai\"}";
		
		int respStatusCode = RestAssured
							.given()
							.contentType(ContentType.JSON)
							.body(empBody)
							.post("http://localhost:8080/employee/addnewobj")
							.getStatusCode();
		Assertions.assertEquals(201, respStatusCode);
	}
	
	
	@Test
	public void findAll() {
		System.out.println(
							RestAssured.given()
										.when()
										.get("http://localhost:8080//employee/findAll")
										.asPrettyString()
										
				);
	}
	
	@Test
	public void findEmployeeByEmpId() {
		System.out.println(RestAssured.given()
									  .when()
									  .get("http://localhost:8080/employee/101")
									  .asPrettyString()
									 );
									  
	}
	@Test
	public void findEmployeeByEmpName() {
		System.out.println("ByName");
		System.out.println(RestAssured.given()
									.queryParam("employeeName", "Shikher")
									.when()
									.get("http://localhost:8080/employee/findByName")
									.asPrettyString());
	}
	@Test
	public void updateEmployeeByEmpId() {
		
		String empBody = "{\"empId\":102,\"employeeName\":\"Sachin\",\"empCity\":\"Mumbai\"}";
		RestAssured.given()
		.queryParam("empId", 102)
		.contentType(ContentType.JSON)
					.body(empBody)
					.when()
					.put("http://localhost:8080/updateEmployee/102")
					.then()
					.assertThat()
					.statusCode(200);				
		
	
	}
	
	@Test
	public void testDeleteById() {
		RestAssured
		.given()
		.when()
		.queryParam("empId", 103)
		.delete("http://localhost:8080/deleteEmployee/103")
		.then()
		.assertThat()
		.statusCode(204);				
	}
	
	@Test
	public void deleteEmployeeObject() {
		
		String empBody = "{\"empId\":101,\"employeeName\":\"Deepak\",\"empCity\":\"Ghaziabad\"}";
		RestAssured.given()
		.contentType(ContentType.JSON)
					.body(empBody)
					.when()
					.delete("http://localhost:8080/employee/deleteEmployee")
					.then()
					.assertThat()
					.statusCode(204);				
	
	}	
}
