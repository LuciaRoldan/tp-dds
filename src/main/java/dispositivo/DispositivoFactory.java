package dispositivo;

import exceptionDispositivo.DispositivoBaseInvalidoException;
import exceptionDispositivo.DispositivoConcretoInvalidoException;
import dispositivo.estados.*;

public class DispositivoFactory {
	private String nombre;
	
	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}
	
	public DispositivoBase crearAireAcondicionado(int frigorias) {
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
		return dispositivo;
	}
	
	public DispositivoBase crearHeladeraConFreezer() {
		DispositivoBase dispositivo = new DispositivoInteligente(nombre, new Apagado(), 0, 0);
		dispositivo.setBajoConsumo(true);
		dispositivo.setPotencia(0.09);
		return dispositivo;
	}
	
	public DispositivoBase crearHeladeraSinFreezer() {
		DispositivoBase dispositivo = new DispositivoInteligente(nombre, new Apagado(), 0, 0);
		dispositivo.setBajoConsumo(true);
		dispositivo.setPotencia(0.075);
		return dispositivo;
	}
	
	public DispositivoBase crearLamparaHalogena(int w) {
		DispositivoBase dispositivo = new DispositivoInteligente(nombre, new Apagado(), 0, 0);
		dispositivo.setBajoConsumo(false);
		if (w == 40) {
			dispositivo.setPotencia(0.4);
		} else if (w == 60) {
			dispositivo.setPotencia(0.6);
		} else if (w == 100) {
			dispositivo.setPotencia(0.015);
		}
		return dispositivo;
	}
	
	public DispositivoBase crearLamparaComun(int w) {
		DispositivoBase dispositivo = new DispositivoInteligente(nombre, new Apagado(), 0, 0);
		dispositivo.setBajoConsumo(true);
		if(w == 11) {
			dispositivo.setPotencia(0.011);
		} else if (w == 15) {
			dispositivo.setPotencia(0.015);
		} else if (w == 20) {
			dispositivo.setPotencia(0.2);
		}
		return dispositivo;
	}
	
	public DispositivoBase crearLavarropasAutomatico(boolean esAutomatico, boolean tieneCalentamiento, int capacidad) {
		DispositivoBase dispositivo;
		if (capacidad != 5) { 
			throw new DispositivoConcretoInvalidoException(); 
		}
		if (tieneCalentamiento) {
			dispositivo = new DispositivoEstandar(nombre, 6, 30);
			dispositivo.setBajoConsumo(false);
			dispositivo.setPotencia(0.875);
		} else {
			dispositivo = new DispositivoInteligente(nombre, new Apagado(), 0, 0);
			dispositivo.setPotencia(0.175);
			dispositivo.setBajoConsumo(true);
		}
		return dispositivo;
	}
	
	public DispositivoBase crearLavarropasSemiAutomatico(boolean esAutomatico, boolean tieneCalentamiento, int capacidad) {
		DispositivoBase dispositivo = new DispositivoEstandar(nombre, 6, 30);
		if (capacidad != 5) { 
			throw new DispositivoConcretoInvalidoException(); 
		}
		dispositivo.setPotencia(0.1275);
		dispositivo.setBajoConsumo(false);
		return dispositivo;
	}
	
	public DispositivoBase crearMicroondas() {
		DispositivoBase dispositivo = new DispositivoEstandar(nombre, 3, 15);
		dispositivo.setBajoConsumo(true);
		dispositivo.setPotencia(0.64);
		return dispositivo;
	}
	
	public DispositivoBase crearPC() {
		DispositivoBase dispositivo = new DispositivoEstandar(nombre, 60, 360);
		dispositivo.setPotencia(0.4);
		dispositivo.setBajoConsumo(true);
		return dispositivo;
	}
	
	public DispositivoBase crearPlancha() {
		DispositivoBase dispositivo = new DispositivoEstandar(nombre, 3, 30);
		dispositivo.setBajoConsumo(true);
		dispositivo.setPotencia(0.75);
		return dispositivo;
	}

	public DispositivoBase crearTelevisorDeTubo(int pulgadas) {
		DispositivoBase dispositivo = new DispositivoEstandar(nombre, 90, 360);
		dispositivo.setBajoConsumo(false);
		if (pulgadas == 21) {
			dispositivo.setPotencia(0.075);
		} else if (29 < pulgadas && pulgadas < 34) {
			dispositivo.setPotencia(0.175);
		} else {
			throw new DispositivoBaseInvalidoException();
		}
		return dispositivo;
	}
	
	public DispositivoBase crearTelevisorLCD(int pulgadas) {
		DispositivoBase dispositivo;
			if(pulgadas == 40) {
				dispositivo = new DispositivoEstandar(nombre, 90, 360);
				dispositivo.setPotencia(0.18);
			} else {
				throw new DispositivoBaseInvalidoException();
			}
		return dispositivo;
	}
	
	public DispositivoBase crearTelevisorLED(int pulgadas) {
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
		return dispositivo;
	}
	
	public DispositivoBase crearVentiladorDeTecho() {
		DispositivoBase dispositivo = new DispositivoInteligente(nombre, new Apagado(), 120, 360);
		dispositivo.setPotencia(0.06);
		dispositivo.setBajoConsumo(true);
		return dispositivo;
	}
	
	public DispositivoBase crearVentiladorDePie() {
		DispositivoBase dispositivo = new DispositivoEstandar(nombre, 120, 360);
		dispositivo.setPotencia(0.09);
		dispositivo.setBajoConsumo(true);
		return dispositivo;
	}

}
