package died.guia06;

public class cicloException extends Exception {
	public cicloException(){
		super("El alumno ya esta inscripto en 3 cursos en este ciclo." );
	}
}
