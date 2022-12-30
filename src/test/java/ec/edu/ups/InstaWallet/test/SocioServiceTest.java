package ec.edu.ups.InstaWallet.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ec.edu.ups.InstaWallet.modelo.Cuenta;
import ec.edu.ups.InstaWallet.modelo.Socio;
import ec.edu.ups.InstaWallet.repository.SocioRepository;
import ec.edu.ups.InstaWallet.services.SocioService;

public class SocioServiceTest {
	@InjectMocks
	SocioService socioService;

	@Mock
	SocioRepository socioRepository;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	static Stream<Socio> generadorSocio() {

		Socio socio = new Socio();
		List<Cuenta> c = new ArrayList<>();

		// creacion de usuario
		socio.setCorreoSocio("ejemplo@gmail.com");
		socio.setCuentas(c);
		socio.setIdentificacionSocio("0150019453");
		socio.setNombreSocio("Denys Dutan");
		socio.setTelefonoSocio("0987654321");

		return Stream.of(socio);
	}

	@ParameterizedTest
	@MethodSource("generadorSocio")
	public void saveCuenta(Socio soc) {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		when(socioService.crearSocio(any(Socio.class))).thenReturn(soc);

		Socio response = socioService.crearSocio(soc);

		assertTrue(response.equals(soc));

	}

	@ParameterizedTest
	@MethodSource("generadorSocio")
	public void findAll(Socio soc) {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		when(socioService.listarSocios()).thenReturn(Arrays.asList(soc));
		assertNotNull(socioService.listarSocios());
	}

}
