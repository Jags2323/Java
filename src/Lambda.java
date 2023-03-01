import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda {
    public static void main(String[] args) {

        // Imperative style
        Game football = new Game(){
            @Override
            public void play() {
                System.out.println("play fifa");
            }
        };
        football.play();

        //Using Lambda
        Game Cricket = () ->
                System.out.println("play cric");

        Cricket.play();

        List<String> listOfPlayers = Arrays.asList(
                "Kohli", "sachin", "sehwag");
        //iterator
        for(String listOfPlayer: listOfPlayers){
            if(listOfPlayer.equals("sehwag")){
                System.out.println("sehwag is in the squad");
            }
        }

        //java 8 implementation using streams
        listOfPlayers.stream()
                .filter(listOfPlayer -> listOfPlayer.equals("sehwag"))
                .forEach(listOfPlayer-> System.out.println("sehwag is in the squad"));
        // optional class to store the string
        Optional<String> sehwag = listOfPlayers.stream()
                .filter(listOfPlayer -> listOfPlayer.equals("sehwag"))
                .findAny();

        if(sehwag.isPresent()){
            System.out.println("yes");
        }


    }
}

interface Game{
    void play();
}
