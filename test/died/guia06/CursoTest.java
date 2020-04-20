package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.junit.Test;
import java.util.List;
import javax.swing.JOptionPane;


import java.util.ArrayList;

class CursoTest {
	Alumno ala = new Alumno();
	Alumno alb = new Alumno();
	Alumno alc = new Alumno();
	Curso cua = new Curso();
	Curso cub = new Curso();
	Curso cuc = new Curso();
	Curso cud = new Curso();
	Curso cue = new Curso();
	List<Alumno> alum = new ArrayList<Alumno>();
	List<Alumno> alum1 = new ArrayList<Alumno>();
	List<Curso> cur = new ArrayList<Curso>();
	List<Curso> cur1 = new ArrayList<Curso>();
	List<Curso> cur2 = new ArrayList<Curso>();
	List<Curso> cur3 = new ArrayList<Curso>();
	
	public void seteara () {
		cua.setCicloLectivo(2020);
		cua.setCreditosRequeridos(40);
		cua.setCreditos(30);
		cua.setCupo(2);
		cua.setInscriptos(alum1);
		
	}
	public void setearb () {
		cub.setCicloLectivo(2020);
		cub.setCreditosRequeridos(30);
		cub.setCreditos(20);
		cub.setCupo(1);
		cub.setInscriptos(alum1);
		
	}
	public void setearc () {
		cuc.setCicloLectivo(2020);
		cuc.setCreditosRequeridos(20);
		cuc.setCreditos(10);
		cuc.setCupo(0);
		cuc.setInscriptos(alum1);
	}
	public void seteard () {
		cud.setCicloLectivo(2020);
		cud.setCreditosRequeridos(50);
		cud.setCreditos(40);
		cud.setCupo(3);
		
	}
	public void seteare () {
		cue.setCicloLectivo(2020);
		cue.setCreditosRequeridos(60);
		cue.setCreditos(80);
		cue.setCupo(3);
		
	}

	public void agregarAlu () {
		alum.add(alb);
		alum.add(alc);
		alum.add(ala);
	}
	public void agregarAlu1 () {
		alum1.add(alc);
	}
	public void agregarCur () {
		cur.add(cua);
		cur.add(cub);
		cur.add(cuc);
	}
	public void agregarCur1 () {
		cur1.add(cub);
	}
	public void agregarCur2 () {
		cur2.add(cud);
	}
	public void agregarCur3 () {
		cur3.add(cue);
	}
	
	public void setearala () {
		ala.setNombre("Juan Carlos");
		ala.setAprobados(cur1);
	}
	public void setearalb () {
		alb.setNombre("Juan Miguel");
		alb.setAprobados(cur2);
	}
	public void setearalc () {
		alc.setNombre("Oscarcito");
		alc.setAprobados(cur3);
		alc.setCursando(cur);
	}



	@Test
	void testObtenerPrimerAlumno() {
		assertEquals(ala,cua.obtenerPrimerAlumno(alum));
	}
	
	@Test
	void testVerificarInscripcion () throws IOException {
		try {
			// no le alcancen los puntos
			assertFalse(cua.inscribir(ala));
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "El alumno "+ala.getNombre()+" no tiene los creditos minimos para ingresar a este curso");
		}
		try {
			// no tenga cupo
			assertFalse(cuc.inscribir(ala));
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "No hay cupos para este curso");
		}
		try {
			// curse mas de tres
			assertFalse(cud.inscribir(alc));
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "El alumno ya esta inscripto en 3 cursos en el ciclo "+cud.getCicloLectivo().toString());
		}
		try {
			// esté todo bien
			assertTrue(cua.inscribir(alb));
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "El alumno "+alb.getNombre()+" se ha inscripto exitosamente");
		}




		
	}

}
