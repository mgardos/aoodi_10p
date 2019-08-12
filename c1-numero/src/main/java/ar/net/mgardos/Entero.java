/*
 * Developed by 10Pines SRL
 * License: 
 * This work is licensed under the 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License. 
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-sa/3.0/ 
 * or send a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, 
 * California, 94041, USA.
 *  
 */
package ar.net.mgardos;

public class Entero extends Numero {

	protected int value;

	public Entero(int value) {
		this.value = value;
	}

	public int value() {
		return value;
	}

	@Override
	public Numero mas(Numero sumando)  {
		/*System.out.println( sumando.getClass() );
		try {
			Class c = Class.forName( sumando.getClass().getName() );
			Suma.entre( this, c, sumando );
		} catch (Exception e) {}*/

		/*try {
			sumando =  new Entero( value + ((Entero) sumando).value() );
		} catch (Exception ex) {
			System.out.println( "El sumando no es entero!" );
		}

		try {
			sumando = Suma.entreEnteroYNumeroFraccion( this, sumando );
		} catch (Exception ex) {
			System.out.println( "El sumando no es fraccion!" );
		}*/

		//return sumando;

        return sumando.sumarEntero(this);

		//return Suma.entre( this, sumando );
	}

	Numero sumarEntero(Entero entero) {
		return new Entero( value + entero.value() );
    }

    Numero sumarFraccion(Fraccion fraccion) {
		int mcm = value * fraccion.denominador.value;
		int primerSumando = mcm * value;
		int segundoSumando = (mcm / fraccion.denominador.value) * fraccion.numerador.value;

		int numerador = primerSumando + segundoSumando;

		return (Fraccion) Fraccion.dividir( new Entero(numerador), new Entero(mcm) );
    }

	@Override
	public Numero por(Numero multiplicador) {
		return new Entero(value * ((Entero) multiplicador).value());
	}

	@Override
	public Numero dividido(Numero divisor) {
		return Fraccion.dividir(this, (Entero) divisor);
	}

	@Override
	public boolean esCero() {
		return value == 0;
	}

	@Override
	public boolean esUno() {
		return value == 1;
	}

	@Override
	public boolean equals(Object anObject) {
		if (anObject instanceof Entero)
			return value == ((Entero) anObject).value();
		else
			return false;
	}

	@Override
	public int hashCode() {
		return value;
	}

	public Entero maximoComunDivisorCon(Entero otroEntero) {
		if (otroEntero.esCero())
			return this;
		else
			return otroEntero.maximoComunDivisorCon(this.restoCon(otroEntero));
	}

	public Entero restoCon(Entero divisor) {
		return new Entero(value % divisor.value());
	}

	public Entero divisionEntera(Entero divisor) {
		return new Entero(value / divisor.value());
	}

}
