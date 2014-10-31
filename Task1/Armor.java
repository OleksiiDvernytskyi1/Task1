package Task1;

class Armor implements Comparable {

	private double itemWeight;
	private double price;
	private String name;
	
	public Armor(String name, double price, double weight){
		this.price = price;
		this.itemWeight = weight;
		this.name = name;
	}
	public double getWeght(){
		return itemWeight;
	};
	public double getPrice(){
		return price;
	}
	public String getName(){
		return name;
	}
	
	@Override
	public int compareTo(Object arg0) {
		Armor armor2 = (Armor)arg0;
		if(Math.round(this.getWeght()) > Math.round(armor2.getWeght())){
			return 1;
		}else {
			if(Math.round(this.getWeght()) < Math.round(armor2.getWeght())){
				return -1;
			}
		}
		
		return 0;
	};
	
	
}
