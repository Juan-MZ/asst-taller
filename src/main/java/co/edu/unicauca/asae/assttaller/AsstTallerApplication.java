package co.edu.unicauca.asae.assttaller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.assttaller.models.Cuestionario;
import co.edu.unicauca.asae.assttaller.models.Departamento;
import co.edu.unicauca.asae.assttaller.models.Docente;
import co.edu.unicauca.asae.assttaller.models.Pregunta;
import co.edu.unicauca.asae.assttaller.models.Respuesta;
import co.edu.unicauca.asae.assttaller.models.Telefono;
import co.edu.unicauca.asae.assttaller.models.TipoPregunta;
import co.edu.unicauca.asae.assttaller.models.enums.TipoIdentificacion;
import co.edu.unicauca.asae.assttaller.models.enums.TipoTelefono;
import co.edu.unicauca.asae.assttaller.repositories.CuestionarioRepository;
import co.edu.unicauca.asae.assttaller.repositories.DepartamentoRepository;
import co.edu.unicauca.asae.assttaller.repositories.DocentesRepository;
import co.edu.unicauca.asae.assttaller.repositories.PreguntaRepository;
import co.edu.unicauca.asae.assttaller.repositories.RespuestaRepository;
import co.edu.unicauca.asae.assttaller.repositories.TelefonosRepository;
import co.edu.unicauca.asae.assttaller.repositories.TipoPreguntaRepository;
import lombok.val;

@SpringBootApplication
@Transactional
public class AsstTallerApplication implements CommandLineRunner {

	@Autowired
	private TelefonosRepository servicioBDTelefonos;

	@Autowired
	private DocentesRepository servicioBDDocentes;

	@Autowired
	private PreguntaRepository servicioBDPreguntas;

	@Autowired
	private TipoPreguntaRepository servicioBDTipoPreguntas;

	@Autowired
	private CuestionarioRepository servicioBDCuestionario;

	@Autowired
	private DepartamentoRepository servicioBDDepartamentos;

	@Autowired
	private RespuestaRepository servicioBDRespuestas;

