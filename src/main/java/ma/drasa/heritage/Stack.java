package ma.drasa.heritage;

public interface Stack {

	void push (Object element);
	void pushAll (Object putElements[]);
	Object pop();
	Object[] popAll();
	Integer length();
}
