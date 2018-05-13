package dispositivos;

public class DispositivoEstandar extends TipoDeDispositivo {
	
	private Long kWh;
	private int horasDeUsoPorDia;
	
	
	@Override
	public Long consumoMensual() {
		return kWh*horasDeUsoPorDia*30;
	}
	
	@Override
	public boolean esInteligente() {
		return false;
	}
	
	
	
	
	/////////////GETTERS/////////////
    public Long getkWh() {
		return kWh;
	}

	public int getHorasDeUsoPorDia() {
		return horasDeUsoPorDia;
	}

	/////////////SETTERS/////////////
	public void setkWh(Long kWh) {
		this.kWh = kWh;
	}

	public void setHorasDeUsoPorDia(int horasDeUsoPorDia) {
		this.horasDeUsoPorDia = horasDeUsoPorDia;
	}








	@Override
    public String getNombre(){return "ESTANDAR";}

}
