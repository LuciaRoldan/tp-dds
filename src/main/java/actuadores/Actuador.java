package actuadores;

import dispositivos.Dispositivo;

import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.List;

public abstract class Actuador {
    List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();

    // Esta es la accion que va a ejecutar al recibir el mensaje de la regla //
        public void unaAccion() {
            this.dispositivos.forEach(dispositivo -> dispositivo.setEncendido(true));
        }

     // Este es el mensaje de la regla //
        public void haceFrio() {this.unaAccion();}

     // Setters //

        public void setDispositivo(Dispositivo dispositivo){this.dispositivos.add(dispositivo);}

    }




