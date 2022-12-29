/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.test;

import ec.edu.ups.InstaWallet.controller.CreditoRestController;
import ec.edu.ups.InstaWallet.modelo.Credito;
import ec.edu.ups.InstaWallet.modelo.DetalleCredito;
import ec.edu.ups.InstaWallet.repository.CreditoRepo;
import ec.edu.ups.InstaWallet.services.CreditoService;
import io.swagger.v3.oas.annotations.servers.Server;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;
import javax.transaction.Transactional;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

/**
 *
 * @author EstAdolfoSebastianJa
 */
public class CreditoControllerTest {
/*
    @Autowired
    private CreditoRestController creditoRestController;
    
    @Autowired
    private CreditoService creditoService;
    
    @Autowired
    private CreditoRepo creditoRepo;*/
    
    @InjectMocks
    CreditoRestController creditoRestController;
    
    @Mock
    CreditoService creditoService;
       
    
    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        
    }

   /* @ParameterizedTest
    @MethodSource("generator")
    public void shouldCreateContact(Credito cre) {
        System.out.println(cre.toString());
        
        CreditoService creditoService = new CreditoService(creditoRepo);
        CreditoRestController creditoRestController = new CreditoRestController(creditoService);
        
        Credito creditoGuardado = creditoRestController.crearCredito(cre);
        System.out.println(creditoGuardado);
        assertTrue(creditoGuardado.equals(cre));

    }*/
    
    
    @ParameterizedTest
    @MethodSource("generator")
    public void crearCredito(Credito cre){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(creditoService.save(any(Credito.class))).thenReturn(cre);
        
        Credito response = creditoRestController.crearCredito(cre);
        
        assertTrue(response.equals(cre));
        
    }
    
    @Test
    public void testTablaAmortizacion(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
               
        ArrayList<DetalleCredito> response = creditoRestController.generarTablaAmortizacion(12, new Date(), 1000.00);
        
        assertTrue(response.size() == 12);
        
    }

    @Test
    public void testAprobarRechazarCredito(){

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));


        creditoRestController.aprobarRechazarCredito(1, "Aprobar");

        if (creditoService.existsById(1)){
            Optional<Credito> c = creditoService.findById(1);

            assertTrue(c.get().getEstado().equals("Activo"));
        } else {
            assertFalse(creditoService.existsById(1));
        }

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
