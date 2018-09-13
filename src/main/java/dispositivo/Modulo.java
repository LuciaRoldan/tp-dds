package dispositivo;

import exceptionDispositivo.dispositivoInteligente.NoSePuedeAgregarOtroModuloAdicionalException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import dispositivo.estados.EstadoDispositivo;

public class Modulo implements DispositivoInteligenteAbstracto {

    DispositivoBase dispositivoEstandar;
    private EstadoDispositivo estado;
    private ArrayList<EstadoDispositivo> estadosAnteriores = new ArrayList<EstadoDispositivo>();


    ///////////////// CONSTRUCTOR /////////////////////////////////////////////////////

    public Modulo(DispositivoBase dispositivoEstandar,EstadoDispositivo estadoDispositivo){
        this.dispositivoEstandar = dispositivoEstandar;
        this.setEstado(estadoDispositivo);
    }

    //////////////// SETTERS Y GETTERS ////////////////

    //GETTERS
    public EstadoDispositivo getEstado() {      return this.estado;  }
    public double getPotencia(){return this.dispositivoEstandar.getPotencia();}
   	public double getUsoMensualMinimo() { return this.dispositivoEstandar.getUsoMensualMinimo();}
   	public double getUsoMensualMaximo() { return this.dispositivoEstandar.getUsoMensualMaximo();}
   	public double getHorasDeUsoIdeal() {return this.dispositivoEstandar.getHorasDeUsoIdeal();}
    public boolean esInteligente() {return true;}
    
    //SETTERS
    public void setEstado(EstadoDispositivo estado) {    this.estado = estado; }
    public String getName(){return this.dispositivoEstandar.getName();}
    public void setName(String name){this.dispositivoEstandar.setName(name);}
    public void setPotencia(double potencia){this.dispositivoEstandar.setPotencia(potencia);}
    public void setBajoConsumo(boolean bajoConsumo) {this.dispositivoEstandar.setBajoConsumo(bajoConsumo);}


    ///////////////////// METODOS /////////////////////

    public void agregarModulo(){throw new NoSePuedeAgregarOtroModuloAdicionalException(this);}

    public void agregarEstado(EstadoDispositivo estado) { estadosAnteriores.add(estado); }
    
    public double consumoMensual() {
        return calcularConsumoPeriodo(LocalDateTime.now().minusMonths(1), LocalDateTime.now());
    }

    public double calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin) {
        ArrayList<EstadoDispositivo> estadosCompletosPeriodo = new ArrayList<EstadoDispositivo>();
        ArrayList<EstadoDispositivo> estadosBordePeriodo = new ArrayList<EstadoDispositivo>();
        double potencia = this.dispositivoEstandar.getPotencia();

        estadosAnteriores.stream().filter(estado -> estado.estaComprendido(inicio, fin))
                .forEach(estado -> estadosCompletosPeriodo.add(estado));
        estadosAnteriores.stream().filter(estado -> estado.esCasoBorder(inicio, fin))
                .forEach(estado -> estadosBordePeriodo.add(estado));

        return estadosCompletosPeriodo.stream().mapToDouble(estado -> estado.calcularConsumo(potencia)).sum()
                + estadosBordePeriodo.stream().mapToDouble(estado -> estado.calcularConsumoBorder(inicio, fin, potencia)).sum();
    }


    public double calcularConsumoUltimasNHoras(int horas) {
        return this.calcularConsumoPeriodo(LocalDateTime.now().minusHours(horas), LocalDateTime.now());
    }

    public double consumoCorriente() {
		int mesActual = LocalDate.now().getMonthValue();
		int anoActual = LocalDate.now().getYear();
		LocalDateTime fechaInicio = LocalDateTime.of(anoActual, mesActual, 1, 0, 0, 0);
		return this.calcularConsumoPeriodo(fechaInicio, LocalDateTime.now());		
	}
    
	public double consumoPromedioPorHora(LocalDateTime inicio, LocalDateTime fin) {
		double cantidadHoras = inicio.until(fin, ChronoUnit.HOURS);
		return this.calcularConsumoPeriodo(inicio, fin) / cantidadHoras;
	}
    
    public boolean estaEncendido() {  return estado.estaEncendido(); }

    public boolean estaApagado() {return estado.estaApagado();  }

    public void encendete() { estado.encendete(this); }
    
    public void apagate() {estado.apagate(this);}

    public void activarAhorroDeEnergia() { estado.activarAhorroDeEnergia(this); }
    
    

}
