package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class App {
	
	public static void main(String[] args) {
		Alumno alumno1 = new Alumno();
		Alumno alumno2 = new Alumno();
		Alumno alumno3 = new Alumno();
		Alumno alumno4 = new Alumno();
		Alumno alumno5 = new Alumno();
		Alumno alumno6 = new Alumno();
		Curso curso1 = new Curso();
		Curso curso2 = new Curso();
		Curso curso3 = new Curso();
		Curso curso4 = new Curso();
		Curso curso5 = new Curso();
		Curso curso6 = new Curso();
		List<Alumno> listaAlumnos0 = new ArrayList<Alumno>();
		List<Alumno> listaAlumnos1 = new ArrayList<Alumno>();
		List<Alumno> listaAlumnos2 = new ArrayList<Alumno>();
		List<Alumno> listaAlumnos3 = new ArrayList<Alumno>();
		List<Alumno> listaAlumnos4 = new ArrayList<Alumno>();
		List<Alumno> listaAlumnos5 = new ArrayList<Alumno>();
		List<Curso> listaCurso0 = new ArrayList<Curso>();
		List<Curso> listaCurso1 = new ArrayList<Curso>();
		List<Curso> listaCurso2esp = new ArrayList<Curso>();
		List<Curso> listaCurso3 = new ArrayList<Curso>();
		List<Curso> listaCurso3solo = new ArrayList<Curso>();
		List<Curso> listaCurso4solo = new ArrayList<Curso>();
		List<Curso> listaCurso4bis = new ArrayList<Curso>();
		List<Curso> listaCurso5solo = new ArrayList<Curso>();
		List<Curso> listaCurso6esp = new ArrayList<Curso>();
		
		alumno1.alumnos("Juan Carlos Ramirez", 1720, listaCurso1, listaCurso0);
		alumno2.alumnos("Rosana Tanovich", 1721, listaCurso2esp, listaCurso4bis);
		alumno3.alumnos("Tomas Fernandez", 1722, listaCurso5solo, listaCurso3);
		alumno4.alumnos("Ramiro Bakic", 1723, listaCurso3, listaCurso4solo);
		alumno5.alumnos("Laura Hickson", 1724, listaCurso2esp, listaCurso3solo);
		alumno6.alumnos("Ilia Owens", 1725, listaCurso5solo, listaCurso6esp);
		
		curso1.cursos("Matematica Discreta", 170, 3, 2020, 0, 20, listaAlumnos0);
		curso2.cursos("Algoritmos", 171, 2, 2020, 10, 20, listaAlumnos1);
		curso3.cursos("Algebra", 172, 0, 2020, 20, 30, listaAlumnos2);
		curso4.cursos("Analisis Matematico I", 173, 1, 2020, 30, 20, listaAlumnos3);
		curso5.cursos("Arquitectura de Computadoras", 174, 4, 2020, 0, 40, listaAlumnos4);
		curso6.cursos("Ingreso a Fisica", 169, 3, 2019, 0, 10, listaAlumnos5);
		

		listaAlumnos0.add(alumno3);
		listaAlumnos1.add(alumno3);
		listaAlumnos1.add(alumno6);
		listaAlumnos2.add(alumno2);
		listaAlumnos2.add(alumno3);
		listaAlumnos2.add(alumno5);
		listaAlumnos2.add(alumno6);
		listaAlumnos3.add(alumno2);
		listaAlumnos3.add(alumno4);
		listaAlumnos3.add(alumno6);
		listaAlumnos5.add(alumno6);

		listaCurso1.add(curso1);
		listaCurso2esp.add(curso1);
		listaCurso2esp.add(curso2);
		listaCurso3.add(curso1);
		listaCurso3.add(curso2);
		listaCurso3.add(curso3);
		listaCurso3solo.add(curso3);
		listaCurso4solo.add(curso4);
		listaCurso4bis.add(curso3);
		listaCurso4bis.add(curso4);
		listaCurso5solo.add(curso5);
		listaCurso6esp.add(curso2);
		listaCurso6esp.add(curso3);
		listaCurso6esp.add(curso4);
		listaCurso6esp.add(curso6);

		//FIN de asignacion de valores
		
		curso4.verificarInscripcion(alumno1);
		curso3.verificarInscripcion(alumno3);
		JOptionPane.showMessageDialog(null, "La cantidad de cursos en este ciclo son: "+alumno6.nCiclos(2020));
		JOptionPane.showMessageDialog(null, "Los creditos de "+alumno1.getNombre()+ " son "+alumno1.creditosObtenidos());
		JOptionPane.showMessageDialog(null, "Los creditos de "+alumno2.getNombre()+ " son "+alumno2.creditosObtenidos());
		JOptionPane.showMessageDialog(null, "Los creditos de "+alumno3.getNombre()+ " son "+alumno3.creditosObtenidos());
		JOptionPane.showMessageDialog(null, "Los creditos de "+alumno4.getNombre()+ " son "+alumno4.creditosObtenidos());
		JOptionPane.showMessageDialog(null, "Los creditos de "+alumno5.getNombre()+ " son "+alumno5.creditosObtenidos());
		JOptionPane.showMessageDialog(null, "Los creditos de "+alumno6.getNombre()+ " son "+alumno6.creditosObtenidos());
		
		curso1.verificarInscripcion(alumno6);
		curso3.imprimirAlumnosInscriptos();
		curso5.imprimirAlumnosInscriptos();
		
		curso5.verificarInscripcion(alumno1);
		curso5.imprimirAlumnosInscriptos();
	}
	
	
}







































