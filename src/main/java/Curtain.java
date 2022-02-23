import VectorField.Particle;
import VectorField.VectorFieldRenderer;
import processing.core.PApplet;
import processing.core.PVector;

public class Curtain extends VectorFieldRenderer {
    public void settings() {
        fullScreen();
    }

    public void setup_imp() {
        Particle.setMomentum(.99f);
        for (int i = 0; i < width; i++) {
            getParticles().add(new Particle(i, 0, new PVector(0, 10), this));
        }

        background(40);
    }

    public void addParticle() {

    }

    public void draw_settings() {
        stroke(130, 100, 100, 60);
    }

    public static void main(String[] args) {
        String[] pArgs = new String[]{"Curtain"};
        PApplet.runSketch(pArgs, new Curtain());
    }
}
