package mock;

import usuario.Cliente;

import javax.persistence.Entity;


public class ClienteMock extends Cliente {


    public Long calcularConsumoAhora(){
        return 200L;
    }

}
