package com.eduit.spring.clase2.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eduit.spring.clase2.conf.SpringConfig;
import com.eduit.spring.clase2.model.CajaAhorro;
import com.eduit.spring.clase2.model.Cliente;
import com.eduit.spring.clase2.model.CuentaCorriente;
import com.eduit.spring.clase2.model.Poliza;
import com.eduit.spring.clase2.model.Resumen;
import com.eduit.spring.clase2.model.Seguro;
import com.eduit.spring.clase2.model.Tarjeta;
import com.eduit.spring.clase2.service.ClienteService;
import com.eduit.spring.clase2.service.TarjetaService;

/**
 * Created by Marcelo on 27/03/2015.
 */
public class App {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		ClienteService clienteService = context.getBean(ClienteService.class);
		TarjetaService tarjetaService = context.getBean(TarjetaService.class);

		// creo Cliente
//		 Cliente cliente = new Cliente();
//		 cliente.setNombre("juan perez");
//		 cliente.setDireccion("calle falsa 1234");
		// //creo Caja de Ahorro
//		 CajaAhorro ch = new CajaAhorro();
//		 ch.setIntereses(0.5f);
//		 ch.setSaldo(10000d);
		// //creo Cuenta Corriente
//		 CuentaCorriente cc = new CuentaCorriente();
//		 cc.setDescubierto(10000d);
//		 cc.setSaldo(9000000d);
		// //agrego Cuenta Corriente y Caja de Ahorro al cliente
//		 cliente.getCuentas().add(cc);
//		 cliente.getCuentas().add(ch);
		// //Creo un seguro
//		 Seguro seguro = new Seguro();
//		 seguro.setSumaAsegurada(10000d);
		// // creo una poliza
//		 Poliza poliza = new Poliza();
//		 poliza.setTextoPoliza("poliza por seguro $ 10000");
		// //Agrego poliza a seguro
//		 seguro.setPoliza(poliza);
		// //Agrego cliente a seguro
//		 cliente.getSeguros().add(seguro);
		//
//		 clienteService.saveCliente(cliente);

//		List<Cliente> clientes = clienteService.getClientesBydireccion("calle falsa 1234");

//		 Cuenta cuenta = new Cuenta();
//		 cuenta.setId(1l);
//		
//		 List<Cliente> clientes = clienteService.getClientesByCuentas(cuenta);
//		//
//		for (Cliente cliente : clientes) {
//			System.out.println(cliente);
//		}

//		List<Cuenta> cuentas = clienteService.getById(1l).getCuentas();
//
//		for (Cuenta cuenta : cuentas) {
//			System.out.println(cuenta);
//		}
		
		Cliente cliente = clienteService.getById(1L);
		
		 // Creo tarjeta 1
//		Tarjeta tarjeta1 = new Tarjeta();
//		tarjeta1.setSaldo(new Double(1000.0));
		
		// Creo resumen 1 para tarjeta 1
//		Resumen resumen1 = new Resumen();
//		resumen1.setDescricion("resumen 1");
//		resumen1.setTarjeta(tarjeta1);
//		tarjeta1.getResumenes().add(resumen1);
//		
//		cliente.getTarjetas().add(tarjeta1);
		
		// Creo tarjeta 2
//		Tarjeta tarjeta2 = new Tarjeta();
//		tarjeta2.setSaldo(new Double(2000.0));

		// Creo resumen 2 para tarjeta 2
//		Resumen resumen2 = new Resumen();
//		resumen2.setDescricion("resumen 2");
//		resumen2.setTarjeta(tarjeta2);
//		tarjeta2.getResumenes().add(resumen2);
		
//		cliente.getTarjetas().add(tarjeta2);
		
//		for (Tarjeta tarjeta : cliente.getTarjetas()) {
//			tarjetaService.deleteTarjeta(tarjeta);
//		}
		
		
		
		// Borro la tarjeta 1
		cliente.getTarjetas().remove(0);
		clienteService.saveCliente(cliente);
		
		System.out.println("allalal");
	}
}
