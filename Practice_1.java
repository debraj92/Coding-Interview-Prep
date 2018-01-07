
public class Practice_1 {
	public static void main(String[]args) {
		SellerUtility util = new SellerUtility();
		/*Photo photo = new Photo();
		Poster poster = new Poster();
		TV tv = new TV();
		SellerUtility util = new SellerUtility();
		util.markItemAsSold(photo);
		util.markItemAsSold(poster);
		//util.markItemAsSold(tv);
		 * */
		/*Photo p1 = new Photo();
		p1.setColor("red");
		p1.setname("P1 photo");
		Photo p2 = new Photo();
		p2.setColor("white");
		p2.setname("P2 photo");
		System.out.println(p1.getColor());
		util.markItemAsSold(p1);
		System.out.println(p2.getColor());
		util.markItemAsSold(p2);
		*/
		Photo photo = new Photo();
		photo.setname("myphoto");
		Poster poster = new Poster();
		Sellable[] items = new Sellable[2];
		items[0] = photo; // Sellable item1 = new Photo();
		//item1.setColor("blue");
		//photo.setColor("yellow");
		items[1] = poster;
		util.markItemAsSold(items);
	}
}



interface Sellable {
	int getmrp();
	String getname();
}

class Photo implements Sellable {
	String color = "";
	String name = "";
	@Override
	public int getmrp() {
		return 100;
	}

	@Override
	public String getname() {
		return name;
	}
	
	public void setColor(String c){
		color = c;
	}
	
	public String getColor(){
		return color;
	}
	
	public void setname(String n) {
		name = n;
	}
}

class Poster implements Sellable {

	@Override
	public int getmrp() {
		return 50;
	}

	@Override
	public String getname() {
		return "Poster5";
	}
	
}

class TV {
	public int getmrp() {
		return 100;
	}

	public String getname() {
		return "Photo1";
	}
}

class SellerUtility {
	void markItemAsSold(Sellable item) {
		//item.setColor("blue");
		System.out.println(item.getname()+"_sold");
	}
	
	void markItemAsSold(Sellable[] items) {
		//item.setColor("blue");
		for(int i=0;i<items.length;i++) {
			System.out.println(items[i].getname()+"_sold");
		}
		
	}
}