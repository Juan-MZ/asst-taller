package co.edu.unicauca.asae.assttaller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.assttaller.models.Cuestionario;
import co.edu.unicauca.asae.assttaller.models.Docente;
import co.edu.unicauca.asae.assttaller.models.Pregunta;
import co.edu.unicauca.asae.assttaller.models.Telefono;
import co.edu.unicauca.asae.assttaller.models.TipoPregunta;
import co.edu.unicauca.asae.assttaller.models.enums.TipoIdentificacion;
import co.edu.unicauca.asae.assttaller.models.enums.TipoTelefono;
import co.edu.unicauca.asae.assttaller.repositories.CuestionarioRepository;
import co.edu.unicauca.asae.assttaller.repositories.DocentesRepository;
import co.edu.unicauca.asae.assttaller.repositories.PreguntaRepository;
import co.edu.unicauca.asae.assttaller.repositories.TelefonosRepository;
import co.edu.unicauca.asae.assttaller.repositories.TipoPreguntaRepository;

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

	public static void main(String[] args) {
		SpringApplication.run(AsstTallerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		almacenarCuestionarios();
	}

	private void almacenarDocentes() {
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

		this.servicioBDDocentes.save(objDocente1);


	}

	private void eliminarDocente() {
		this.servicioBDDocentes.deleteById(1);;
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
		objPregunta1.setEnunciado("¿Hace cuántos años que trabaja en esta empresa?");
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

		/**------------------------------------------------------- */
		Cuestionario objCuestionario2 = new Cuestionario();
		objCuestionario2.setTitulo("Cuestionario de factores de riesgo psicosocial intralaboral");
		objCuestionario2.setDescripcion("Cuestionario sobre los factores de riesgo psicosocial intralaboral");

		TipoPregunta objTipoPregunta2 = new TipoPregunta();
		objTipoPregunta2.setNombre("Intralaboral");
		objTipoPregunta2.setDescripcion("Preguntas de factores de riesgo psicosocial intralaboral");
		this.servicioBDTipoPreguntas.save(objTipoPregunta2);

		List<Pregunta> preguntasCuestionario2 = new ArrayList<>();

		Pregunta objPregunta4 = new Pregunta();
		objPregunta4.setEnunciado("El ruido en el lugar donde trabajo es molesto");
		objPregunta4.setObjTipoPregunta(objTipoPregunta2);
		preguntasCuestionario2.add(objPregunta4);

		Pregunta objPregunta5 = new Pregunta();
		objPregunta5.setEnunciado("El espacio donde trabajo es comodo");
		objPregunta5.setObjTipoPregunta(objTipoPregunta2);
		preguntasCuestionario2.add(objPregunta5);

		Pregunta objPregunta6 = new Pregunta();
		objPregunta6.setEnunciado("Mi trabajo me exige hacer mucho esfuerzo físico");
		objPregunta6.setObjTipoPregunta(objTipoPregunta2);
		preguntasCuestionario2.add(objPregunta6);
		
		objCuestionario2.setPreguntas(preguntasCuestionario2);
		objPregunta4.setObjCuestionario(objCuestionario2);
		objPregunta5.setObjCuestionario(objCuestionario2);
		objPregunta6.setObjCuestionario(objCuestionario2);

		this.servicioBDCuestionario.save(objCuestionario2);

		/**------------------------------------------------------- */
		Cuestionario objCuestionario3 = new Cuestionario();
		objCuestionario3.setTitulo("Cuestionario de factores psicosociales extralaborales");
		objCuestionario3.setDescripcion("Cuestionario sobre los factores psicosociales extralaborales");

		TipoPregunta objTipoPregunta3 = new TipoPregunta();
		objTipoPregunta3.setNombre("Extralaboral");
		objTipoPregunta3.setDescripcion("Preguntas de factores psicosociales extralaborales");
		this.servicioBDTipoPreguntas.save(objTipoPregunta3);

		List<Pregunta> preguntasCuestionario3 = new ArrayList<>();

		Pregunta objPregunta7 = new Pregunta();
		objPregunta7.setEnunciado("Es fácil transportarme entre mi casa y el trabajo");
		objPregunta7.setObjTipoPregunta(objTipoPregunta3);
		preguntasCuestionario3.add(objPregunta7);

		Pregunta objPregunta8 = new Pregunta();
		objPregunta8.setEnunciado("La zonda donde vivo es segura");
		objPregunta8.setObjTipoPregunta(objTipoPregunta3);
		preguntasCuestionario3.add(objPregunta8);

		Pregunta objPregunta9 = new Pregunta();
		objPregunta9.setEnunciado("Las condiciones de mi vivienda son buenas");
		objPregunta9.setObjTipoPregunta(objTipoPregunta3);
		preguntasCuestionario3.add(objPregunta9);
		
		objCuestionario3.setPreguntas(preguntasCuestionario3);
		objPregunta7.setObjCuestionario(objCuestionario3);
		objPregunta8.setObjCuestionario(objCuestionario3);
		objPregunta9.setObjCuestionario(objCuestionario3);

		this.servicioBDCuestionario.save(objCuestionario3);

		/**------------------------------------------------------- */
		Cuestionario objCuestionario4 = new Cuestionario();
		objCuestionario4.setTitulo("Cuestionario para la evaluación del estres");
		objCuestionario4.setDescripcion("Cuestionario sobre la evaluación del estres");

		TipoPregunta objTipoPregunta4 = new TipoPregunta();
		objTipoPregunta4.setNombre("Estrés");
		objTipoPregunta4.setDescripcion("Preguntas para la evaluación del estrés");
		this.servicioBDTipoPreguntas.save(objTipoPregunta4);

		List<Pregunta> preguntasCuestionario4 = new ArrayList<>();

		Pregunta objPregunta10 = new Pregunta();
		objPregunta10.setEnunciado("Dolor de cabeza");
		objPregunta10.setObjTipoPregunta(objTipoPregunta4);
		preguntasCuestionario4.add(objPregunta10);

		Pregunta objPregunta11 = new Pregunta();
		objPregunta11.setEnunciado("Problemas respiratorios");
		objPregunta11.setObjTipoPregunta(objTipoPregunta4);
		preguntasCuestionario4.add(objPregunta11);

		Pregunta objPregunta12 = new Pregunta();
		objPregunta12.setEnunciado("Cambios fuertes en el apetito");
		objPregunta12.setObjTipoPregunta(objTipoPregunta4);
		preguntasCuestionario4.add(objPregunta12);

		objCuestionario4.setPreguntas(preguntasCuestionario4);
		objPregunta10.setObjCuestionario(objCuestionario4);
		objPregunta11.setObjCuestionario(objCuestionario4);
		objPregunta12.setObjCuestionario(objCuestionario4);

		this.servicioBDCuestionario.save(objCuestionario4); 
	}

	private void almacenarPreguntasv2() {
		/**------------------------------------------------------- */
		TipoPregunta objTipoPregunta3 = new TipoPregunta();
		objTipoPregunta3.setNombre("Extralaboral");
		objTipoPregunta3.setDescripcion("Preguntas de factores psicosociales extralaborales");
		this.servicioBDTipoPreguntas.save(objTipoPregunta3);

		Pregunta objPregunta7 = new Pregunta();
		objPregunta7.setEnunciado("Es fácil transportarme entre mi casa y el trabajo");
		objPregunta7.setObjTipoPregunta(objTipoPregunta3);
		this.servicioBDPreguntas.save(objPregunta7);

		Pregunta objPregunta8 = new Pregunta();
		objPregunta8.setEnunciado("La zonda donde vivo es segura");
		objPregunta8.setObjTipoPregunta(objTipoPregunta3);
		this.servicioBDPreguntas.save(objPregunta8);

		Pregunta objPregunta9 = new Pregunta();
		objPregunta9.setEnunciado("Las condiciones de mi vivienda son buenas");
		objPregunta9.setObjTipoPregunta(objTipoPregunta3);
		this.servicioBDPreguntas.save(objPregunta9);

		/**------------------------------------------------------- */
		TipoPregunta objTipoPregunta4 = new TipoPregunta();
		objTipoPregunta4.setNombre("Estrés");
		objTipoPregunta4.setDescripcion("Preguntas para la evaluación del estrés");
		this.servicioBDTipoPreguntas.save(objTipoPregunta4);

		Pregunta objPregunta10 = new Pregunta();
		objPregunta10.setEnunciado("Dolor de cabeza");
		objPregunta10.setObjTipoPregunta(objTipoPregunta4);
		this.servicioBDPreguntas.save(objPregunta10);

		Pregunta objPregunta11 = new Pregunta();
		objPregunta11.setEnunciado("Problemas respiratorios");
		objPregunta11.setObjTipoPregunta(objTipoPregunta4);
		this.servicioBDPreguntas.save(objPregunta11);

		Pregunta objPregunta12 = new Pregunta();
		objPregunta12.setEnunciado("Cambios fuertes en el apetito");
		objPregunta12.setObjTipoPregunta(objTipoPregunta4);
		this.servicioBDPreguntas.save(objPregunta12);
	}

	private void eliminarPregunta() {
		Integer idEliminar = 1;
		this.servicioBDPreguntas.deleteById(idEliminar);
		if(this.servicioBDPreguntas.findById(idEliminar) == null) {
			System.out.println("La pregunta con el id: " + idEliminar + " se elimino con exito.");
		}

	}

}
