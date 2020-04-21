package died.guia06;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlumnoTest {
	Alumno a = new Alumno();
	Alumno b = new Alumno();
	Alumno c = new Alumno();
	
	
	@Test
	void testEquals () {
		a.setNroLibreta(1722);
		b.setNroLibreta(1701);
		c.setNroLibreta(1701);
		assertTrue(a.equals(c, b));
		assertFalse(a.equals(a, b));
		assertFalse(a.equals(a, c));
	}

	@Test
	void testComparar() {
		a.setNombre("Joaquin Fernandez");
		b.setNombre("Juan Diego Fernandez");
		c.setNombre("Joaquin Fernandez");
		String anombre = a.getNombre();
		String bnombre = b.getNombre();
		assertEquals(anombre + " figura en la lista antes que "+bnombre ,a.comparar(a,b));
		assertEquals(bnombre + " figura en la lista antes que "+anombre ,a.comparar(b,a));
		assertEquals("Los alumnos tienen el mismo nombre o son el mismo alumno: "+anombre ,a.comparar(a,c));
	}
	
	
	@Test
	void testCreditosObtenidos() {
		fail("Not yet implemented");
	}

	@Test
	void testAprobar() {
		fail("Not yet implemented");
	}

	@Test
	void testInscripcionAceptada() {
		fail("Not yet implemented");
	}

}
