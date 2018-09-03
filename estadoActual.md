<h1 align = "center">
  TP DDS 2018 GRUPO 19
</h1>
 
### USEFULL LINKS :
- [Enunciado 3](https://drive.google.com/open?id=1vTFAXxE4Y7JxyhiJOPazPiE-TpiIw5wc)
- [Enundiado 2](https://drive.google.com/open?id=1rueeqLJ8xWrhV7Pkb9eUdsqj2wEynsNy)
- [Enunciado 1](https://drive.google.com/file/d/1BHh48SeMvcho4KQWGol4tHxSo9HhxuIO/view)
- [Enunciado 0](https://drive.google.com/open?id=1D570yECoNfgmJXOuC5YCMI9YVedC4asO)
- [Presentacion](https://drive.google.com/open?id=1YK65lbUqhRfKhlexOBqdMXJsvZBs6ZXO)
- [Diagrama de clases nuevo](https://www.lucidchart.com/documents/edit/28c0ccda-8344-44ba-8ecb-4dfa4e7fe0d1/0)
- [Diagrama de clases -old](https://www.lucidchart.com/invitations/accept/db20d253-e096-42e4-aeca-6afe906ff74d)
- [Github Branches](https://git-scm.com/book/en/v2/Git-Branching-Branches-in-a-Nutshell)


| **ACTUADORES:** | **SENSORES:** | **REGLAS:** |
| :-------------: | :-----------: | :---------: |
| Envío acciones a los dispositivos (aparte de prender/apagar), como ser subir/bajar intensidad, cambiar modo de operación, agendar acción o configurar timers, etc. | Tienen la capacidad de tomar una determinada medición y comunicarla. | Determinación de reglas, para que dado un conjunto de mediciones se disparen determinadas acciones. |


#### DISPOSITIVOS
|         **ESTANDAR:**     |                 **INTELIGENTE:**                 |
| :-----------------------: | :--------------------------------------------:   |
| Estos dispositivos son simples. No tienen la posibilidad de conectarse a nuestro sistema ni saber cuánta energía están consumiendo en un determinado momento. Tampoco podemos saber si están encendidos o apagados, o sea que no se deberán tener en cuenta al momento de preguntarle a un cliente por la cantidad de dispositivos encendidos/apagados. Solo sabemos de ellos una estimación acerca de cuánta energía consumen por hora (porque así lo habíamos modelado la iteración anterior). **Por eso usamos un builder** | Estos dispositivos se van a poder conectar con nuestro sistema. *Cada vez que el usuario registre uno de estos dispositivos, se le deberá otorgar 15 puntos* [Nos serviran para ...](https://drive.google.com/file/d/1BHh48SeMvcho4KQWGol4tHxSo9HhxuIO/view)  |

#### CONSUMO CLIENTE:
El consumo **MENSUAL** de cada cliente esta compuesto por la suma de todos los kWh de sus dispositivos encendidos.

#### RECATEGORIZACION DEL CLIENTE:
El cliente debe poder recategorizarse cada tres meses, para esta primera implementacion debe poder hacerlo sin tener en cuenta el tiempo.

#### CATEGORIAS DE CLIENTES
Las modelamos con enums.
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


#### PARSER :

El parser lee un archivo nombre.json que contiene una lista de Usuarios (ya sean clientes o administradores), y devuelve dicha lista. El parser se dejo de actualizar luego de la entrega 0.

- [Archivo json con lista de usuarios](https://github.com/dds-utn/2018-vn-group-19/blob/master/src/test/java/testParser/usuarios.json)
- [Template Usuario Cliente](https://github.com/dds-utn/2018-vn-group-19/blob/master/src/test/java/testParser/cliente.json)
- [Template Usuario Administrador](https://github.com/dds-utn/2018-vn-group-19/blob/master/src/test/java/testParser/administrador.json)
- [Template Dispositivo](https://github.com/dds-utn/2018-vn-group-19/blob/master/src/test/java/testParser/dispositivo.json)
