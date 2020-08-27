package xyz.gauravsharma.SingletonDesignPatternDemo;

import java.io.Serializable;

public class CalculatorService implements Cloneable, Serializable {

    private static CalculatorService calculatorService;

    private CalculatorService() {
    }

    private String serviceName;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public static CalculatorService getInstance() {
        if (calculatorService == null) {
            synchronized (CalculatorService.class) {
                if (calculatorService == null) {
                    System.out.println("Calculator Service Initialized by Thread " + Thread.currentThread().getName());
                    calculatorService = new CalculatorService();
                }
            }
        }
        return calculatorService;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("If cloned.. It won't be Singleton anymore. Have an exception !");
    }

    @Override
    public String toString() {
        return "CalculatorService{" +
                "serviceName='" + serviceName + '\'' +
                '}';
    }

    protected Object readResolve() {
        return getInstance();
    }
}
