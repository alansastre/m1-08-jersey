package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.demo.domain.SmartPhone;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class M108JerseyApplicationTests {

	private TestRestTemplate testRestTemplate;

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	@LocalServerPort
	private int port;

	@BeforeEach
	void setup() {
		restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
		testRestTemplate = new TestRestTemplate(restTemplateBuilder);
	}

	@Test
	@DisplayName("Pruebas GET Hello Controller")
	void testGET() {

		// ejecutar el metodo de controlador a testear
		ResponseEntity<String> entity = this.testRestTemplate.getForEntity("/api/hello", String.class);


		/*
		 * Recibimos una respuesta HTTP:
		 * 1. status
		 * 2. body
		 * 3. headers
		 */
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		assertEquals("Hola desde método 1", entity.getBody());

	}

	@Test
	void testPost() {

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		String productPayload = """
								{
				    "id": 0,
				    "name": "Another smartphone otra vez prueba",
				    "ram": {
				        "id": 4,
				        "type": "DDR6",
				        "gigabytes": 32
				    },
				    "battery": {
				        "id": 3,
				        "capacity": 9500.0
				    },
				    "cpu": {
				        "id": 4,
				        "on": false,
				        "cores": 16
				    },
				    "wifi": true,
				    "camera": {
				        "id": 3,
				        "model": "front camera",
				        "megapixels": 58.5
				    }
				}
								""";

		final HttpEntity<String> request = new HttpEntity<>(productPayload, headers);

		final ResponseEntity<SmartPhone> response = 
				testRestTemplate.exchange("/api/smartphone", HttpMethod.POST, request, SmartPhone.class);

		// Comprobaciones: 
		// status
		assertEquals(HttpStatus.OK, response.getStatusCode());
		// body
		SmartPhone smartphone = response.getBody();
		System.out.println(smartphone);
		assertEquals(4, smartphone.getId());
		assertNotNull(smartphone.getBattery());
		

	}

}