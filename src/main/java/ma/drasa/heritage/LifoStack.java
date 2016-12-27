package ma.drasa.heritage;

import java.util.concurrent.atomic.AtomicInteger;

public class LifoStack implements Stack {

	private Integer size = 10;
	private Object elements [] = null;
	private volatile AtomicInteger index;
	
	public LifoStack(Integer size) {
		if (size != null) 
			this.size = size;
	
		elements = new Object[this.size];
		index = new AtomicInteger(0);
	}
	
	public void push (Object element) {
		if (index.get() == size)
			throw new ArrayIndexOutOfBoundsException();
			
		elements[index.getAndIncrement()] = element;
	}
	
	public void pushAll (Object putElements[]) {
		for (Object element : putElements) {
			push(element);
		}
	}
	
	public Object pop() {
		if (index.get() == 0) 
			throw new ArrayIndexOutOfBoundsException();
		
		return elements[index.decrementAndGet()];
	}
	
	public Object[] popAll() {
		index = new AtomicInteger(0);
		Object resElements [] = elements.clone();
		
		for (int i = 0; i < elements.length; i++) {
			elements[i] = null;
		}
		
		return resElements;
	}

	public Integer length() {
		return index.get();
	}
	
}
