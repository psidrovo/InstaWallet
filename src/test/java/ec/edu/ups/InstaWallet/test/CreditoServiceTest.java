/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.test;

import ec.edu.ups.InstaWallet.modelo.Credito;
import ec.edu.ups.InstaWallet.repository.CreditoRepo;
import ec.edu.ups.InstaWallet.services.CreditoService;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
//import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
//import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author EstAdolfoSebastianJa
 */
@SpringBootTest
public class CreditoServiceTest {

    //private List<Credito> listCreditos = new ArrayList<>();
    @InjectMocks
    CreditoService creditoService;

    @Mock
    CreditoRepo creditoRepo;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest
    @MethodSource("generator")
    public void saveCredito(Credito cre) {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(creditoService.save(any(Credito.class))).thenReturn(cre);

        Credito response = creditoService.save(cre);

        assertTrue(response.equals(cre));

    }

    @ParameterizedTest
    @MethodSource("generator")
    public void findByIdCredito(Credito cre) {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Optional<Credito> t = null;

        when(creditoService.findById(cre.getId())).thenReturn(t);

        Optional<Credito> response = creditoService.findById(cre.getId());

        assertNull(response);

    }

    @ParameterizedTest
    @MethodSource("generator")
    public void findAllUsuarios(Credito cre) {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(creditoService.findAll()).thenReturn(Arrays.asList(cre));
        assertNotNull(creditoService.findAll());
    }

    @ParameterizedTest
    @MethodSource("generator")
    public void calcularPagoMensual(Credito cre) {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        CreditoService mock = org.mockito.Mockito.mock(CreditoService.class);

        when(mock.calcularPagoMensual(cre.getValorCredito(), cre.getNumeroDeCuotas())).thenReturn(100.0);

        double response = creditoService.calcularPagoMensual(cre.getValorCredito(), cre.getNumeroDeCuotas());

        assertNotNull(response);

    }

    @ParameterizedTest
    @MethodSource("generator")
    public void calculoInteres(Credito cre) {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        CreditoService mock = org.mockito.Mockito.mock(CreditoService.class);

        when(mock.calculoInteres(cre.getValorCredito())).thenReturn(0.05);

        double response = creditoService.calculoInteres(cre.getValorCredito());

        assertTrue(response == 0.05);

    }

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
