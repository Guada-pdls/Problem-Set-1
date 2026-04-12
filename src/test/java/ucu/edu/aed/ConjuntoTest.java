package ucu.edu.aed;

import junit.framework.TestCase;
import ucu.edu.aed.tda.Alumno;
import ucu.edu.aed.tda.Conjunto;

public class ConjuntoTest extends TestCase {

    private Conjunto<Alumno> aed1;
    private Conjunto<Alumno> pf;

    private Alumno a1;
    private Alumno a2;
    private Alumno a3;
    private Alumno a4;

    public ConjuntoTest(String testName) {
        super(testName);
    }

    protected void setUp() {
        aed1 = new Conjunto<>();
        pf = new Conjunto<>();

        a1 = new Alumno(1001, "Juan", "Perez");
        a2 = new Alumno(1002, "Ana", "Lopez");
        a3 = new Alumno(1003, "Luis", "Gomez");
        a4 = new Alumno(1004, "Maria", "Diaz");

        aed1.agregar(a1);
        aed1.agregar(a2);
        aed1.agregar(a3);

        pf.agregar(a2);
        pf.agregar(a3);
        pf.agregar(a4);
    }

    public void testUnion() {
        Conjunto<Alumno> union = (Conjunto<Alumno>) aed1.union(pf);

        assertTrue(union.contiene(a1));
        assertTrue(union.contiene(a2));
        assertTrue(union.contiene(a3));
        assertTrue(union.contiene(a4));

        assertEquals(4, union.tamaño());
    }

    public void testInterseccion() {
        Conjunto<Alumno> inter = (Conjunto<Alumno>) aed1.interseccion(pf);

        assertTrue(inter.contiene(a2));
        assertTrue(inter.contiene(a3));

        assertFalse(inter.contiene(a1));
        assertFalse(inter.contiene(a4));

        assertEquals(2, inter.tamaño());
    }
}