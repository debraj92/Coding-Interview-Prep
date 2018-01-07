
public class Practice2_interface_inheritance {
	public static void main(String[]args) {
		/*Dog dog = new Dog("dog1");
		AnimalUtil util = new AnimalUtil();
		util.animalFeeding(dog);
		util.animalBathing(dog);
		*/
		Child1 c1 = new Child1();
		Child2 c2 = new Child2();
		c1.method1();
		c2.method1();
	}
}

interface animalfood {
	String getFoodName();
}

interface animalbath {
	String getSoapName();
}

class Dog implements animalfood, animalbath {
	String name = "";
	Dog(String n) {
		name = n;
	}
	
	@Override
	public String getSoapName() {
		return "dog soap";
	}

	@Override
	public String getFoodName() {
		return "dog food";
	}
	
}

class Cat {
	
}

class AnimalUtil {
	void animalFeeding(animalfood animal) {
		System.out.println(animal.getFoodName());
	}
	
	void animalBathing(animalbath animal) {
		System.out.println(animal.getSoapName());
	}
}


class Base {
	public void method1() {
		System.out.println("I am the base method1");
	}
}

class Child1 extends Base {
	
	@Override
	public void method1() {
		super.method1();
		System.out.println("I am the child1 method1");
	}
}

class Child2 extends Base {
	
	@Override
	public void method1() {
		//super.method1();
		System.out.println("I am the child2 method1");
	}
}

class P {
	int a;
	P(int a) {
		this.a = a;
	}
}

class C extends P {
	C(int a) {
		super(a);
	}

	int x;
	
}
