package xyz.gauravsharma.SingletonDesignPatternDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SingletonDesignPatternDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingletonDesignPatternDemoApplication.class, args);


		CalculatorService calculatorService = CalculatorService.getInstance();
		calculatorService.setServiceName("Saikat");
		String fileName="calculatorService.ser";
		//serialize to file
		try {
			SerializationUtil.serialize(calculatorService, fileName);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		calculatorService.setServiceName("Prasad");

		CalculatorService calculatorServiceNew = null;
		try {
			calculatorServiceNew= (CalculatorService) SerializationUtil.deserialize(fileName);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		System.out.println("Calculator Service Object::"+calculatorService);
		System.out.println("Calculator Service New Object::"+calculatorServiceNew);

	}

}
