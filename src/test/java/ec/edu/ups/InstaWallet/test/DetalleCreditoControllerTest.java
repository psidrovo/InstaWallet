package ec.edu.ups.InstaWallet.test;

import ec.edu.ups.InstaWallet.controller.CreditoRestController;
import ec.edu.ups.InstaWallet.controller.DetalleCreditoRestController;
import ec.edu.ups.InstaWallet.modelo.Credito;
import ec.edu.ups.InstaWallet.modelo.DetalleCredito;
import ec.edu.ups.InstaWallet.services.CreditoService;
import ec.edu.ups.InstaWallet.services.DetalleCreditoService;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;

//import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class DetalleCreditoControllerTest {

    @InjectMocks
    DetalleCreditoRestController detCreditoRestController;
    @InjectMocks
    CreditoRestController creditoRestController;

    @Mock
    DetalleCreditoService detCreditoService;
    @Mock
    CreditoService creditoService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);

    }

    /*@ParameterizedTest
    @MethodSource("generator")
    public void crearCredito(DetalleCredito det){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Credito cre1 = new Credito();
        cre1.setId(1);
        cre1.setCuotaCredito(145);
        cre1.setEstado("en espera");
        cre1.setEstadoSolicitudCredito("enviado");
        cre1.setFechaFinal(new Date());
        cre1.setFechaInicio(new Date());
        cre1.setInteres(0.5);
        cre1.setNumeroCuotasRestantes(12);
        cre1.setNumeroDeCuotas(12);
        cre1.setValorCredito(10000.00);
        
        when(detCreditoRestController.crearDetalleCredito(det,cre1.getId())).thenReturn(det);
        
        DetalleCredito response = detCreditoRestController.crearDetalleCredito(det,cre1.getId());
        
        assertTrue(response.equals(det));
        
    }*/

    @ParameterizedTest
    @MethodSource("generator")
    public void findAllTest(DetalleCredito det) {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(detCreditoService.findAll()).thenReturn(Arrays.asList(det));
        assertNotNull(detCreditoService.findAll());
    }

    // and then somewhere in this test class  
    static Stream<DetalleCredito> generator() {

        Credito cre1 = new Credito();
        cre1.setId(1);
        cre1.setCuotaCredito(145);
        cre1.setEstado("en espera");
        cre1.setEstadoSolicitudCredito("enviado");
        cre1.setFechaFinal(new Date());
        cre1.setFechaInicio(new Date());
        cre1.setInteres(0.5);
        cre1.setNumeroCuotasRestantes(12);
        cre1.setNumeroDeCuotas(12);
        cre1.setValorCredito(10000.00);


        DetalleCredito cre = new DetalleCredito();
        cre.setId(1);
        cre.setFechaPago(new Date());
        cre.setValorPago(100.0);
        cre.setEstado("Pagado");

        return Stream.of(cre);

    }

}
