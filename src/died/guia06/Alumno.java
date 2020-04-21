package died.guia06;

import java.util.List;


import javax.swing.JOptionPane;


public class Alumno implements Comparable {

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	

	public void alumnos (String a, int b, List<Curso> c, List<Curso> d) {
		this.setNombre(a);
		this.setNroLibreta(b);
		this.setAprobados(c);
		this.setCursando(d);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNroLibreta() {
		return nroLibreta;
	}

	public void setNroLibreta(Integer nroLibreta) {
		this.nroLibreta = nroLibreta;
	}

	public List<Curso> getCursando() {
		return cursando;
	}

	public void setCursando(List<Curso> cursando) {
		this.cursando = cursando;
	}

	public List<Curso> getAprobados() {
		return aprobados;
	}

	public void setAprobados(List<Curso> aprobados) {
		this.aprobados = aprobados;
	}

	public int creditosObtenidos() {
		int contador = 0;
		for (Curso c: aprobados) {
			contador += c.getCreditos().intValue();
		}
		return contador;
	}

	public void aprobar(Curso c) {
		//
	}

	public void inscripcionAceptada(Curso c) {
		//
	}
	
	public int nCiclos (int ciclo) {
		int contador = 0;
		for (Curso c: cursando) {
			if (c.getCicloLectivo().intValue()==ciclo) {
				contador++;
			}
		}
		return contador;
	}
	
	public boolean equals (Alumno a, Alumno b) {
		if (b.nroLibreta == a.nroLibreta) {
			JOptionPane.showMessageDialog(null, "Son el mismo alumno");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "No son el mismo alumno");
			return false;
		}
	}
 
	@Override
	public String comparar(Alumno a, Alumno b) {
		String mensaje = new String();
		if (a.nombre.compareTo(b.nombre) < 0 ) {
			mensaje = a.nombre+ " figura en la lista antes que "+b.nombre;
			JOptionPane.showMessageDialog(null, mensaje );
			return mensaje;
		} else if (a.nombre.compareTo(b.nombre) > 0 ) {
			mensaje = b.nombre+ " figura en la lista antes que "+a.nombre;
			JOptionPane.showMessageDialog(null, mensaje );
			return mensaje;
		} else {
			mensaje = "Los alumnos tienen el mismo nombre o son el mismo alumno";
			JOptionPane.showMessageDialog(null, mensaje );
			return mensaje;
		}

		
	}
	

	
	

}
