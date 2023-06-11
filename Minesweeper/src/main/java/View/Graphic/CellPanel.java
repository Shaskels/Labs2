package View.Graphic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import View.Graphic.Figure.*;

public class CellPanel extends JPanel {
    private final int x;
    private final int y;
    private int mines;
    private ArrayList<FigureNumber> shapes = new ArrayList<>();

    public CellPanel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setMines(int mines) {
        this.mines = mines;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Object s : shapes) {
            if (s instanceof FigureOne) {
                ((FigureOne) s).draw(g);
            } else if (s instanceof FigureTwo) {
                ((FigureTwo) s).draw(g);
            }
            else if (s instanceof FigureThree) {
                ((FigureThree) s).draw(g);
            }
            else if (s instanceof FigureFour) {
                ((FigureFour) s).draw(g);
            }
            else if (s instanceof FigureFive) {
                ((FigureFive) s).draw(g);
            }
            else if (s instanceof FigureSix) {
                ((FigureSix) s).draw(g);
            }
            else if (s instanceof  FigureSeven) {
                ((FigureSeven) s).draw(g);
            }
            else if (s instanceof FigureEight) {
                ((FigureEight) s).draw(g);
            }
        }

    }



}
