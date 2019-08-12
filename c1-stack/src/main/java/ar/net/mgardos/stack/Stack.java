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
package ar.net.mgardos.stack;

public class Stack<T> {
	private StackElement _firstElement;
	private StackElement _currentElement;
	int _size;

	public static final String STACK_EMPTY_DESCRIPTION = "Stack is Empty";

	public Stack() {
		_firstElement = new StackElement();
		_currentElement = _firstElement;
		_currentElement._prev = _firstElement;
		_size = 0;
	}

	public void push(T obj) {
	    _currentElement._obj = obj;
        StackElement e = new StackElement();
        e._prev = _currentElement;
        _currentElement = e;
        _size++;
	}

	public T pop() {
		T obj = _currentElement._prev._obj;
		_currentElement = _currentElement._prev;
		_size--;
		return obj;
	}

	public Object top() {
		return _currentElement._prev._obj;
	}

	public Boolean isEmpty() {
		return _firstElement == _currentElement;
	}

	public Integer size() {
		return _size;
	}

	private T shouldImplement() {
		throw new RuntimeException("Should Implement");
	}

	private class StackElement {
		T _obj;
		StackElement _prev;

		StackElement() {}

		StackElement(T obj) {
			_obj = obj;
		}
	}
}
