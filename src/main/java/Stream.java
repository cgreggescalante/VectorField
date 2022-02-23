import VectorField.Particle;
import VectorField.VectorFieldRenderer;
import processing.core.PApplet;
import processing.core.PVector;

public class Stream extends VectorFieldRenderer {
    public void settings() {
        fullScreen();
    }

    @Override
    public void setup_imp() {
        frameRate(100);
        background(60, 45, 45);

        for (PVector[] row : getField().getField()) {
            for (PVector vector: row) {
                float h = degrees(vector.heading());

                vector.mult(abs(h) / 15);
            }
        }
    }

    @Override
    public void draw_settings() {
        stroke(30, 40);
        for (int i = 0; i < 2; i++) {
            Particle p = new Particle((int) random(width), (int) random(height), new PVector(), this);

            while (p.getPosition().x < width && p.getPosition().x > 0 && p.getPosition().y < height && p.getPosition().y > 0) {
                p.update(getField());
            }
        }
    }

    @Override
    public void addParticle() {

    }

    public static void main(String[] args) {
        String[] pArgs = new String[]{"Stream"};
        PApplet.runSketch(pArgs, new Stream());
    }
}
