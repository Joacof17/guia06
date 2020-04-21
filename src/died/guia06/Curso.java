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
	
	public void cursos(String a, Integer b, Integer c, Integer d, Integer e, Integer f, List<Alumno> g) {
		this.setNombre(a);
		this.setId(b);
		this.setCupo(c);
		this.setCicloLectivo(d);
		this.setCreditosRequeridos(e);
		this.setCreditos(f);
		this.setInscriptos(g);
	}
	
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
	

	/**
	 * 
	 * Antiguo metodo de inscripcion, sin excepciones
	 * public boolean verificarInscripcion (Alumno a) {
		
		if (a.creditosObtenidos()>=this.creditosRequeridos) {
			if(this.cupo.intValue()>0) {
				if (a.nCiclos(this.getCicloLectivo().intValue()) < 3) {
					List<Curso> materias = a.getCursando();
					this.inscriptos.add(a);
					materias.add(this);
					a.setCursando(materias);
					JOptionPane.showMessageDialog(null, "El alumno "+a.getNombre()+" se ha inscripto exitosamente");
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
	
	
	*/

	
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
		if (listaAux.size()==0) {
			JOptionPane.showMessageDialog(null, "No hay alumnos inscriptos en este curso");
		}else {
		while(listaAux.size()!=0) {
			a = obtenerPrimerAlumno(listaAux);
			nombreActual = a.getNombre() ;
			System.out.println(nombreActual);
			listaAux.remove(a);
		}
		}
	}
	
	
	
	public void imprimirInscriptos() throws IOException {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "No se pudo imprimir los alumnos inscriptos");
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
	

	public void inscribirAlumno(Alumno a) throws creditsException, cupoException, cicloException, RegistroAuditoriaException {
		if (a.creditosObtenidos()>=this.creditosRequeridos) {
			if(this.cupo.intValue()>0) {
				if (a.nCiclos(this.getCicloLectivo().intValue()) < 3) {
					try {
						log.registrar(this, "inscribir ",a.toString());
						List<Curso> materias = a.getCursando();
						this.inscriptos.add(a);
						materias.add(this);
						a.setCursando(materias);
						JOptionPane.showMessageDialog(null, "El alumno "+a.getNombre()+" se ha inscripto exitosamente");
					} catch (IOException ioe) {
						throw new RegistroAuditoriaException();
					}

				}else {
					throw new cicloException();
				}
			} else {
				throw new cupoException();
			}
		} else {
			throw new creditsException();
		}
	}
	
	
	
	
	


}
