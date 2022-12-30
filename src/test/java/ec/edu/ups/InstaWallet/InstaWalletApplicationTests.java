package ec.edu.ups.InstaWallet;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ec.edu.ups.InstaWallet.controller.ConfiguracionRestController;
import ec.edu.ups.InstaWallet.controller.CreditoRestController;
import ec.edu.ups.InstaWallet.controller.DetalleCreditoRestController;
import ec.edu.ups.InstaWallet.controller.DetalleCuentaRestController;
import ec.edu.ups.InstaWallet.controller.SocioRestController;
import ec.edu.ups.InstaWallet.controller.UsuarioRestConroller;
import ec.edu.ups.InstaWallet.modelo.Configuracion;
import ec.edu.ups.InstaWallet.modelo.Credito;
import ec.edu.ups.InstaWallet.modelo.Cuenta;
import ec.edu.ups.InstaWallet.modelo.DetalleCredito;
import ec.edu.ups.InstaWallet.modelo.DetalleCuenta;
import ec.edu.ups.InstaWallet.modelo.Socio;
import ec.edu.ups.InstaWallet.modelo.Usuario;
import ec.edu.ups.InstaWallet.services.ConfiguracionService;
import ec.edu.ups.InstaWallet.services.CreditoService;
import ec.edu.ups.InstaWallet.services.DetalleCreditoService;
import ec.edu.ups.InstaWallet.services.DetalleCuentaService;
import ec.edu.ups.InstaWallet.services.SocioService;
import ec.edu.ups.InstaWallet.services.UsuarioService;

//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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
//import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@SpringBootTest
class InstaWalletApplicationTests {

	@InjectMocks
    CreditoRestController creditoRestController;
	@InjectMocks
	ConfiguracionRestController configuracionRestController;
	@InjectMocks
	UsuarioRestConroller usuarioRestConroller;
    @InjectMocks
	SocioRestController socioRestController;
    @InjectMocks
	DetalleCuentaRestController detalleCuentaRestController;
    @InjectMocks
	DetalleCreditoRestController detalleCreditoRestController;

    @Mock
    CreditoService creditoService;
	@Mock
	ConfiguracionService configuracionService;
	@Mock
	UsuarioService usuarioService;
    @Mock
	SocioService socioService;
    @Mock
	DetalleCuentaService detalleCuentaService;
    @Mock
	DetalleCreditoService detalleCreditoService;
       
    
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
    
    static Stream<Credito> generator() {
        
        Credito cre = new Credito();
		//creacion de credito
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


	//creacion de configuracion
	static Stream<Configuracion> generadorConfig(){

		Configuracion confi = new Configuracion();

		//creacion de configuacion
		confi.setNombreEmpresa("GOGO");
		confi.setLogo("Tu placer es nuestra meta");
		confi.setCorreoEmpresa("gogo@gmail.com");

		return Stream.of(confi);
	}

	@ParameterizedTest
    @MethodSource("generadorConfig")
    public void crearConfig(Configuracion config){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(configuracionService.actualizar(any(Configuracion.class))).thenReturn(config);
        
        Configuracion response = configuracionRestController.actualizar(config);
        
        assertTrue(response.equals(config));
        
    }

	//creacion de Usuario
	static Stream<Usuario> generadorUsuario(){

		Usuario usu = new Usuario();

		//creacion de usuario
		usu.setIdentificadorUsuario("0150019453");
		usu.setCargo("Admin");
		usu.setCorreo("ejemplo@est.ups.edu.ec");
		usu.setNombre("Denys Dutan");
		usu.setPassword("ejemplo");

		return Stream.of(usu);
	}

	//Test Crear Usuario
	@ParameterizedTest
    @MethodSource("generadorUsuario")
    public void crearUsuario(Usuario usu){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(usuarioService.guardar(any(Usuario.class))).thenReturn(usu);
        
        Usuario response = usuarioRestConroller.createUsuario(usu);
        
        assertTrue(response.equals(usu));
        
    }

	//Test findAll Usuario
	@ParameterizedTest
    @MethodSource("generadorUsuario")
	public void findAllUsuarios(Usuario usu){
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		when(usuarioRestConroller.findAll()).thenReturn(Arrays.asList(usu));
		assertNotNull(usuarioRestConroller.findAll());
	}

	//test findByIdUsuario
	@ParameterizedTest
    @MethodSource("generadorUsuario")
	public void findByIdUsuarios(Usuario usu){
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		String id ="0150019453";
		when(usuarioRestConroller.findUsuario(id)).thenReturn(usu);
		assertNotNull(usuarioRestConroller.findUsuario(id));
	}

    	//creacion de Socio
	static Stream<Socio> generadorSocio(){

		Socio socio = new Socio();
        List<Cuenta> c = new ArrayList<>();

		//creacion de usuario
		socio.setCorreoSocio("ejemplo@gmail.com");
        socio.setCuentas(c);
        socio.setIdentificacionSocio("0150019453");
        socio.setNombreSocio("Denys Dutan");
        socio.setTelefonoSocio("0987654321");

		return Stream.of(socio);
	}

    //Test Crear Socio
	@ParameterizedTest
    @MethodSource("generadorSocio")
    public void crearSocio(Socio socio){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(socioService.crearSocio(any(Socio.class))).thenReturn(socio);
        
        ResponseEntity<Socio> response = socioRestController.crear(socio);
        assertTrue(response.getStatusCodeValue()==201);
        
    }

    //Test findAll Socio
	@ParameterizedTest
    @MethodSource("generadorSocio")
	public void findAllSocios(Socio socio){
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		when(socioRestController.lista()).thenReturn(Arrays.asList(socio));
		assertNotNull(socioRestController.lista());
	}

        	//creacion de Usuario
	static Stream<DetalleCuenta> generadorDetalleCuenta(){

		DetalleCuenta detalleCuenta = new DetalleCuenta();
        detalleCuenta.setCuentaCodigo("001");
        detalleCuenta.setFecha(new Date());
        detalleCuenta.setId(1);
        detalleCuenta.setTipoMovimiento("DEPOSITO");
        detalleCuenta.setValor(250.00);

		return Stream.of(detalleCuenta);
	}

     //Test findAll Detalle cuenta
	@ParameterizedTest
    @MethodSource("generadorDetalleCuenta")
	public void findAlldetalleC(DetalleCuenta detalleCuenta){
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		when(detalleCuentaRestController.listarAportaciones()).thenReturn(Arrays.asList(detalleCuenta));
		assertNotNull(detalleCuentaRestController.listarAportaciones());
	}

    static Stream<DetalleCredito> generatorDetalleCredito() {

        DetalleCredito cre = new DetalleCredito();
        cre.setId(1);
        cre.setFechaPago(new Date());
        cre.setValorPago(100.0);
        cre.setEstado("Pagado");

        return Stream.of(
                cre
        );

    }

    @ParameterizedTest
    @MethodSource("generatorDetalleCredito")
	public void findAlldetalleCredito(DetalleCredito detalleCredito){
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		when(detalleCreditoRestController.listarDetallesCuentas()).thenReturn(Arrays.asList(detalleCredito));
		assertNotNull(detalleCreditoRestController.listarDetallesCuentas());
	}



}
