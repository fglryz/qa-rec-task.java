package com.cera.task.java;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WorkingDayTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void workingDayTest() throws Exception {
		ResponseEntity<String> response = this.restTemplate.
            getForEntity("http://localhost:" + port + "/carer?date=2021-11-07", String.class);

        try {
            assertThat(response.getStatusCodeValue()).isEqualTo(200);//not string  it must be integer
        } catch (Exception e) {
            throw new Exception("HTTP not OK" + e);
        }
        assertThat(response.getBody()).isEqualTo("{\"workingDay\":false}");//changed the true to false to verify the date that is not a working day
	}

    // Add Negative Test
     @Test
     public void negativeTest() throws Exception {ResponseEntity<String> response = this.restTemplate.
			 getForEntity("http://localhost:" + port + "/carer?date=2021-11-07", String.class);

		 try {
			 assertThat(response.getStatusCodeValue()).isEqualTo(200);//not string  it must be integer
		 } catch (Exception e) {
			 throw new Exception("HTTP not OK" + e);
		 }
		 assertThat(response.getBody()).isNotEqualTo("{\"workingDay\":true}");}

}
