package id.co.inixindojogja.microsvc.springmicrosvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

//contoh unit test
@SpringBootTest
@AutoConfigureMockMvc
class SpringmicrosvcApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void testambah() throws Exception {
		int a = 3;
		int b = 7;
		mvc.perform(get("/tambah/"+a+"/"+b)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
				.andExpect(content().string("jumlah dari 3.0 dan 7.0 adalah 10.0"));
	}

	@Test
	void teskali() throws Exception {
		int a = 3;
		int b = 7;
		mvc.perform(get("/kali?a="+a+"&b="+b)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
				.andExpect(content().string("hasil kali dari 3.0 dan 7.0 adalah 21.0"));
	}

}
