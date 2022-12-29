package ec.edu.ups.InstaWallet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ec.edu.ups.InstaWallet.controller.CreditoRestController;
import ec.edu.ups.InstaWallet.modelo.Credito;
import ec.edu.ups.InstaWallet.services.CreditoService;
import java.util.Date;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@SpringBootTest
class InstaWalletApplicationTests {

	@Test
	public void testConfiguracion() {
		
	}

	@InjectMocks
    CreditoRestController creditoRestController;
    
    @Mock
    CreditoService creditoService;
       
    
    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        
    }
    
    @ParameterizedTest
    @MethodSource("generator")
    public void crearTest(Credito cre){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(creditoService.save(any(Credito.class))).thenReturn(cre);
        
        Credito response = creditoRestController.crearCredito(cre);
        
        assertTrue(response.equals(cre));
        
    }
    
    
    // and then somewhere in this test class  
    static Stream<Credito> generator() {
        
        Credito cre = new Credito();
        cre.setId(1);
        cre.setCuotaCredito(145);
        cre.setEstado("en espera");
        cre.setEstadoSolicitudCredito("enviado");
        cre.setFechaFinal(new Date());
        cre.setFechaInicio(new Date());
        cre.setInteres(0.5);
        cre.setNumeroCuotasRestantes(12);
        cre.setNumeroDeCuotas(12);
        cre.setValorCredito(10000.00);

        return Stream.of(
            cre     
        );

    }

}
