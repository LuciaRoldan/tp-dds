# 2018-vn-group-19

### Estado Actual
- [X] Tests Usuario Cliente (parte 1)
- [X] Tests Usuarios Administradores (parte 1)
- [X] Tests Categorias 1, 5 y 9
- [X] Tests Parser Usuario Cliente
- [X] Tests Parser Usuario Administrador
- [ ] Cliente se recategoriza (parte 2)
- [X] Cliente calcula su consumo mensual (parte 2)
- [ ] Test Cliente (parte 2)

### CONSUMO CLIENTE:
El consumo **MENSUAL** de cada cliente esta compuesto por la suma de todos los kWh de sus dispositivos encendidos.

### RECATEGORIZACION DEL CLIENTE:
El cliente debe poder recategorizarse cada tres meses, para esta primera implementacion debe poder hacerlo sin tener en cuenta el tiempo.

#### Categorias de clientes

```JAVA
  CATEGORIAS:
  R1       C <= 150  cargo fijo = 18.76  cargo variable = 0.644
  R2 150 < C <= 325  cargo fijo = 35.32  cargo variable = 0.644
  R3 325 < C <= 400  cargo fijo = 60.71  cargo variable = 0.681
  R4 400 < C <= 450  cargo fijo = 71.74  cargo variable = 0.738
  R5 450 < C <  500  cargo fijo = 110.38 cargo variable = 0.794
  R6 500 < C <= 600  cargo fijo = 220.75 cargo variable = 0.832
  R7 600 < C <= 700  cargo fijo = 443.59 cargo variable = 0.851
  R8 700 < C <= 1400 cargo fijo = 545.96 cargo variable = 0.851
  R9       C >  1400 cargo fijo = 887.19 cargo variable = 0.851
                                                                    * C = consumo mensual del cliente
```


### PARSER :

El parser lee un archivo nombre.json que contiene una lista de Usuarios (ya sean clientes o administradores), y devuelve dicha lista.

- [Archivo json con lista de usuarios](https://github.com/dds-utn/2018-vn-group-19/blob/master/src/test/java/testParser/usuarios.json)

- [Template Usuario Cliente](https://github.com/dds-utn/2018-vn-group-19/blob/master/src/test/java/testParser/cliente.json)
- [Template Usuario Administrador](https://github.com/dds-utn/2018-vn-group-19/blob/master/src/test/java/testParser/administrador.json)

- [Template Dispositivo](https://github.com/dds-utn/2018-vn-group-19/blob/master/src/test/java/testParser/dispositivo.json)

