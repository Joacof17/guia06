package died.guia06;

public class creditsException extends Exception {
	public creditsException(){
		super("El alumno no tiene los creditos minimos para ingresar a este curso");
	}
}
