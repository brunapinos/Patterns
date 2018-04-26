package creational.AbstractFactory;
import java.util.Scanner;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;

/*
    Abstract Object
*/
abstract class Door{
    public abstract void makeSound();
    public abstract void openDoor();
}

// Wood Running Door
class WoodRunningDoor extends Door{
    
    public WoodRunningDoor(){
        makeSound();
        openDoor();
    }
    
    @Override
    public void makeSound(){
        System.out.println(" Knock knock! - I knocked on the Wood Running Door" );
    };

    @Override
    public void openDoor(){
        System.out.println(" The Wood Running Door neighbour answered!" );
    };
}

// Wood Common Door
class WoodCommonDoor extends Door{
    
    public WoodCommonDoor(){
        makeSound();
        openDoor();
    }

    @Override
    public void makeSound(){
        System.out.println(" Knock knock! - I knocked on the Wood Common Door" );
    };

    @Override
    public void openDoor(){
        System.out.println(" The Wood Common Door neighbour answered!" );
    };
}

// Wood door Factory
class WoodFactory extends DoorFactory{
    @Override
    public Door createsRunningDoor(){
        return new WoodRunningDoor();
    }

    @Override
    public Door createsCommonDoor(){
        return new WoodCommonDoor();
    }
}

// Metal Running Door
class MetalRunningDoor extends Door{
    
    public MetalRunningDoor(){
        makeSound();
        openDoor();
    }
    
    @Override
    public void makeSound(){
        System.out.println(" Knock knock! - I knocked on the Metal Running Door" );
    };

    @Override
    public void openDoor(){
        System.out.println(" The Metal Running Door neighbour answered!" );
    };
}

// Metal Common Door
class MetalCommonDoor extends Door{
    
    public MetalCommonDoor(){
        makeSound();
        openDoor();
    }
    
    @Override
    public void makeSound(){
        System.out.println(" Knock knock! - I knocked on the Metal Common Door" );
    };

    @Override
    public void openDoor(){
        System.out.println(" The Metal Common Door neighbour answered!" );
    };
}

// Metal door Factory
class MetalFactory extends DoorFactory{

    @Override
    public Door createsRunningDoor(){
        return new MetalRunningDoor();
    }

    @Override
    public Door createsCommonDoor(){
        return new MetalCommonDoor();
    }

}

// Plastic Running Door
class PlasticRunningDoor extends Door{
    
    public PlasticRunningDoor(){
        makeSound();
        openDoor();
    }

    @Override
    public void makeSound(){
        System.out.println(" Knock knock! - I knocked on the Plastic Running Door" );
    };
    @Override
    public void openDoor(){
        System.out.println(" The Plastic Running Door neighbour answered!" );
    };
}

// Plastic Common Door
class PlasticCommonDoor extends Door{
    
    public PlasticCommonDoor(){
        makeSound();
        openDoor();
    }
    @Override
    public void makeSound(){
        System.out.println(" Knock knock! - I knocked on the Plastic Common Door" );
    };

    @Override
    public void openDoor(){
        System.out.println(" The Plastic Common Door neighbour answered!" );
    };
}

// Plastic door Factory
class PlasticFactory extends DoorFactory{

    @Override
    public Door createsRunningDoor(){
        return new PlasticRunningDoor();
    }

    @Override
    public Door createsCommonDoor(){
        return new PlasticCommonDoor();
    }

}


/*
    Abstract Factory
*/
abstract class DoorFactory{
    private static final WoodFactory woodFac = new WoodFactory();
    private static final PlasticFactory plasFac = new PlasticFactory();
    private static final MetalFactory metFac = new MetalFactory();   

    static DoorFactory getFactory(String option){

        switch(option){
	        case "Wood":
	            return new WoodFactory();
	        case "Metal":
                return new MetalFactory();
            case "Plastic":
	            return new PlasticFactory();
	        default:
	           return new MetalFactory();
	    }

    }

    public abstract Door createsRunningDoor();
    public abstract Door createsCommonDoor();

}


/*
    For this example, We are building neighbours with differents
    type of doors
*/
public class DoorHouse{

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter an option (Metal, Wood or Plastic): ");
        String option = reader.nextLine();
        reader.close();

        DoorFactory factory = DoorFactory.getFactory(option);

        Door door = factory.createsCommonDoor();
        Door door2 = factory.createsRunningDoor();
    }

}
