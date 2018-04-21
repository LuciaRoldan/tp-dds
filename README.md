# 2018-vn-group-19

/////////////////////////////////////////////// CONSUMO CLIENTE ////////////////////////////////////////////////////////
El consumo MENSUAL de cada cliente esta compuesto por la suma de todos los kWh de sus dispositivos encendidos.


///////////////////////////////////////////// PARSER //////////////////////////////////////////////////////////////////////////
Cosas a tener en cuenta:

El parser lee un archivo nombre.json que contiene una lista de Usuarios, y devuelve dicha lista.

Ejemplo de un archivo json

[
	{
		"categoriaResidencial": "CATEGORIAR5",
		"nombreYapellido": "MatiasMorsa",
		"tipoDocumento": "DNI",
		"nombreDeUsuario": "Matias21313",
		"domicilio": "Av.del libertador 2000",
		"telefono": 44444444,
		"documento": 1234456,
		"contrasena": "123321",
		"fechaDeAlta": "01012001",
		"tipoDeUsuario": "CLIENTE",
		"sarasa": "sarasa",
		"dispositivos":[{

				"nombre": "Eco Tostadora",
				"kWh": "1",
				"encendido": true,
				"tipoDeDispositivo": "INTELIGENTE"
    }
]

En este caso tiene un usuario con categoria CLIENTE y el cliente tiene una lista de dispositivos.
