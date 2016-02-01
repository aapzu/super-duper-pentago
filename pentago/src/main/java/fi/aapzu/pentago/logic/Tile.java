
package fi.aapzu.pentago.logic;

import fi.aapzu.pentago.logic.marble.Marble;
import java.util.Arrays;

public class Tile {
    // TODO: Change the public methods to protected ones
    
    private int sideLength;
    private Marble[][] tile;
    
    protected Tile() {
        this(3);
    }
    
    protected Tile(int sideLength) {
        if(sideLength <= 0) 
            throw new RuntimeException("the sideLength of a Tile must be truly positive!");
        
        this.sideLength = sideLength;
        tile = new Marble[sideLength][sideLength];
    }
    
    private boolean validateCoordinates(int x, int y) {
        return  x >= 0 && x < tile[0].length && y >= 0 && y < tile.length;
    }
    
    protected Marble get(int x, int y) {
        if(validateCoordinates(x, y))
            return getTile()[y][x];
        else
            return null;
    }
    
    protected boolean setMarble(Marble marble, int x, int y) {
        if(validateCoordinates(x, y)) {
            tile[y][x] = marble;
            return true;
        } else 
            return false;
    }
    
    protected Marble removeMarble(int x, int y) {
        if(validateCoordinates(x, y)) {
            Marble marble = tile[y][x];
            setMarble(null, x, y);
            return marble;
        } else
            return null;
        
    }
    
    protected void rotateClockWise() {
        rotate(true);
    }
    
    protected void rotateCounterClockWise() {
        rotate(false);
    }
    
    private void rotate(boolean clockWise) {
        Marble[][] rotatedTile = new Marble[tile.length][tile[0].length];
        for(int y = 0; y < tile.length; y++) {
            for(int x = 0; x < tile[0].length; x++) {
                int newY, newX;
                if(clockWise) {
                    newY = x;
                    newX = sideLength - y - 1;
                } else {
                    newY = sideLength - x - 1;
                    newX = y;
                }
                rotatedTile[newY][newX] = tile[y][x];
            }
        }
        tile = rotatedTile;
    }
    
    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < tile.length; i++) {
            result += rowToString(i);
            if(i != tile.length - 1)
                result += "\n";
        }
        return result;
    }
    
    protected String rowToString(int rowNumber) {
        return Arrays.toString(tile[rowNumber]);
    }
    
    protected int getSideLength() {
        return sideLength;
    }
    
    protected Marble[][] getTile() {
        return tile;
    }
}