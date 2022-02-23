package VectorField;

import processing.core.PApplet;
import processing.core.PVector;

import static processing.core.PConstants.TWO_PI;

public class VectorField {
    PVector[][] field;

    public VectorField(int width, int height, float scale) {
        field = new PVector[height][width];

        PApplet rand = new PApplet();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                field[i][j] = new PVector(0, .1f).rotate(rand.noise(i / scale, j / scale) * TWO_PI * 2);
            }
        }
    }

    public PVector get(float x, float y) {
        return field[(int) y][(int) x];
    }

    public PVector[][] getField() {
        return field;
    }
}
