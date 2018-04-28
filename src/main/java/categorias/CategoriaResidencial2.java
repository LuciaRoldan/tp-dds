package categorias;

public enum CategoriaResidencial2 {
	
	categoriaR1(){
		private Double CARGOVARIABLE =  0.644; //Le saqué el static a todos porque si no tiraba error
	    private Double CARGOFIJO     =  18.76;
	    private Double CONSUMOMAXIMO = 150.00;
	    private Double CONSUMOMINIMO =   0.00;
	},
	categoriaR2(){
	    private Double CARGOVARIABLE =  0.644;
	    private Double CARGOFIJO     =  35.32;
	    private Double CONSUMOMAXIMO = 325.00;
	    private Double CONSUMOMINIMO = 150.00;
	},
	categoriaR3(){
	    private Double CARGOVARIABLE =  0.681;
	    private Double CARGOFIJO     =  60.71;
	    private Double CONSUMOMAXIMO = 400.00;
	    private Double CONSUMOMINIMO = 325.00;
	},
	categoriaR4(){
	    private Double CARGOVARIABLE =  0.738;
	    private Double CARGOFIJO     =  71.74;
	    private Double CONSUMOMAXIMO = 450.00;
	    private Double CONSUMOMINIMO = 400.00;
	},
	categoriaR5(){
	    private Double CARGOVARIABLE =  0.794;
	    private Double CARGOFIJO     = 110.38;
	    private Double CONSUMOMAXIMO = 500.00;
	    private Double CONSUMOMINIMO = 450.00;
	},
	categoriaR6(){
	    private Double CARGOVARIABLE =  0.832;
	    private Double CARGOFIJO     = 220.75;
	    private Double CONSUMOMAXIMO = 600.00;
	    private Double CONSUMOMINIMO = 500.00;
	},
	categoriaR7(){
	    private Double CARGOVARIABLE =  0.851;
	    private Double CARGOFIJO     = 443.59;
	    private Double CONSUMOMAXIMO = 700.00;
	    private Double CONSUMOMINIMO = 600.00;
	},
	categoriaR8(){
	    private Double CARGOVARIABLE = 0.851;
	    private Double CARGOFIJO     = 545.96;
	    private Double CONSUMOMAXIMO = 1400.00;
	    private Double CONSUMOMINIMO = 700.00;
	},
	categoriaR9(){
	    private Double CARGOVARIABLE =   0.851;
	    private Double CARGOFIJO     =  887.19;
	    private Double CONSUMOMAXIMO =   -1.00;  //NO TIENE CONSUMO MAXIMO
	    private Double CONSUMOMINIMO = 1400.00;
	};

	private static Double CARGOVARIABLE;
    private static Double CARGOFIJO;
    private static Double CONSUMOMAXIMO;
    private static Double CONSUMOMINIMO;
    
}
