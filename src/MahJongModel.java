import java.util.Date;

public class MahJongModel {
    public Tile tileArray[][][];
    TileDeck deck = new TileDeck();

/*    public MahJongModel(){
        this((new Date()).getTime()%100000);

    }*/
    public MahJongModel(long gameNumber) {
        tileArray = new Tile[15][8][5];
        //deck.shuffle(2);
        deck.shuffle(gameNumber);

        //Add the tiles to the 3d array
        int x = 12;
        int y = 0;
        int z = 0;
        //First layer first row
        while (x > 0) {
            tileArray[x][y][z] = deck.deal();
            tileArray[x][y][z].setXYZ(x, y, z);
            x--;
        }
        //Second row y = 1
        y++;
        x = 10;
        while (x > 2) {
            tileArray[x][y][z] = deck.deal();
            tileArray[x][y][z].setXYZ(x, y, z);
            x--;
        }
        //Third row y = 2
        y++;
        x = 11;
        while (x > 1) {
            tileArray[x][y][z] = deck.deal();
            tileArray[x][y][z].setXYZ(x, y, z);
            x--;
        }
        //Fourth Row y = 3
        y++;
        x = 14;
        while (x >= 0) {
            tileArray[x][y][z] = deck.deal();
            tileArray[x][y][z].setXYZ(x, y, z);
            x--;
        }
        //Fifth Row y = 4
        y++;
        x = 12;
        while (x >= 1) {
            tileArray[x][y][z] = deck.deal();
            tileArray[x][y][z].setXYZ(x, y, z);
            x--;
        }
        //Sixth Row y = 5
        y++;
        x = 11;
        while (x >= 2) {
            tileArray[x][y][z] = deck.deal();
            tileArray[x][y][z].setXYZ(x, y, z);
            x--;
        }
        //Seventh Row y = 6
        y++;
        x = 10;
        while (x >= 3) {
            tileArray[x][y][z] = deck.deal();
            tileArray[x][y][z].setXYZ(x, y, z);
            x--;
        }
        //Seventh Row y = 6
        y++;
        x = 12;
        while (x >= 1) {
            tileArray[x][y][z] = deck.deal();
            tileArray[x][y][z].setXYZ(x, y, z);
            x--;
        }
        //End layer 1


        //second level
        z++;
        for (y = 1; y <= 6; y++) {
            for (x = 9; x >= 4; x--) {
                tileArray[x][y][z] = deck.deal();
                tileArray[x][y][z].setXYZ(x, y, z);
            }
        }

        //third level
        z++;
        for (y = 2; y <= 5; y++) {
            for (x = 8; x >= 5; x--) {
                tileArray[x][y][z] = deck.deal();
                tileArray[x][y][z].setXYZ(x, y, z);
            }
        }

        //fourth level
        z++;
        for (y = 3; y <= 4; y++) {
            for (x = 7; x >= 6; x--) {
                tileArray[x][y][z] = deck.deal();
                tileArray[x][y][z].setXYZ(x, y, z);
            }
        }
        //fifth
        z++;
        tileArray[6][4][4] = deck.deal();
        tileArray[6][4][4].setXYZ(6, 4, 4);
    }

    public void positionTile(Tile t, int x, int y, int z) {

        if (z == 4) {
            t.setLocation(x * Tile.sideLength + Tile.depth + z * Tile.depth + Tile.sideLength / 2, y * Tile.sideLength + Tile.depth - z * Tile.depth - Tile.sideLength / 2);
        } else if (z == 0 && y == 3 && (x == 0 || x == 13 || x == 14)) {
            t.setLocation(x * Tile.sideLength + Tile.depth, y * Tile.sideLength + Tile.depth + Tile.sideLength / 2);
        } else {
            t.setLocation(x * Tile.sideLength + Tile.depth + z * Tile.depth, y * Tile.sideLength + Tile.depth - z * Tile.depth);
        }
    }

    public boolean isTileOpen(Tile t) {
        int x = t.getXPos();
        int y = t.getYPos();
        int z = t.getZPos();
        if (x == 0 && y == 3 && z == 0) return true;
        if (x == 14 && y == 3 && z == 0) return true;
        if (x == 13 && y == 3 && z == 0) {

            if (tileArray[14][3][0].hidden || (tileArray[12][3][0].hidden && tileArray[12][4][0].hidden)) {
                return true;
            } else {
                return false;
            }
        }
        if(x == 12 && y == 4 && z == 0){
            if(tileArray[13][3][0].hidden || tileArray[x-1][y][z].hidden){
                return true;
            }else{
                return false;
            }
        }


        if (z == 0 && (y == 3 || y == 4) && x == 1) {
            //left side offset
            if (tileArray[0][3][0].hidden || tileArray[x+1][y][z].hidden) {
                return true;
            } else {
                return false;
            }
        }

            if (z == 0 && (y == 3 || y == 4) && x == 12) {
                //right offset tile
            }

            if (z == 4) return true;
            if (z == 3 && tileArray[6][4][4].hidden) return true;
            if (z == 2 || z == 1 || z == 0) {
                //Level 3
                if ((tileArray[x][y][z + 1] == null || tileArray[x][y][z + 1].hidden) &&  //Tile above is not taken
                        ((tileArray[x - 1][y][z] == null || tileArray[x - 1][y][z].hidden) || //tile to the left is open
                                (tileArray[x + 1][y][z] == null || tileArray[x + 1][y][z].hidden))  //tile to the right is open)
                ) {
                    return true;
                }
            }


            return false;
        }

}
