package creational.Builder;
import java.util.Scanner;


class Bird{
    private String name;
    private String colour;
    private String size;
    private String weight;

    public void setName(String name){
        this.name = name;
    }
    public void setColour(String colour){
        this.colour = colour;
    }
    public void setSize(String size){
        this.size = size;
    }
    public void setWeight(String weight){
        this.weight = weight;
    }

    public String getName(){
        return name;
    }
    public String getColour(){
        return colour;
    }
    public String getSize(){
        return size;
    }
    public String getWeight(){
        return weight;
    }

}

/*
    Abstract Builder
*/
abstract class BirdBuilder{
    protected Bird bird; 

    
    public void createNewBird(){
        bird = new Bird();
    }

    public abstract void buildName();
    public abstract void buildColour();
    public abstract void buildSize();
    public abstract void buildWeight();

    public Bird getBird(){
        return bird;
    };
}

/*
    Tucano Builder
*/
class TucanoBuilder extends BirdBuilder{
    @Override
    public void buildName(){
        bird.setName("Tucano");
    }
    @Override
    public void buildColour(){
        bird.setColour("Preto, Branco e Laranja");
    };
    @Override
    public void buildSize(){
        bird.setSize("65cm");
    };
    @Override
    public void buildWeight(){
        bird.setWeight("876 g");
    };

}

/*
    Arara Builder
*/
class AraraBuilder extends BirdBuilder{

    @Override
    public void buildName(){
        bird.setName("Arara");
    }
    @Override
    public void buildColour(){
        bird.setColour("Azul");
    };
    @Override
    public void buildSize(){
        bird.setSize("98cm");
    };
    @Override
    public void buildWeight(){
        bird.setWeight("2000 g");
    };

}

/*
    Sabia Builder
*/
class SabiaBuilder extends BirdBuilder{
    @Override
    public void buildName(){
        bird.setName("Sabia");
    }
    @Override
    public void buildColour(){
        bird.setColour("Marrom e Laranja");
    };
    @Override
    public void buildSize(){
        bird.setSize("23cm");
    };
    @Override
    public void buildWeight(){
        bird.setWeight("100 g");
    };

}


class Vet{
    private BirdBuilder birdBuilder;

    public void setBuilder(BirdBuilder option){
        birdBuilder = option;
    }

    public void contructBird(){
        birdBuilder.createNewBird();
        birdBuilder.buildName();
        birdBuilder.buildColour();
        birdBuilder.buildSize();
        birdBuilder.buildWeight();
    }

    public Bird getBird(){
        return birdBuilder.getBird();
    }

    public void presentBird(){
        Bird bird = birdBuilder.getBird();
        System.out.println(bird.getName());
        System.out.println(bird.getColour());
        System.out.println(bird.getSize());
        System.out.println(bird.getWeight());
    }

}

/*
    This example builds differents types of birds
*/
public class LittleBird{

    public static void main(String[] args){
        
        Vet vet = new Vet();
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter which bird you'd love to see (arara, tucano or sabia):  ");
        String option = reader.nextLine(); 
        reader.close(); 
        
        BirdBuilder birdBuilder;
        
        switch(option){
            case "arara":
                birdBuilder = new AraraBuilder();
                vet.setBuilder(birdBuilder);
                break;
            case "tucano":
                birdBuilder = new TucanoBuilder();
                vet.setBuilder(birdBuilder);
                break;
            case "sabia":
                birdBuilder = new SabiaBuilder();
                vet.setBuilder(birdBuilder);
                break;  
        }

        vet.contructBird();
        vet.presentBird();

        
    }
}