package srl;
import java.io.*;
public class Car extends Machine implements Serializable {
	int price;
	String model;
	transient Engine engine;
	Car(int weight, int price, String model, Engine engine){
		super(weight);
		this.price = price;
		this.model = model;
		this.engine = engine;
	}
	private void writeObject(ObjectOutputStream oos) {
		try {
		oos.defaultWriteObject();
		oos.writeInt(engine.power);
		oos.writeObject(engine.producer);
		}catch(IOException e) {}
	}
	private void readObject(ObjectInputStream ois) {
		try {
		ois.defaultReadObject();
		this.engine = new Engine(ois.readInt(),(String) ois.readObject());
		}catch(IOException e) {}
		catch(ClassNotFoundException e) {};
	}
}
class Engine {
	int power;
	String producer;
	Engine(int power, String producer){
		this.power = power;
		this.producer = producer;
	}
}
class Machine {
	int weight;
	Machine(int weight){
		this.weight = weight;
	}
	Machine(){}
}