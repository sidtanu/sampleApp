package com.gaig.proxy.exstream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.mockito.Mockito;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.gaig.proxy.exstream.controllers.ExstreamProxyServiceController;
import com.gaig.proxy.exstream.model.Document;
import com.gaig.proxy.exstream.model.DocumentDCS;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = ExstreamProxyServiceController.class)
public class TestExstreamProxyServiceController {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private AmqpTemplate amqpTemplate;

	@Test
	public void testLetterpush() throws Exception {

		Document mockDocument = new Document("312-36-30087", "Bob G Smith", "1409 Roper Mountain Road", "SC",
				"29615", "2018-07-06T00:00:00+00:00", "WorkersComp", "32-300869", "08022019", "surajprakash.a@hcl.com",
				"MedicareLetter", "Bob G Smith");

		ObjectMapper Obj = new ObjectMapper();
		String jsonStrDCS = Obj.writeValueAsString(mockDocument);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/document").accept(MediaType.APPLICATION_JSON)
				.content(jsonStrDCS).contentType(MediaType.APPLICATION_JSON);
		System.out.println(jsonStrDCS);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

}
