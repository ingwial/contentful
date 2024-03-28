package alvarez.wilfredo.contenful;

import alvarez.wilfredo.contenful.controllers.PeliculaController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ContenfulApplicationTests {
	@MockBean
	private PeliculaController peliculaController;

	@Test
	void contextLoads() {
		assertThat(peliculaController).isNotNull();
	}

}
