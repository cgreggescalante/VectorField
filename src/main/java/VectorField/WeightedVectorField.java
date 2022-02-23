package VectorField;

import processing.core.PApplet;

public class WeightedVectorField extends VectorField {
    public WeightedVectorField(int width, int height, float scale) {
        super(width, height, scale);

        float weightScale = 200;

        PApplet noise = new PApplet();
        float xOff = noise.random(100000);
        float yOff = noise.random(100000);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                field[j][i].mult(noise.noise((i + xOff) / weightScale, (j + yOff) / weightScale) * 3);
            }
        }
    }
}
