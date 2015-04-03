import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player
 {
	private Scanner in;
	private List<Floor> floors = new ArrayList<Floor>();

    public static void main(String args[])    
    {
		Player player = new Player();
		player.go();
	}
	
	private void go()
	{
		initialise();
		gameLoop();
	}
	
	private void initialise()
	{
	
        in = new Scanner(System.in);
        int nbFloors = in.nextInt(); // number of floors
        int width = in.nextInt(); // width of the area
        int nbRounds = in.nextInt(); // maximum number of rounds
        int exitFloor = in.nextInt(); // floor on which the exit is found
        int exitPos = in.nextInt(); // position of the exit on its floor
        int nbTotalClones = in.nextInt(); // number of generated clones
        int nbAdditionalElevators = in.nextInt(); // number of additional elevators that can be built
        int nbElevators = in.nextInt(); // number of elevators
        
        for(int i = 0; i < nbFloors; i++)
        {
			floors.add(new Floor(i));
			if(i == exitFloor)
			{
				floors.get(floors.size()-1).addExit(exitPos);
			}
		}
		
        for (int i = 0; i < nbElevators; i++) 
        {
            int elevatorFloor = in.nextInt(); // floor on which this elevator is found
            int elevatorPos = in.nextInt(); // position of the elevator on its floor
            
            floors.get(elevatorFloor).addOutElevator(elevatorPos);
            floors.get(elevatorFloor+1).addInElevator(elevatorPos);     
            
            floors.get(elevatorFloor).setTarget();
            floors.get(elevatorFloor+1).setTarget();				
		}
	}
	
	private void gameLoop()
	{
		String message;
		//int loopCount = 1;
		// game loop
        while (true)
        {
            int cloneFloor = in.nextInt(); // floor of the leading clone
            int clonePos = in.nextInt(); // position of the leading clone on its floor
            String direction = in.next(); // direction of the leading clone: LEFT or RIGHT
            
			//if the floor has no elevator and is not the exit floor, build one
            				
            
            if(cloneFloor < 0)
            {
				message = "WAIT";
			}
			
			else if(cloneFloor > -1 && floors.get(cloneFloor).hasBlock())
			{
				message = "WAIT";
			}
			
			else if(floors.get(cloneFloor).getTarget() == 0)
            {
				message = "ELEVATOR";
				floors.get(cloneFloor).addOutElevator(clonePos);
				floors.get(cloneFloor+1).addInElevator(clonePos);     
            
				floors.get(cloneFloor).setTarget();
				floors.get(cloneFloor+1).setTarget();
			}
			
			else
			{
            
				int target = floors.get(cloneFloor).getTarget(); 
				
				if(clonePos > target && direction.equals("RIGHT"))
				{
					message = "BLOCK";
				}
				
				else if(clonePos < target && direction.equals("LEFT"))
				{
					message = "BLOCK";
				}
				
				else
				{
					message = "WAIT";
				} 
			}                 
			            
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println(message); // action: WAIT or BLOCK
            //loopCount++;
        }
    }
}

class Floor
{
	private int level;
	private int inElevator;
	private int outElevator;
	private int target;
	private int exit;
	private boolean isExitFloor = false;
	private boolean hasBlock = false;
	//private ArrayList<String> messages = new ArrayList<String>();
	
	public Floor(int level)
	{
		this.level = level;
		
		if(level == 0);
		{
			//messages.add("WAIT");
		}
	}
	
	public void addOutElevator(int position)
	{
		outElevator = position;
	}
	
	public void addInElevator(int position)
	{
		inElevator = position;
	}
	
	public void addExit(int position)
	{
		exit = position;
		isExitFloor = true;
	}
	
	public void setTarget()
	{
		if (isExitFloor)
		{
			target = exit;
		}
		else
		{
			target = outElevator;
		}
	}
	
	public int getTarget()
	{
		return target;
	}
	
	public void setBlocked()
	{
		hasBlock = true;
	}
	
	public boolean hasBlock()
	{
		return hasBlock;
	}
}
	
	
	
	
	
	
	
	

	
	
	
