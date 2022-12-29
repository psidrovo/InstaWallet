/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.test;

import ec.edu.ups.InstaWallet.modelo.Credito;
import ec.edu.ups.InstaWallet.modelo.DetalleCredito;
import ec.edu.ups.InstaWallet.repository.CreditoRepo;
import ec.edu.ups.InstaWallet.repository.DetalleCreditoRepo;
import ec.edu.ups.InstaWallet.services.CreditoService;
import ec.edu.ups.InstaWallet.services.DetalleCreditoService;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
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

/**
 *
 * @author EstAdolfoSebastianJa
 */
public class DetalleCreditoServiceTest {
    @InjectMocks
    DetalleCreditoService creditoService;

    @Mock
    DetalleCreditoRepo creditoRepo;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest
    @MethodSource("generator")
    public void saveCredito(DetalleCredito cre) {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(creditoService.save(any(DetalleCredito.class))).thenReturn(cre);

        DetalleCredito response = creditoService.save(cre);

        assertTrue(response.equals(cre));

    }

    @ParameterizedTest
    @MethodSource("generator")
    public void findByIdCredito(DetalleCredito cre) {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Optional<DetalleCredito> t = null;

        when(creditoService.findById(cre.getId())).thenReturn(t);

        Optional<DetalleCredito> response = creditoService.findById(cre.getId());

        assertNull(response);

    }

    @ParameterizedTest
    @MethodSource("generator")
    public void findAll(DetalleCredito cre) {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(creditoService.findAll()).thenReturn(Arrays.asList(cre));
        assertNotNull(creditoService.findAll());
    }


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
