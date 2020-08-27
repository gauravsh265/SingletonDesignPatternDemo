package xyz.gauravsharma.SingletonDesignPatternDemo;

import xyz.gauravsharma.SingletonDesignPatternDemo.SerializationUtil;

import java.io.IOException;

public class MainClass {

    /* Problem in multi threaded environment..
    *
    public static void main(String[] args) {

        Thread  t1 = new Thread("First") {
            @Override
            public void run() {
                CalculatorService calculatorService = CalculatorService.getInstance();
            }
        };

        Thread  t2 = new Thread("Second") {
            @Override
            public void run() {
                CalculatorService calculatorService = CalculatorService.getInstance();
            }
        };


        t1.start();
        t2.start();

    }

    *
    *
    */

    /*
    Solution for above prob - double check locking.
        In getInstance Method.
     */

    /**
     * Cloning spoinling Singleton.. stopped by implementing Clone and throwing Exception there..
       public static void main(String[] args) {

     Thread  t1 = new Thread("First") {
    @Override
    public void run() {
    CalculatorService calculatorService = CalculatorService.getInstance();
    try {
    calculatorService.clone();
    } catch (CloneNotSupportedException e) {
    e.printStackTrace();
    }
    }
    };

     Thread  t2 = new Thread("Second") {
    @Override
    public void run() {
    CalculatorService calculatorService = CalculatorService.getInstance();
    }
    };


     t1.start();
     t2.start();

     }
     *
     *
     */



   /* public static void main(String[] args) {

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

    }*/
}
