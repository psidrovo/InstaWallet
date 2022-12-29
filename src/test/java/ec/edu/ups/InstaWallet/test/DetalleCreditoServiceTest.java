package ec.edu.ups.InstaWallet.test;

import ec.edu.ups.InstaWallet.controller.CreditoRestController;
import ec.edu.ups.InstaWallet.controller.DetalleCreditoRestController;
import ec.edu.ups.InstaWallet.modelo.Credito;
import ec.edu.ups.InstaWallet.modelo.DetalleCredito;
import ec.edu.ups.InstaWallet.repository.CreditoRepo;
import ec.edu.ups.InstaWallet.services.CreditoService;
import ec.edu.ups.InstaWallet.services.DetalleCreditoService;
import io.swagger.v3.oas.annotations.servers.Server;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;
import javax.transaction.Transactional;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class DetalleCreditoServiceTest {

    @InjectMocks
    DetalleCreditoRestController detCreditoRestController;

    @Mock
    DetalleCreditoService detCreditoService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);

    }

    /*@ParameterizedTest
    @MethodSource("generator")
    public void crearCredito(DetalleCredito det){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(detCreditoService.save(any(DetalleCredito.class))).thenReturn(det);
        
        DetalleCredito response = detCreditoRestController.crearDetalleCredito(det,1);
        
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

        DetalleCredito cre = new DetalleCredito();
        cre.setId(1);
        cre.setFechaPago(new Date());
        cre.setValorPago(100.0);
        cre.setEstado("Pagado");

        return Stream.of(
                cre
        );

    }

}
