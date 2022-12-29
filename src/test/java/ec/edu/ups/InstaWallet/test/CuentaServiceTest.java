package ec.edu.ups.InstaWallet.test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ec.edu.ups.InstaWallet.controller.CuentaResController;
import ec.edu.ups.InstaWallet.modelo.Cuenta;
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