	public static void main(String[] args) {
		SpringApplication.run(AsstTallerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		almacenarDepartamentos();
		crearDocentes();
		almacenarCuestionarios();
		almacenarRespuestas();
	}

	/**
	 * Método para almacenar los tipos de preguntas
	 */
	private void almacenarTipoPreguntas() {
		TipoPregunta objTipoPregunta1 = new TipoPregunta();
		objTipoPregunta1.setNombre("Datos generales");
		objTipoPregunta1.setDescripcion("Preguntas de datos generales");

		this.servicioBDTipoPreguntas.save(objTipoPregunta1);

		TipoPregunta objTipoPregunta2 = new TipoPregunta();
		objTipoPregunta2.setNombre("Intralaboral");
		objTipoPregunta2.setDescripcion("Preguntas de factores de riesgo psicosocial intralaboral");

		this.servicioBDTipoPreguntas.save(objTipoPregunta2);

		TipoPregunta objTipoPregunta3 = new TipoPregunta();
		objTipoPregunta3.setNombre("Extralaboral");
		objTipoPregunta3.setDescripcion("Preguntas de factores psicosociales extralaborales");

		this.servicioBDTipoPreguntas.save(objTipoPregunta3);

		TipoPregunta objTipoPregunta4 = new TipoPregunta();
		objTipoPregunta4.setNombre("Estrés");
		objTipoPregunta4.setDescripcion("Preguntas para la evaluación del estrés");

		this.servicioBDTipoPreguntas.save(objTipoPregunta4);
	}

	/**
	 * Método para almacenar cuestionarios
	 */
	private void almacenarCuestionarios() {

		Cuestionario objCuestionario1 = new Cuestionario();
		objCuestionario1.setTitulo("Ficha de datos generales");
		objCuestionario1.setDescripcion("Cuestionario de datos generales");

		TipoPregunta objTipoPregunta1 = new TipoPregunta();
		objTipoPregunta1.setNombre("Datos generales");
		objTipoPregunta1.setDescripcion("Preguntas de datos generales");
		this.servicioBDTipoPreguntas.save(objTipoPregunta1);

		List<Pregunta> preguntasCuestionario1 = new ArrayList<>();

		Pregunta objPregunta1 = new Pregunta();
		objPregunta1.setEnunciado("¿Hace cuántos años trabaja en esta empresa?");
		objPregunta1.setObjTipoPregunta(objTipoPregunta1);
		preguntasCuestionario1.add(objPregunta1);

		Pregunta objPregunta2 = new Pregunta();
		objPregunta2.setEnunciado("¿Cuál es el nombre del cargo que ocupa en la empresa?");
		objPregunta2.setObjTipoPregunta(objTipoPregunta1);
		preguntasCuestionario1.add(objPregunta2);

		Pregunta objPregunta3 = new Pregunta();
		objPregunta3.setEnunciado("¿Cuál es su ocupación o profesión");
		objPregunta3.setObjTipoPregunta(objTipoPregunta1);
		preguntasCuestionario1.add(objPregunta3);

		objCuestionario1.setPreguntas(preguntasCuestionario1);
		objPregunta1.setObjCuestionario(objCuestionario1);
		objPregunta2.setObjCuestionario(objCuestionario1);
		objPregunta3.setObjCuestionario(objCuestionario1);

		this.servicioBDCuestionario.save(objCuestionario1);

		/** ------------------------------------------------------- */
		Cuestionario objCuestionario2 = new Cuestionario();
		objCuestionario2.setTitulo("Cuestionario de factores de riesgo psicosocial intralaboral");
		objCuestionario2.setDescripcion("Cuestionario sobre los factores de riesgo psicosocial intralaboral");

		TipoPregunta objTipoPregunta2 = new TipoPregunta();
		objTipoPregunta2.setNombre("Intralaboral");
		objTipoPregunta2.setDescripcion("Preguntas de factores de riesgo psicosocial intralaboral");
		this.servicioBDTipoPreguntas.save(objTipoPregunta2);

		List<Pregunta> preguntasCuestionario2 = new ArrayList<>();

		Pregunta objPregunta4 = new Pregunta();
		objPregunta4.setEnunciado("El ruido en el lugar donde trabajo es molesto?");
		objPregunta4.setObjTipoPregunta(objTipoPregunta2);
		preguntasCuestionario2.add(objPregunta4);

		Pregunta objPregunta5 = new Pregunta();
		objPregunta5.setEnunciado("El espacio donde trabajo es comodo?");
		objPregunta5.setObjTipoPregunta(objTipoPregunta2);
		preguntasCuestionario2.add(objPregunta5);

		Pregunta objPregunta6 = new Pregunta();
		objPregunta6.setEnunciado("Mi trabajo me exige hacer mucho esfuerzo físico?");
		objPregunta6.setObjTipoPregunta(objTipoPregunta2);
		preguntasCuestionario2.add(objPregunta6);

		objCuestionario2.setPreguntas(preguntasCuestionario2);
		objPregunta4.setObjCuestionario(objCuestionario2);
		objPregunta5.setObjCuestionario(objCuestionario2);
		objPregunta6.setObjCuestionario(objCuestionario2);

		this.servicioBDCuestionario.save(objCuestionario2);

		/** ------------------------------------------------------- */
		Cuestionario objCuestionario3 = new Cuestionario();
		objCuestionario3.setTitulo("Cuestionario de factores psicosociales extralaborales");
		objCuestionario3.setDescripcion("Cuestionario sobre los factores psicosociales extralaborales");

		TipoPregunta objTipoPregunta3 = new TipoPregunta();
		objTipoPregunta3.setNombre("Extralaboral");
		objTipoPregunta3.setDescripcion("Preguntas de factores psicosociales extralaborales");
		this.servicioBDTipoPreguntas.save(objTipoPregunta3);

		List<Pregunta> preguntasCuestionario3 = new ArrayList<>();

		Pregunta objPregunta7 = new Pregunta();
		objPregunta7.setEnunciado("Es fácil transportarme entre mi casa y el trabajo?");
		objPregunta7.setObjTipoPregunta(objTipoPregunta3);
		preguntasCuestionario3.add(objPregunta7);

		Pregunta objPregunta8 = new Pregunta();
		objPregunta8.setEnunciado("La zonda donde vivo es segura?");
		objPregunta8.setObjTipoPregunta(objTipoPregunta3);
		preguntasCuestionario3.add(objPregunta8);

		Pregunta objPregunta9 = new Pregunta();
		objPregunta9.setEnunciado("Las condiciones de mi vivienda son buenas?");
		objPregunta9.setObjTipoPregunta(objTipoPregunta3);
		preguntasCuestionario3.add(objPregunta9);

		objCuestionario3.setPreguntas(preguntasCuestionario3);
		objPregunta7.setObjCuestionario(objCuestionario3);
		objPregunta8.setObjCuestionario(objCuestionario3);
		objPregunta9.setObjCuestionario(objCuestionario3);

		this.servicioBDCuestionario.save(objCuestionario3);

		/** ------------------------------------------------------- */
		Cuestionario objCuestionario4 = new Cuestionario();
		objCuestionario4.setTitulo("Cuestionario para la evaluación del estres");
		objCuestionario4.setDescripcion("Cuestionario sobre la evaluación del estres");

		TipoPregunta objTipoPregunta4 = new TipoPregunta();
		objTipoPregunta4.setNombre("Estrés");
		objTipoPregunta4.setDescripcion("Preguntas para la evaluación del estrés");
		this.servicioBDTipoPreguntas.save(objTipoPregunta4);

		List<Pregunta> preguntasCuestionario4 = new ArrayList<>();

		Pregunta objPregunta10 = new Pregunta();
		objPregunta10.setEnunciado("Dolor de cabeza?");
		objPregunta10.setObjTipoPregunta(objTipoPregunta4);
		preguntasCuestionario4.add(objPregunta10);

		Pregunta objPregunta11 = new Pregunta();
		objPregunta11.setEnunciado("Problemas respiratorios?");
		objPregunta11.setObjTipoPregunta(objTipoPregunta4);
		preguntasCuestionario4.add(objPregunta11);

		Pregunta objPregunta12 = new Pregunta();
		objPregunta12.setEnunciado("Cambios fuertes en el apetito?");
		objPregunta12.setObjTipoPregunta(objTipoPregunta4);
		preguntasCuestionario4.add(objPregunta12);

		objCuestionario4.setPreguntas(preguntasCuestionario4);
		objPregunta10.setObjCuestionario(objCuestionario4);
		objPregunta11.setObjCuestionario(objCuestionario4);
		objPregunta12.setObjCuestionario(objCuestionario4);

		this.servicioBDCuestionario.save(objCuestionario4);
	}

	/**
	 * Método para eliminar cuestionario
	 */
	private void eliminarCuestionario() {
		this.servicioBDCuestionario.deleteById(2);
	}

	/**
	 * Método para eliminar pregunta
	 */
	private void eliminarPregunta() {
		Integer idEliminar = 1;
		this.servicioBDPreguntas.deleteById(idEliminar);
		if (this.servicioBDPreguntas.findById(idEliminar) == null) {
			System.out.println("La pregunta con el id: " + idEliminar + " se elimino con exito.");
		}

	}

	private void almacenarDepartamentos() {
		Departamento objDepartamento1 = new Departamento();
		objDepartamento1.setNombreDep("Dpto de sistemas");
		objDepartamento1.setDescripcion("Dpto de Sistemas");

		Departamento objDepartamento2 = new Departamento();
		objDepartamento2.setNombreDep("Dpto de Electrónica");
		objDepartamento2.setDescripcion("Dpto de Electrónica");

		Departamento objDepartamento3 = new Departamento();
		objDepartamento3.setNombreDep("Dpto de Telematica");
		objDepartamento3.setDescripcion("Dpto de Telematica");

		this.servicioBDDepartamentos.save(objDepartamento1);
		this.servicioBDDepartamentos.save(objDepartamento2);
		this.servicioBDDepartamentos.save(objDepartamento3);
	}

	private void crearDocentes() {

		Departamento objDepartamento1 = this.servicioBDDepartamentos.findById(1).get();
		Departamento objDepartamento2 = this.servicioBDDepartamentos.findById(2).get();
		Departamento objDepartamento3 = this.servicioBDDepartamentos.findById(3).get();

		Docente objDocente1 = new Docente();
		objDocente1.setTipoIdentificacion(TipoIdentificacion.CC);
		objDocente1.setNumeroIdentificacion("1061811001");
		objDocente1.setNombres("Pedro Andres");
		objDocente1.setApellidos("Gomez Lopez");
		objDocente1.setCorreo("pedro@gmail.com");
		objDocente1.setVinculacion("Vinculación");

		Telefono objTelefono1 = new Telefono();
		objTelefono1.setTipoTelefono(TipoTelefono.CELULAR);
		objTelefono1.setNumero("3234703101");
		objDocente1.setObjTelefono(objTelefono1);
		objTelefono1.setObjPersona(objDocente1);

		List<Departamento> departamentosDocente1 = new ArrayList<>();
		departamentosDocente1.add(objDepartamento1);
		departamentosDocente1.add(objDepartamento3);
		objDocente1.setDepartamentos(departamentosDocente1);

		this.servicioBDDocentes.save(objDocente1);

		/** ------------------------------------------------------- */
		Docente objDocente2 = new Docente();
		objDocente2.setTipoIdentificacion(TipoIdentificacion.CC);
		objDocente2.setNumeroIdentificacion("1061811002");
		objDocente2.setNombres("Ana Sofia");
		objDocente2.setApellidos("Trujillo");
		objDocente2.setCorreo("ana@gmail.com");
		objDocente2.setVinculacion("Vinculación");

		Telefono objTelefono2 = new Telefono();
		objTelefono2.setTipoTelefono(TipoTelefono.CELULAR);
		objTelefono2.setNumero("3234703102");
		objDocente2.setObjTelefono(objTelefono2);
		objTelefono2.setObjPersona(objDocente2);

		List<Departamento> departamentosDocente2 = new ArrayList<>();
		departamentosDocente2.add(objDepartamento1);
		departamentosDocente2.add(objDepartamento2);
		departamentosDocente2.add(objDepartamento3);
		objDocente2.setDepartamentos(departamentosDocente2);

		this.servicioBDDocentes.save(objDocente2);

		/** ------------------------------------------------------- */
		Docente objDocente3 = new Docente();
		objDocente3.setTipoIdentificacion(TipoIdentificacion.CC);
		objDocente3.setNumeroIdentificacion("1061811003");
		objDocente3.setNombres("Alexander");
		objDocente3.setApellidos("Narvaez");
		objDocente3.setCorreo("alex@gmail.com");
		objDocente3.setVinculacion("Vinculación");

		Telefono objTelefono3 = new Telefono();
		objTelefono3.setTipoTelefono(TipoTelefono.FIJO);
		objTelefono3.setNumero("30003103");
		objDocente3.setObjTelefono(objTelefono3);
		objTelefono3.setObjPersona(objDocente3);

		List<Departamento> departamentosDocente3 = new ArrayList<>();
		departamentosDocente3.add(objDepartamento2);
		departamentosDocente3.add(objDepartamento3);
		objDocente3.setDepartamentos(departamentosDocente3);

		this.servicioBDDocentes.save(objDocente3);
	}

	private void eliminarDocente() {
		this.servicioBDDocentes.deleteById(2);
		;
	}

	private void almacenarRespuestas() {
		/* Traemos al primero docente */
		Docente objDocente1 = this.servicioBDDocentes.findById(1).get();
		/* Traemos al segundo docente */
		Docente objDocente2 = this.servicioBDDocentes.findById(2).get();

		/* Instanciamos las preguntas */
		Pregunta objPregunta1 = this.servicioBDPreguntas.findById(1).get();
		Pregunta objPregunta2 = this.servicioBDPreguntas.findById(2).get();
		Pregunta objPregunta3 = this.servicioBDPreguntas.findById(3).get();
		Pregunta objPregunta4 = this.servicioBDPreguntas.findById(4).get();
		Pregunta objPregunta5 = this.servicioBDPreguntas.findById(5).get();
		Pregunta objPregunta6 = this.servicioBDPreguntas.findById(6).get();
		Pregunta objPregunta7 = this.servicioBDPreguntas.findById(7).get();
		Pregunta objPregunta8 = this.servicioBDPreguntas.findById(8).get();
		Pregunta objPregunta9 = this.servicioBDPreguntas.findById(9).get();
		Pregunta objPregunta10 = this.servicioBDPreguntas.findById(10).get();
		Pregunta objPregunta11 = this.servicioBDPreguntas.findById(11).get();
		Pregunta objPregunta12 = this.servicioBDPreguntas.findById(12).get();

		/* Creación de respuestas para el primer docente */
		Respuesta objRespuesta1Docente1 = new Respuesta();
		objRespuesta1Docente1.setDescripcion("5 años");
		objRespuesta1Docente1.setObjDocente(objDocente1);
		objRespuesta1Docente1.setObjPregunta(objPregunta1);
		this.servicioBDRespuestas.save(objRespuesta1Docente1);

		Respuesta objRespuesta2Docente1 = new Respuesta();
		objRespuesta2Docente1.setDescripcion("Desarrollador Junior");
		objRespuesta2Docente1.setObjDocente(objDocente1);
		objRespuesta2Docente1.setObjPregunta(objPregunta2);
		this.servicioBDRespuestas.save(objRespuesta2Docente1);

		Respuesta objRespuesta3Docente1 = new Respuesta();
		objRespuesta3Docente1.setDescripcion("Ingeniero de sistemas");
		objRespuesta3Docente1.setObjDocente(objDocente1);
		objRespuesta3Docente1.setObjPregunta(objPregunta3);
		this.servicioBDRespuestas.save(objRespuesta3Docente1);

		Respuesta objRespuesta4Docente1 = new Respuesta();
		objRespuesta4Docente1.setDescripcion("Un poco");
		objRespuesta4Docente1.setObjDocente(objDocente1);
		objRespuesta4Docente1.setObjPregunta(objPregunta4);
		this.servicioBDRespuestas.save(objRespuesta4Docente1);

		Respuesta objRespuesta5Docente1 = new Respuesta();
		objRespuesta5Docente1.setDescripcion("Si, es comodo");
		objRespuesta5Docente1.setObjDocente(objDocente1);
		objRespuesta5Docente1.setObjPregunta(objPregunta5);
		this.servicioBDRespuestas.save(objRespuesta5Docente1);

		Respuesta objRespuesta6Docente1 = new Respuesta();
		objRespuesta6Docente1.setDescripcion("Nunca");
		objRespuesta6Docente1.setObjDocente(objDocente1);
		objRespuesta6Docente1.setObjPregunta(objPregunta6);
		this.servicioBDRespuestas.save(objRespuesta6Docente1);

		/* Creación de respuestas para el segundo docente */
		Respuesta objRespuesta1Docente2 = new Respuesta();
		objRespuesta1Docente2.setDescripcion("8 años");
		objRespuesta1Docente2.setObjDocente(objDocente2);
		objRespuesta1Docente2.setObjPregunta(objPregunta1);
		this.servicioBDRespuestas.save(objRespuesta1Docente2);

		Respuesta objRespuesta2Docente2 = new Respuesta();
		objRespuesta2Docente2.setDescripcion("Desarrollador Senior");
		objRespuesta2Docente2.setObjDocente(objDocente2);
		objRespuesta2Docente2.setObjPregunta(objPregunta2);
		this.servicioBDRespuestas.save(objRespuesta2Docente2);

		Respuesta objRespuesta3Docente2 = new Respuesta();
		objRespuesta3Docente2.setDescripcion("Ingeniero de software");
		objRespuesta3Docente2.setObjDocente(objDocente2);
		objRespuesta3Docente2.setObjPregunta(objPregunta3);
		this.servicioBDRespuestas.save(objRespuesta3Docente2);

		Respuesta objRespuesta4Docente2 = new Respuesta();
		objRespuesta4Docente2.setDescripcion("No me molesta");
		objRespuesta4Docente2.setObjDocente(objDocente2);
		objRespuesta4Docente2.setObjPregunta(objPregunta4);
		this.servicioBDRespuestas.save(objRespuesta4Docente2);

		Respuesta objRespuesta5Docente2 = new Respuesta();
		objRespuesta5Docente2.setDescripcion("No, es algo incomodo.");
		objRespuesta5Docente2.setObjDocente(objDocente2);
		objRespuesta5Docente2.setObjPregunta(objPregunta5);
		this.servicioBDRespuestas.save(objRespuesta5Docente1);

		Respuesta objRespuesta6Docente2 = new Respuesta();
		objRespuesta6Docente2.setDescripcion("Nunca");
		objRespuesta6Docente2.setObjDocente(objDocente2);
		objRespuesta6Docente2.setObjPregunta(objPregunta6);
		this.servicioBDRespuestas.save(objRespuesta6Docente2);
	}

}
