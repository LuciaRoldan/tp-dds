package dispositivo.estados;

import dispositivo.DispositivoInteligente;
import dispositivo.DispositivoInteligenteAbstracto;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class EstadoDispositivo {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	public int idEstado;
	
	public LocalDateTime inicio;
	public LocalDateTime fin;

	public abstract boolean estaEncendido();

	public abstract boolean estaApagado();

	public abstract void apagate(DispositivoInteligenteAbstracto dispositivo);

	public abstract void encendete(DispositivoInteligenteAbstracto dispositivo);

	public abstract void activarAhorroDeEnergia(DispositivoInteligenteAbstracto dispositivoInteligenteConcreto);
	
	//
	public abstract double consumoTotal(double potencia);

	public abstract double calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin, double potencia);
	//
	
	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}
	
	public LocalDateTime getInicio() {
		return inicio;
	}
		
	public LocalDateTime getFin() {
		return fin;
	}

	public boolean incluyeA(LocalDateTime x) {
		if(this.fin==null){
			return this.inicio.compareTo(x) * x.compareTo(LocalDateTime.now()) >=0;
		}
		return this.inicio.compareTo(x) * x.compareTo(this.fin) >= 0;
	}
	
	
	public double tiempoEnHoras() {
		if (this.fin == null){
			return (double)this.inicio.until(LocalDateTime.now(), ChronoUnit.MINUTES)/60;
		}else {
			return (double)this.inicio.until(this.fin, ChronoUnit.MINUTES)/60;
		}
	}
	
	public double tiempoEnHorasEnIntervalo(LocalDateTime inicio, LocalDateTime fin) {
		if(this.fin==null) {
			return this.tiempoEnHorasEnIntervaloSinFin(inicio, fin);
		}
		else if(inicio.isBefore(this.inicio) && this.incluyeA(fin)) {
			return (double)this.inicio.until(fin, ChronoUnit.MINUTES)/60;
		}else if(fin.isAfter(this.fin) && this.incluyeA(inicio)) {
			return (double)inicio.until(this.fin,ChronoUnit.MINUTES)/60;
		}else if(this.incluyeA(inicio) && this.incluyeA(inicio)) {
			return (double)inicio.until(fin, ChronoUnit.MINUTES)/60;
		}else if(inicio.isBefore(this.inicio) && fin.isAfter(this.fin)) {
			return this.tiempoEnHoras();
		}else{
			return 0;
		}
	}
	
	public double tiempoEnHorasEnIntervaloSinFin(LocalDateTime inicio, LocalDateTime fin) {
		LocalDateTime ahora = LocalDateTime.now();
		
		if(this.incluyeA(inicio) && this.incluyeA(fin)) {
			return (double)inicio.until(fin, ChronoUnit.MINUTES)/60;
		}else if(inicio.isBefore(this.inicio) && this.incluyeA(fin)) {
			return (double)this.inicio.until(fin, ChronoUnit.MINUTES)/60;
		}else if(this.incluyeA(inicio) && fin.isAfter(ahora)) {
			return (double)inicio.until(ahora, ChronoUnit.MINUTES)/60;
		}else if(inicio.isBefore(this.inicio) && fin.isAfter(ahora) ) {
			return this.tiempoEnHoras();
		}else return 0;
	}
	
	public void mostrarHoras() {
		if(inicio != null && fin != null) {
			System.out.println(inicio.until(fin, ChronoUnit.MINUTES)/60);
		}else if(inicio == null) {
			System.out.println("inicio null");
		}else System.out.println("fin null");
	}


}
