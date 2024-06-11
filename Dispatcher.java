package srl;
import java.io.*;
public class Dispatcher {
	public static void main(String[] args) throws Exception{
		File f = new File("C:/Users/User1/eclipse-workspace/Store/Serilization/file1");
		Car c = new Car(100, 5000, "BMW", new Engine(1500, "MANN"));
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(c);
		oos.flush();
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
		Car newCar = (Car)ois.readObject();
		ois.close();
		System.out.println(newCar.price + " " + newCar.model 
				+ " " + newCar.engine.power + " " + newCar.engine.producer + " " + newCar.weight);
	}

}
