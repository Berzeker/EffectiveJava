package ma.drasa.heritage;

public class Main {

	public static void main(String[] args) {
		
		Integer tab [] = {1, 2, 3, 4, 5};
		
		Stack stack = new LifoStack(7);
		stack.pushAll(tab);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);

		
		System.out.println(stack.popAll());
		System.out.println(stack.length());
		
	}

}
