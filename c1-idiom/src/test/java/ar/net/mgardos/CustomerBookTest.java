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

import org.junit.Before;
import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CustomerBookTest {
	private static final Long ADD_CUSTOMER_THRESHOLD = 50L;
	private static final Long REMOVE_CUSTOMER_THRESHOLD = 100L;
	private static final String[] SINGERS = {"John Lennon", "Paul McCartney"};

	protected CustomerBook customerBook;

	@Before
	public void setUp() {
		customerBook = new CustomerBook();
	}

	@Test
	public void testAddingCustomerShouldNotTakeMoreThan50Milliseconds() {
		assertThresholdNotExceeded(singer -> customerBook.addCustomerNamed(singer), SINGERS[0], ADD_CUSTOMER_THRESHOLD);
	}

	@Test
	public void testRemovingCustomerShouldNotTakeMoreThan100Milliseconds() {
		customerBook.addCustomerNamed(SINGERS[1]);

		assertThresholdNotExceeded(singer -> customerBook.removeCustomerNamed(singer), SINGERS[1], REMOVE_CUSTOMER_THRESHOLD);
	}

	private void assertThresholdNotExceeded(Consumer<String> consumer, String singer, long threshold) {
		long millisecondsBeforeRunning = System.currentTimeMillis();
		consumer.accept(singer);
		long millisecondsAfterRunning = System.currentTimeMillis();

		assertThat(millisecondsAfterRunning - millisecondsBeforeRunning).isLessThan(threshold);
	}

	@Test
	public void testCanNotAddACustomerWithEmptyName() {
		test(singer -> customerBook.addCustomerNamed(singer), "", exception -> {
			assertThat(CustomerBook.CUSTOMER_NAME_EMPTY).isEqualTo( exception.getMessage() );
			assertThat(customerBook.isEmpty()).isTrue();
		});
	}

	@Test
	public void testCanNotRemoveNotAddedCustomers() {
		test(singer -> customerBook.removeCustomerNamed(singer), "John Lennon", exception -> {
			assertThat(CustomerBook.INVALID_CUSTOMER_NAME).isEqualTo( exception.getMessage() );
			assertThat(customerBook.numberOfCustomers()).isZero();
		});
	}

	private <T extends Throwable> void test(Consumer<String> consumer, String singer, Consumer<T> exceptionAssertion) {
		try {
			consumer.accept( singer );
			fail();
		} catch (Exception ex) {
			exceptionAssertion.accept( (T) ex );
		}
	}
}
