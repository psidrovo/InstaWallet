package ec.edu.ups.InstaWallet.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ec.edu.ups.InstaWallet.controller.CuentaResController;
import ec.edu.ups.InstaWallet.modelo.Credito;
import ec.edu.ups.InstaWallet.modelo.Cuenta;
import ec.edu.ups.InstaWallet.modelo.DetalleCredito;
import ec.edu.ups.InstaWallet.services.CuentaService;


public class CuentaServiceTest {
	@InjectMocks
    CuentaResController cuentaResController;
    
    @Mock
    CuentaService cuentaService;
       
    
    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        
    }
    
    /*@ParameterizedTest
    @MethodSource("generator")
    public void crearCuenta(Cuenta cue){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(cuentaService.save(any(Cuenta.class))).thenReturn(cue);
        
        Cuenta response = cuentaResController.crearCuenta(cue);
        
        assertTrue(response.equals(cre));
        
    }*/
    
    @Test
    public void testListarCuentas(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
               
        List<Cuenta> response = cuentaResController.listarCuentas();
        
        
        assertFalse(!response.isEmpty());
    }
    
    @Test
    public void testActualizarEstado(){

       /* MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));


        cuentaResController.actualizarEstado("0001", true);

        Cuenta cuenta = cuentaService.findByNumerCuenta("0001");
        
        if(cuenta!=null) {
        	 assertTrue(cuenta.isEstado());
			
		}else {
			assertFalse(cuenta.isEstado());  
		}*/

    }
    
    
        

}
