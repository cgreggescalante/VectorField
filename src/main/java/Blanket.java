import VectorField.Particle;
import VectorField.VectorFieldRenderer;
import processing.core.PApplet;
import processing.core.PVector;

public class Blanket extends VectorFieldRenderer {
    public void settings() {
        fullScreen();
    }

    public void setup_imp() {
        Particle.setMomentum(.9f);

        for (int i = 0; i < width; i += 5) {
            for (int j = 0; j < height; j += 5) {
                addParticle(i, j);
            }
        }
        background(0);
    }

    public void addParticle() {
//        for (int i = 0; i < 5; i++) {
//            particles.add(new VectorField.Particle(random.nextInt(width), random.nextInt(height), new PVector(), this));
//        }
    }

    public void addParticle(int x, int y) {
        getParticles().add(new Particle(x, y, new PVector(), this));
    }

    public void draw_settings() {
        addParticle();
        strokeWeight(1);
        stroke(255,3);
    }

    public static void main(String[] args) {
        String[] pArgs = new String[]{"Blanket"};
        PApplet.runSketch(pArgs, new Blanket());
    }
}
