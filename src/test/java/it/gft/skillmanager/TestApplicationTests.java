package it.gft.skillmanager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TestApplicationTests {

	@Test
	void contextLoads() {
	}

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getHello() throws Exception {

		ResponseEntity<String> response = restTemplate.getForEntity(
				new URL("http://localhost:" + port + "/").toString(), String.class);
		assertEquals("Hello Controller", response.getBody());

//		assertEquals("Hello Controller", "Hello Controller");
	}


}
