import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RobotTests {
  
    @Test
    public void testInitialPosition() {
        Robot robot = new Robot(new String[]{"0", "0", "NORTH"});
        assertEquals("0,0,NORTH", robot.getPos());
    }

    @Test
    public void testInvalidInitialPosition() {
        Robot robot = new Robot(new String[]{"-1", "0", "NORTH"});
        assertFalse(robot.isPlaced());
    }

    @Test
    public void testSetPosition() {
        Robot robot = new Robot(new String[]{"0", "0", "NORTH"});
        robot.setPos(new String[]{"1", "1", "SOUTH"});
        assertEquals("1,1,SOUTH", robot.getPos());
    }

    @Test
    public void testSetInvalidPosition() {
        Robot robot = new Robot(new String[]{"1", "1", "SOUTH"});
        robot.setPos(new String[]{"0", "-1", "SOUTH"});
        assertEquals("1,1,SOUTH", robot.getPos());
        assertTrue(robot.isPlaced());
    }

    @Test
    public void testSimpleMove() {
        Robot robot = new Robot(new String[]{"0", "0", "NORTH"});
        robot.move();
        assertEquals("0,1,NORTH", robot.getPos());
    }

    @Test
    public void testTurnLeft() {
        Robot robot = new Robot(new String[]{"0", "0", "NORTH"});
        robot.turn("LEFT");
        assertEquals("0,0,WEST", robot.getPos());
        robot.turn("LEFT");
        assertEquals("0,0,SOUTH", robot.getPos());
        robot.turn("LEFT");
        assertEquals("0,0,EAST", robot.getPos());
    }

    @Test
    public void testTurnRight() {
        Robot robot = new Robot(new String[]{"0", "0", "EAST"});
        robot.turn("RIGHT");
        assertEquals("0,0,SOUTH", robot.getPos());
        robot.turn("RIGHT");
        assertEquals("0,0,WEST", robot.getPos());
        robot.turn("RIGHT");
        assertEquals("0,0,NORTH", robot.getPos());
    }

    @Test
    public void testLowerBoundaryCheck() {
        Robot robot = new Robot(new String[]{"0", "0", "SOUTH"});
        robot.move();
        assertEquals("0,0,SOUTH", robot.getPos());
        robot.turn("RIGHT");
        robot.move();
        assertEquals("0,0,WEST", robot.getPos());
        robot.turn("RIGHT");
        robot.move();
        assertEquals("0,1,NORTH", robot.getPos());
        robot.turn("RIGHT");
        robot.move();
        assertEquals("1,1,EAST", robot.getPos());

    }

    @Test
    public void testUpperBoundaryCheck() {
        Robot robot = new Robot(new String[]{"4", "4", "NORTH"});
        robot.move(); 
        assertEquals("4,4,NORTH", robot.getPos());
        robot.turn("RIGHT");
        robot.move();
        assertEquals("4,4,EAST", robot.getPos());
        robot.turn("RIGHT");
        robot.move();
        assertEquals("4,3,SOUTH", robot.getPos());
        robot.turn("RIGHT");
        robot.move();
        assertEquals("3,3,WEST", robot.getPos());
    }

    @Test
    public void testInvalidDirection() {
        Robot robot = new Robot(new String[]{"2", "2", "UP"});
        assertFalse(robot.isPlaced());
    }
    @Test
    public void testInvalidDirectionReset() {
        Robot robot = new Robot(new String[]{"0", "0", "NORTH"});
        robot.setPos(new String[]{"2", "2", "UP"});
        assertTrue(robot.isPlaced());
        assertEquals("0,0,NORTH", robot.getPos());
    }
}