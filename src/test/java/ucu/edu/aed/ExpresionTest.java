package ucu.edu.aed;

import junit.framework.TestCase;

import java.util.LinkedList;

public class ExpresionTest extends TestCase {

    private Expresion exp;

    public ExpresionTest(String testName) {
        super(testName);
    }

    protected void setUp() {
        exp = new Expresion();
    }

    private LinkedList<String> convertir(String input) {
        LinkedList<String> lista = new LinkedList<>();
        for (char c : input.toCharArray()) {
            lista.add(String.valueOf(c));
        }
        return lista;
    }

    public void testExpresionValida() {
        assertTrue(exp.controlCorchetes(convertir("{}")));
        assertTrue(exp.controlCorchetes(convertir("{{}}")));
        assertTrue(exp.controlCorchetes(convertir("{}{}")));
    }

    public void testExpresionInvalida() {
        assertFalse(exp.controlCorchetes(convertir("{{}")));
        assertFalse(exp.controlCorchetes(convertir("{}}")));
        assertFalse(exp.controlCorchetes(convertir("}{")));
        assertFalse(exp.controlCorchetes(convertir("{")));
        assertFalse(exp.controlCorchetes(convertir("}")));
    }

}