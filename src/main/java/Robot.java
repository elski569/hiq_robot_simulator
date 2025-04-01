import java.util.List;

public class Robot{
    private int x;
    private int y;
    private String dir;
    private boolean isPlaced;
    List<String> directions = List.of("NORTH", "EAST", "SOUTH", "WEST");

    public Robot(String[] place){
        this.isPlaced = false;
        setPos(place);
    }
   
    public void move(){
        switch (dir) {
            case "NORTH" -> { if (y < 4) y++; } 
            case "SOUTH" -> { if (y > 0) y--; }
            case "EAST"  -> { if (x < 4) x++; }
            case "WEST"  -> { if (x > 0) x--; }
        }

    }

    public void turn(String command){
        if(command.equals("LEFT")){
            if (directions.indexOf(dir)>0){
                this.dir = directions.get(directions.indexOf(dir)-1);
                return;
            } else {
                this.dir = "WEST";
                return;
            }
        } else if (command.equals("RIGHT")){
            if (directions.indexOf(dir)<3){
                this.dir = directions.get(directions.indexOf(dir)+1);
                return;
            } else{
                this.dir = "NORTH";
                return;
            }
        }
    }

    public String getPos(){
        return x+","+y+","+dir;
    }
    //ignore if position is invalid
    public void setPos(String[] place){
        int tempX = Integer.parseInt(place[0]);
        int tempY = Integer.parseInt(place[1]);
        String tempDir = place[2];

        if (!directions.contains(tempDir) || tempX > 4 || tempY > 4 || tempX < 0 || tempY < 0) {
            System.out.println("Invalid Position: " + tempX + "," + tempY + "," + tempDir);
            return;
        } 
        this.x = tempX;
        this.y = tempY;
        this.dir = tempDir;
        this.isPlaced = true;   
    }

    public boolean isPlaced(){
        return isPlaced;
    }
}