package parser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import Excepciones.*;
import dispositivos.Dispositivo;
import dispositivos.DispositivoBuilder;

import org.json.simple.parser.JSONParser;
import usuario.Administrador;
import usuario.Usuario;

import java.io.File;
import java.io.IOException;
import java.util.List;

//TODO Hacer singleton

@JsonIgnoreProperties(ignoreUnknown = true)
public class Parser {

	JSONParser parser = new JSONParser();
	ObjectMapper mapper = new ObjectMapper();

	public List<Usuario> parsearUsuario(String nombreArchivo) throws NoSePudoAbrirElArchivoException {

		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			List<Usuario> listaDeUsuarios = mapper.readValue(new File(nombreArchivo),
					new TypeReference<List<Usuario>>() {
					});
			return listaDeUsuarios;

		} catch (IOException e) {
			throw new NoSePudoAbrirElArchivoException("No se pudo abrir el archivo: "+nombreArchivo);
		}
	}

	/////////////////////////// FUNCIONES VIEJAS DE PRUEBA ////////////////////////

	public Dispositivo parsearDispositivo(String nombreArchivo) throws NoSePudoAbrirElArchivoException {

		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			Dispositivo dispo = mapper.readValue(new File(nombreArchivo), Dispositivo.class);
			return dispo;
		} catch (IOException e) {
			throw new NoSePudoAbrirElArchivoException("No se pudo abrir el archivo: "+nombreArchivo);
		}
	}

	public DispositivoBuilder parsearDispositivoBuilder(String nombreArchivo) throws NoSePudoAbrirElArchivoException {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			DispositivoBuilder builder = mapper.readValue(new File(nombreArchivo), DispositivoBuilder.class);
			return builder;
		} catch (IOException e) {
			throw new NoSePudoAbrirElArchivoException("No se pudo abrir el archivo: "+nombreArchivo);
		}
	}

	public Administrador parsearAdministrador(String nombreArchivo) throws NoSePudoAbrirElArchivoException {

		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			Administrador administrador = mapper.readValue(new File(nombreArchivo), Administrador.class);
			return administrador;
		} catch (IOException e) {
			throw new NoSePudoAbrirElArchivoException("No se pudo abrir el archivo: "+nombreArchivo);
		}
	}

}
