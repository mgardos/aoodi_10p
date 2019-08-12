package ar.net.mgardos;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Suma {
    private static final Map<String, BiFunction> sumaPorTipo;

    static {
        sumaPorTipo = new HashMap<>();
        sumaPorTipo.put( Entero.class.getName(), Suma.sumaFraccionEntero() );
        sumaPorTipo.put( Fraccion.class.getName(), Suma.sumaEnteroFraccion() );
    }

    public static Numero entre(Entero entero, Numero numero) {
        return (Numero) sumaPorTipo.get( numero.getClass().getName() ).apply( entero, numero );
    }

    public static Numero entre(Fraccion fraccion, Numero numero) {
        return (Numero) sumaPorTipo.get( numero.getClass().getName() ).apply( fraccion, numero );
    }

    private static BiFunction<Entero, Numero, Numero> sumaEnteroFraccion() {
        return (entero, fraccion) -> {
            return sumar( entero, (Fraccion) fraccion );
        };
    }

    private static BiFunction<Fraccion, Numero, Numero> sumaFraccionEntero() {
        return (fraccion, entero) -> {
            return sumar( fraccion, (Entero) entero );
        };
    }

    //public static Fraccion entreEnteroYNumeroFraccion(Entero entero, Numero numero) {
    public static Fraccion sumar(Entero entero, Fraccion fraccion) {
        int mcm = entero.value * fraccion.denominador.value;
        int primerSumando = mcm * entero.value;
        int segundoSumando = (mcm / fraccion.denominador.value) * fraccion.numerador.value;

        int numerador = primerSumando + segundoSumando;

        return (Fraccion) Fraccion.dividir( new Entero(numerador), new Entero(mcm) );
    }

    public static Fraccion sumar(Fraccion fraccion, Entero entero) {
        return sumar(entero, fraccion);
    }
}
