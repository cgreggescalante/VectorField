import VectorField.Particle;
import VectorField.VectorFieldRenderer;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.Random;

public class Tree extends VectorFieldRenderer {
    Random random = new Random();

    int radius = 250;

    public void settings() {
        fullScreen();
    }

    public void setup_imp() {
        frameRate(10);
        for (int i = 0; i < 40000; i++) {
            float dist = random.nextFloat() * radius;
            float heading = random.nextFloat() * TWO_PI;
            PVector pos = new PVector(dist, 0).rotate(heading).add(width / 2f, height / 2f);
            addParticle(pos);
        }

        background(40);
    }

    public void addParticle() {

    }

    public void addParticle(PVector pos) {
        getParticles().add(new Particle(pos, new PVector(), this));
    }

    public void draw_settings() {
        addParticle();
        strokeWeight(1);
        stroke(130, 100, 100, 10);
    }

    public static void main(String[] args) {
        String[] pArgs = new String[]{"Tree"};
        PApplet.runSketch(pArgs, new Tree());
    }
}
