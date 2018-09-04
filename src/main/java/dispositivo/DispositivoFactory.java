package dispositivo;

import exceptionDispositivo.DispositivoBaseInvalidoException;
import exceptionDispositivo.DispositivoConcretoInvalidoException;
import dispositivo.estados.*;
import dispositivosConcretos.*;

public class DispositivoFactory {
	private String nombre = null;
	double horasUsoMensuales = -1;
	
	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}
	
	public void setHorasUsoMensuales(double horasUsoMensuales) {
		this.horasUsoMensuales = horasUsoMensuales;
	}
	
	public void verificarNombre() {
		if(this.nombre == null) {
			throw new DispositivoBaseInvalidoException();
		}
	}
	
	public void verificarHorasUsoMensuales() {
		if(this.horasUsoMensuales == -1) {
			throw new DispositivoBaseInvalidoException();
		}
	}
	
	public AireAcondicionado crearAireAcondicionado(int frigorias) {
		this.verificarNombre();
		DispositivoBase dispositivo = new DispositivoInteligente(nombre, new Apagado(), 90, 360);
		if(frigorias == 2200) {
			dispositivo.setPotencia(1.013);
			dispositivo.setBajoConsumo(true);
		} else if (frigorias == 3500) {
			dispositivo.setPotencia(1.613);
			dispositivo.setBajoConsumo(false);
		} else {
			throw new DispositivoConcretoInvalidoException();
		}
		return new AireAcondicionado(dispositivo, frigorias);
	}
	
	public Heladera crearHeladeraConFreezer() {
		this.verificarNombre();
		DispositivoBase dispositivo = new DispositivoInteligente(nombre, new Apagado(), 0, 0);
		dispositivo.setBajoConsumo(true);
		dispositivo.setPotencia(0.09);
		return new Heladera(dispositivo, true);
	}
	
	public Heladera crearHeladeraSinFreezer() {
		this.verificarNombre();
		DispositivoBase dispositivo = new DispositivoInteligente(nombre, new Apagado(), 0, 0);
		dispositivo.setBajoConsumo(true);
		dispositivo.setPotencia(0.075);
		return new Heladera(dispositivo, false);
	}
	
	public Lampara crearLamparaHalogena(int w) {
		this.verificarNombre();
		DispositivoBase dispositivo = new DispositivoEstandar(nombre, 0, 100, 50);
		dispositivo.setBajoConsumo(false);
		if (w == 40) {
			dispositivo.setPotencia(0.4);
		} else if (w == 60) {
			dispositivo.setPotencia(0.6);
		} else if (w == 100) {
			dispositivo.setPotencia(0.015);
		}
		return new Lampara(dispositivo, true, w);
	}
	
	public Lampara crearLamparaComun(int w) {
		this.verificarNombre();
		DispositivoBase dispositivo = new DispositivoInteligente(nombre, new Apagado(), 0, 0);
		dispositivo.setBajoConsumo(true);
		if(w == 11) {
			dispositivo.setPotencia(0.011);
		} else if (w == 15) {
			dispositivo.setPotencia(0.015);
		} else if (w == 20) {
			dispositivo.setPotencia(0.2);
		}
		return new Lampara(dispositivo, false, w);
	}
	
	public Lavarropas crearLavarropasAutomatico(boolean tieneCalentamiento, int capacidad) {
		this.verificarNombre();
		DispositivoBase dispositivo;
		if (capacidad != 5) { 
			throw new DispositivoConcretoInvalidoException(); 
		}
		if (tieneCalentamiento) {
			verificarHorasUsoMensuales();
			dispositivo = new DispositivoEstandar(nombre, 6, 30, horasUsoMensuales);
			dispositivo.setBajoConsumo(false);
			dispositivo.setPotencia(0.875);
		} else {
			dispositivo = new DispositivoInteligente(nombre, new Apagado(), 0, 0);
			dispositivo.setPotencia(0.175);
			dispositivo.setBajoConsumo(true);
		}
		return new Lavarropas(dispositivo, true, tieneCalentamiento, capacidad);
	}
	
	public Lavarropas crearLavarropasSemiAutomatico(boolean tieneCalentamiento, int capacidad) {
		this.verificarNombre();
		verificarHorasUsoMensuales();
		DispositivoBase dispositivo = new DispositivoEstandar(nombre, 6, 30, horasUsoMensuales);
		if (capacidad != 5) { 
			throw new DispositivoConcretoInvalidoException(); 
		}
		dispositivo.setPotencia(0.1275);
		dispositivo.setBajoConsumo(false);
		return new Lavarropas(dispositivo, true, tieneCalentamiento, capacidad);
	}
	
	public Microondas crearMicroondas() {
		this.verificarNombre();
		verificarHorasUsoMensuales();
		DispositivoBase dispositivo = new DispositivoEstandar(nombre, 3, 15, horasUsoMensuales);
		dispositivo.setBajoConsumo(true);
		dispositivo.setPotencia(0.64);
		return new Microondas(dispositivo, true);
	}
	
	public PC crearPC() {
		this.verificarNombre();
		verificarHorasUsoMensuales();
		DispositivoBase dispositivo = new DispositivoEstandar(nombre, 60, 360, horasUsoMensuales);
		dispositivo.setPotencia(0.4);
		dispositivo.setBajoConsumo(true);
		return new PC(dispositivo, true);
	}
	
	public Plancha crearPlancha() {
		this.verificarNombre();
		verificarHorasUsoMensuales();
		DispositivoBase dispositivo = new DispositivoEstandar(nombre, 3, 30, horasUsoMensuales);
		dispositivo.setBajoConsumo(true);
		dispositivo.setPotencia(0.75);
		return new Plancha(dispositivo, true);
	}

	public Televisor crearTelevisorDeTubo(int pulgadas) {
		this.verificarNombre();
		verificarHorasUsoMensuales();
		DispositivoBase dispositivo = new DispositivoEstandar(nombre, 90, 360, horasUsoMensuales);
		dispositivo.setBajoConsumo(false);
		if (pulgadas == 21) {
			dispositivo.setPotencia(0.075);
		} else if (29 < pulgadas && pulgadas < 34) {
			dispositivo.setPotencia(0.175);
		} else {
			throw new DispositivoBaseInvalidoException();
		}
		return new Televisor(dispositivo, TipoPantalla.TF, pulgadas);
	}
	
	public Televisor crearTelevisorLCD(int pulgadas) {
		this.verificarNombre();
		DispositivoBase dispositivo;
			if(pulgadas == 40) {
				verificarHorasUsoMensuales();
				dispositivo = new DispositivoEstandar(nombre, 90, 360, horasUsoMensuales);
				dispositivo.setPotencia(0.18);
			} else {
				throw new DispositivoBaseInvalidoException();
			}
		return new Televisor(dispositivo, TipoPantalla.LCD, pulgadas);
	}
	
	public Televisor crearTelevisorLED(int pulgadas) {
		this.verificarNombre();
		DispositivoBase dispositivo = new DispositivoInteligente(nombre, new Apagado(), 90, 360);
			dispositivo.setBajoConsumo(true);
			if (pulgadas == 24) {
				dispositivo.setPotencia(0.04);
			} else if (pulgadas == 32) {
				dispositivo.setPotencia(0.055);
			} else if (pulgadas == 40) {
				dispositivo.setPotencia(0.08);
			} else {
				throw new DispositivoBaseInvalidoException();
			}
		return new Televisor(dispositivo, TipoPantalla.LED, pulgadas);
	}
	
	public Ventilador crearVentiladorDeTecho() {
		this.verificarNombre();
		DispositivoBase dispositivo = new DispositivoInteligente(nombre, new Apagado(), 120, 360);
		dispositivo.setPotencia(0.06);
		dispositivo.setBajoConsumo(true);
		return new Ventilador(dispositivo, true);
	}
	
	public Ventilador crearVentiladorDePie() {
		this.verificarNombre();
		verificarHorasUsoMensuales();
		DispositivoBase dispositivo = new DispositivoEstandar(nombre, 120, 360, horasUsoMensuales);
		dispositivo.setPotencia(0.09);
		dispositivo.setBajoConsumo(true);
		return new Ventilador(dispositivo, false);
	}

}
