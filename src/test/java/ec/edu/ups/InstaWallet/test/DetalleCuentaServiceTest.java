package ec.edu.ups.InstaWallet.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
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

import ec.edu.ups.InstaWallet.modelo.DetalleCuenta;
import ec.edu.ups.InstaWallet.repository.DetalleCuentaRepo;
import ec.edu.ups.InstaWallet.services.DetalleCuentaService;

public class DetalleCuentaServiceTest {

	@InjectMocks
	DetalleCuentaService detalleCuentaService;

	@Mock
	DetalleCuentaRepo cuentaRepo;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	static Stream<DetalleCuenta> generadorDetalleCuenta(){

		DetalleCuenta detalleCuenta = new DetalleCuenta();
        detalleCuenta.setCuentaCodigo("001");
        detalleCuenta.setFecha(new Date());
        detalleCuenta.setId(1);
        detalleCuenta.setTipoMovimiento("DEPOSITO");
        detalleCuenta.setValor(250.00);

		return Stream.of(detalleCuenta);
	}

	@ParameterizedTest
	@MethodSource("generator")
	public void saveCuenta(DetalleCuenta dcue) {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		when(detalleCuentaService.save(any(DetalleCuenta.class))).thenReturn(dcue);

		DetalleCuenta response = detalleCuentaService.save(dcue);

		assertTrue(response.equals(dcue));

	}

	@ParameterizedTest
	@MethodSource("generator")
	public void findAll(DetalleCuenta dcue) {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		when(detalleCuentaService.findAll()).thenReturn(Arrays.asList(dcue));
		assertNotNull(detalleCuentaService.findAll());
	}
	
	
	
	

}
