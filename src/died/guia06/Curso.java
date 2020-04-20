package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import died.guia06.util.Registro;


public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getCicloLectivo() {
		return cicloLectivo;
	}


	public void setCicloLectivo(Integer cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}


	public Integer getCupo() {
		return cupo;
	}


	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}


	public List<Alumno> getInscriptos() {
		return inscriptos;
	}


	public void setInscriptos(List<Alumno> inscriptos) {
		this.inscriptos = inscriptos;
	}


	public Integer getCreditos() {
		return creditos;
	}


	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}


	public Integer getCreditosRequeridos() {
		return creditosRequeridos;
	}


	public void setCreditosRequeridos(Integer creditosRequeridos) {
		this.creditosRequeridos = creditosRequeridos;
	}


	
	private Registro log;
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	

	
	public boolean verificarInscripcion (Alumno a) {
		
		if (a.creditosObtenidos()>this.creditos) {
			if(this.cupo.intValue()>0) {
				if (a.obtenerNCiclos(this.getCicloLectivo().intValue()) > 2) {
					List<Curso> materias = a.getCursando();
					this.inscriptos.add(a);
					materias.add(this);
					a.setCursando(materias);
					return true;
				}else {
					JOptionPane.showMessageDialog(null, "El alumno ya esta inscripto en 3 cursos en el ciclo "+this.getCicloLectivo().toString());
					return false;
				}
			} else {
				JOptionPane.showMessageDialog(null, "No hay cupos para este curso");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "El alumno "+a.getNombre()+" no tiene los creditos minimos para ingresar a este curso");
			return false;
		}
		
		

	}
	

	public Boolean inscribir(Alumno a) throws IOException {
		try {
			log.registrar(this, "inscribir ",a.toString());
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "No se pudo inscribir al alumno");
		}
		return false;
	}
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public Alumno obtenerPrimerAlumno(List<Alumno> alumnos) {
		Alumno a = new Alumno();
		String nombre = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
		for (Alumno aux: alumnos) {
			if (aux.getNombre().compareTo(nombre) < 0) {
				nombre = aux.getNombre();
				a = aux;
			}
		}
		return a;
	}
	
	public void imprimirAlumnosInscriptos () {
		List<Alumno> listaAux = inscriptos;
		String nombreActual;
		Alumno a = new Alumno();
		while(listaAux.size()!=0) {
			a = obtenerPrimerAlumno(listaAux);
			nombreActual = a.getNombre() ;
			System.out.println(nombreActual);
			listaAux.remove(a);
		}
	}
	
	
	
	public void imprimirInscriptos() throws IOException {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "No se pudo imprimir loa alumnos inscriptos");
		}
	}


}
