package Robot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class World {
    int width, height;  // the number of grid squares in the x and y directions
    int[][] grid;       // will store the map of the world.  0: empty square; 1: wall; 2: stairwell; 3: goal

    World(String worldFile) {
        try {
            FileReader fileReader = new FileReader("C:\\Users\\coler\\Documents\\BYU Fall 2023\\CS 470\\BayesianFiltering\\src\\Mundos\\" + worldFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            width = Integer.parseInt(bufferedReader.readLine());
            height = Integer.parseInt(bufferedReader.readLine());
            
            //System.out.println("Width: " + width + "; Height = " + height);
            
            grid = new int[width][height];
            for (int y = 0; y < height; y++) {
                String line = bufferedReader.readLine();
                for (int x = 0; x < width; x++) {
                    if (line.charAt(x) == '0')
                        grid[x][y] = 0;
                    else if (line.charAt(x) == '1')
                        grid[x][y] = 1;
                    else if (line.charAt(x) == '2')
                        grid[x][y] = 2;
                    else if (line.charAt(x) == '3')
                        grid[x][y] = 3;
                }
            }
            
            bufferedReader.close();
            fileReader.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }

}