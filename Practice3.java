
public class Practice3 {
	public static void main(String[]args){
		Base2 b = new Base2();
		Child c = new Child();
		//b.printVal();
		//c.printVal();
		Base2 b2 = c; //upcast (or generalization) is supported in both inheritance and interfaces
		System.out.println(b2.parent_value);
		b2.printVal();
		//System.out.println(c.child_value);
		//Child c2 = (Child) b; // downcast (or specialization) is not supported in inheritance
		Base2 b3 = new Child();
		Dog2 dog = new Dog2();
		Move move = dog; // upcast supported for interface
		move.walk();
		//move.bark();// bark is invisible
		//Dog2 dog2= move; // downcast  ... NOT ALLOWED WITHOUT EXPLICIT CASTING (or risk taking)
		Dog2 dogX = (Dog2) move; // This down cast is allowed for interfaces
		dogX.walk();
		dogX.bark();
		
		/*Move move1 = new Move() {
			@Override
			public void walk() {
				System.out.println("I am an anonymous Move, I will now walk");
			}
		};
		move1.walk();*/
		
		startMoving(new Move() {
			@Override
			public void walk() {
				System.out.println("I am an anonymous Move, I will now walk");
			}
		});
		
		Move move2 = new Cat2();
		if(move2 instanceof Dog2){
		Dog2 dogY = (Dog2) move2; // downcast (or specialization) is supported in interface
		} else {
			System.out.println("Move2 is not a dog2");
		}
	}
	
	static void startMoving(Move move) {
		move.walk();
	}
}

class Base2 {
	String parent_value = "Base2";
	
	public void printVal() {
		System.out.println(parent_value);
	}
}

class Child extends Base2 {
	String child_value = "Child2";
	//String parent_value = "ChildBase2";
	
	@Override
	public void printVal() {
		super.printVal();
		System.out.println(child_value);
	}
}


interface Move {
	void walk();
}

class Dog2 implements Move {

	@Override
	public void walk() {
		System.out.println("Dog walk");
	}
	
	public void bark() {
		System.out.println("Dog bark");
	}
	
}

class Cat2 implements Move {

	@Override
	public void walk() {
		System.out.println("Cat walk");
	}
	
}

