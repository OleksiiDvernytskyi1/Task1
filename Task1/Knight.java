package Task1;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Knight {

	private ArrayList<Armor> eqipment  = new ArrayList<Armor>();
	
	public Knight(){
		
	}
	public void add(Armor armor){
		eqipment.add(armor);
	}
	
	//сортировка снаряжения по весу
	public void sort(){
		Armor[] tmp = new Armor[eqipment.size()];
		
		for(int i = 0; i <eqipment.size() ; i++){
			tmp[i] = eqipment.get(i);
		}
		Arrays.sort(tmp);
		eqipment = new ArrayList<Armor>(tmp.length);
		for(int i = 0; i< tmp.length ; i++){
			eqipment.add(tmp[i]);
		}
		
	}
	
	public void remove(String name){
		for(int i = 0; i < eqipment.size(); i++){
			if(eqipment.get(i).getName().equals(name)){
				eqipment.remove(i);
				i--;
			}
				
		}
	}
	
	public int getTotalPrice(){
		int summ = 0 ; 
		for(int i = 0; i<eqipment.size(); i++){
			summ += eqipment.get(i).getPrice();
		}
		return summ;
	}
	
	public Armor[] getArmorWithPrice(double priceL, double priceH){
		ArrayList <Armor> armor = new ArrayList<Armor>();
		for(int i = 0; i<eqipment.size(); i++ ){
			if((eqipment.get(i).getPrice() > priceL) & (eqipment.get(i).getPrice() < priceH)){
				armor.add(eqipment.get(i));
			}
		}
		
		Armor[] arm = new Armor[armor.size()];
		arm = armor.toArray(arm);
		
		return arm;
	}
	
	public static void main(String[] args) {
		Knight knight = new Knight();
		
		while(true){
			int scannerInt = 0;
			double scannerDouble = 0;
			System.out.println("1 - добавлене экипировки");
			System.out.println("2 - удалить предмет экипировки");
			System.out.println("3 - вывести всю экипировку на экран");
			System.out.println("4 - вывести экипировку в заданном диапазоне цен");
			System.out.println("5 - подсчет стоимости экипировки");
			System.out.println("0 - выход");
			System.out.print("сделайте выбор : ");
			Scanner sc = new Scanner(System.in);
			String scanner = sc.nextLine();
			
			try{
				scannerInt = Integer.parseInt(scanner);
			}
			catch(Exception e){
				System.out.println("Неправильный ввод");
				continue;
			}
			
			switch(scannerInt){
			case (1):
				System.out.println("Введите название экипировки : ");
				String name = sc.nextLine().trim();
								
				System.out.println("Введите стоимость : ");
				scanner = sc.nextLine();
				
				try{
					scannerDouble = Double.parseDouble(scanner);
				}
				catch(Exception e){
					System.out.println("Неправильный ввод");
					continue;
				}
				double price = scannerDouble;
				
				System.out.println("Введите вес : ");
				scanner = sc.nextLine();
				
				try{
					scannerDouble = Double.parseDouble(scanner);
				}
				catch(Exception e){
					System.out.println("Неправильный ввод");
					continue;
				}
				double weight = scannerDouble;
				
				knight.add(new Armor(name, price, weight));
				
				break;
				
			case 2:
				System.out.println("Введите название предмета, который хотите удалить : ");
				scanner = sc.nextLine().trim();
				
				for(int i = 0; i < knight.eqipment.size() ; i++ ){
					Armor tmp = knight.eqipment.get(i);
					if(scanner.equals(tmp.getName())){
						knight.eqipment.remove(i);
						System.out.println("Предмет удален");
					}
				}
				break;
				
			case 3:	
				knight.sort();
				System.out.println("Экипировка рыцаря : ");
				for(int i = 0; i < knight.eqipment.size() ; i++ ){
					Armor tmp = knight.eqipment.get(i);
					System.out.println("Название : " + tmp.getName());
					System.out.println("    Вес  : " + tmp.getWeght());
					System.out.println("    Цена : " + tmp.getPrice());
				}
				break;
			case 4:	
				System.out.print("Ведите минимальную цену : ");
				scanner = sc.nextLine();
				double min, max;
				
				try{
					min = Double.parseDouble(scanner);
				}
				catch(Exception e){
					System.out.println("Неправильный ввод");
					continue;
				}
				
				System.out.print("Ведите максимальную цену : ");
				scanner = sc.nextLine();
				
				try{
					max = Double.parseDouble(scanner);
				}
				catch(Exception e){
					System.out.println("Неправильный ввод");
					continue;
				}
				
				for(int i = 0; i < knight.eqipment.size() ; i++ ){
					Armor tmp = knight.eqipment.get(i);
					if(tmp.getPrice() > min & tmp.getPrice() < max){
						System.out.println("Название : " + tmp.getName());
						System.out.println("    Вес  : " + tmp.getWeght());
						System.out.println("    Цена : " + tmp.getPrice());
					}
				}
				break;
			
			
			case 5:	
				double summ = 0;
				
				for(int i = 0; i < knight.eqipment.size() ; i++ ){
					summ += knight.eqipment.get(i).getPrice();
				}
				
				System.out.println("Стоимость экипировки : "+ summ);
				break;			
			
			case 0:
				System.exit(0);
			}	
			
			
		}
		
	}

}
