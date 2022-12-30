package ec.edu.ups.InstaWallet.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import ec.edu.ups.InstaWallet.modelo.Credito;
import ec.edu.ups.InstaWallet.modelo.DetalleCuenta;
import ec.edu.ups.InstaWallet.modelo.Socio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ec.edu.ups.InstaWallet.controller.CuentaResController;
import ec.edu.ups.InstaWallet.modelo.Cuenta;
import ec.edu.ups.InstaWallet.services.CuentaService;


public class CuentaControllerTest {
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

    @ParameterizedTest
    @MethodSource("generadorCuenta")
    public void crearSocio(Cuenta cuenta){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(cuentaService.save(any(Cuenta.class))).thenReturn(cuenta);

        ResponseEntity<Cuenta> response = cuentaResController.crearCuenta(cuenta);
        assertTrue(response.getStatusCodeValue()==201);

    }

    static Stream<Cuenta> generadorCuenta(){

        Cuenta cuenta = new Cuenta();
        List<DetalleCuenta> dtc = new ArrayList<>();
        List<Credito> credito = new ArrayList<>();

        //creacion de usuario
        cuenta.setEstado(true);
        cuenta.setDetallesCuentas(dtc);
        cuenta.setCreditos(credito);
        cuenta.setNumerCuenta("001");
        cuenta.setMonto(100.00);
        cuenta.setFechaCreacion(new Date());
        cuenta.setSocioIdentificacion("0150019453");

        return Stream.of(cuenta);
    }
        

}
