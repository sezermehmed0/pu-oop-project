package Game;


import Tile.Tile;

import javax.swing.*;
import java.awt.*;


public class Battlefield extends JPanel {
        static final int SCREEN_WIDTH = 1250;
        static final int SCREEN_HEIGHT = 825;

        Battlefield(){

            this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
            this.setFocusable(true);

        }

        @Override
        public void paint(Graphics g) {

            for(int row = 0; row < 7; row++) {
                for(int col = 0; col < 9; col++) {

                    this.renderTile(g, row, col);

                }
            }

        }

        private Color getTileColor(int row, int col) {

            boolean isRowEven = (row % 2 == 0);
            boolean isColEven = (col % 2 == 0);


            if (!(row == 2) && !(row == 3) && !(row == 4)) {
                if (isRowEven && isColEven) return Color.GRAY;
                if (isRowEven) return Color.DARK_GRAY;
                if (isColEven) return Color.DARK_GRAY;
                return Color.GRAY;
            }
            return Color.LIGHT_GRAY;
        }


        private void renderTile(Graphics g, int row, int col) {

            Color tileColor = this.getTileColor(row, col);
            Tile tile = new Tile(row, col, tileColor);
            tile.render(g);
        }


}

