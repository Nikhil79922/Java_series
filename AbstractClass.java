
public class AbstractClass {

    public static void main(String[] args) {
        Car e = new ElectricCar();
        e.accelerate();
        e.start();
        e.chalan();

        Car f = new FuelCar();
        f.accelerate();
        f.start();
        f.chalan();
    }
}

// abstract class Car {
//     abstract void accelerate();
//     abstract void start();
//     void chalan() {
//         System.out.println("police police police");
//     }
// ;
// }
// class ElectricCar extends Car {
//     @Override
//     void accelerate() {
//         System.out.println("Electric car accelerated");
//     }
//     @Override
//     void start() {
//         System.out.println("Electric car started .....");
//     }
// }
// class FuelCar extends Car {
//     @Override
//     void accelerate() {
//         System.out.println("Fuel car accelerated");
//     }
//     @Override
//     void start() {
//         System.out.println("Fuel car started .....");
//     }
// }
interface Car {

    void accelerate();

    void start();

    // void chalan() {
    //     System.out.println("police police police");   // This will give you error , as interfaces are only used to declare the roles and responsibility , not define. 
    // }
    void chalan();
;

}

class ElectricCar implements Car {

    @Override
    public void accelerate() {
        System.out.println("Electric car accelerated");
    }

    @Override
    public void start() {
        System.out.println("Electric car started .....");
    }

    @Override
    public void chalan() {
        System.out.println("CHalan kata for the Electric Cars");
    }

}

class FuelCar implements Car {

    @Override
    public void accelerate() {
        System.out.println("Fuel car accelerated");
    }

    @Override
    public void start() {
        System.out.println("Fuel car started .....");
    }

    @Override
    public void chalan() {
        System.out.println("CHalan kata for the fuel Cars");
    }

}
