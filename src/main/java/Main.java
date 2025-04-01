import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main(String[]args){
        if (args.length < 1) {
            System.out.println("Format: java Main <input-file>");
            return;
        }
        List<String> turn = List.of("LEFT", "RIGHT");
        String filePath = args[0];
        try {
            String content = Files.readString(Paths.get(filePath));
            List<String> words = Arrays.asList(content.split("\\s+"));
            if(words.contains("PLACE")){
                int placeIndex = words.indexOf("PLACE")+1;
                Robot rob = new Robot(words.get(placeIndex).split(","));
                for(int i=placeIndex+1; i<words.size(); i++){
                    String command = words.get(i);
                    if (!rob.isPlaced()) {
                        if (command.equals("PLACE")) {
                            rob.setPos(command.split(","));
                        }
                        continue;
                    }
                    if(turn.contains(command)){
                        rob.turn(command);
                    } else if(command.equals("REPORT")){
                        System.out.println("Output:"+rob.getPos());
                    }else if(command.equals("MOVE")){
                        rob.move();
                    }else if(command.equals("PLACE")){
                        i++;
                        rob.setPos(words.get(i).split(","));
                    } else{
                        System.out.println("Ignoring non-existing commands");
                    }
                }
            } else{
                System.out.println("File most set Robots starting position with command PLACE");
                return;
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

    }
}