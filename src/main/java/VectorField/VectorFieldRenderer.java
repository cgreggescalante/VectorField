package VectorField;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public abstract class VectorFieldRenderer extends PApplet {
    VectorField field;
    List<Particle> particles;

    static int ITERATIONS_PER_FRAME = 10;
    static int FIELD_RESOLUTION = 1;
    static int NOISE_RESOLUTION = 200;

    public void setup() {
        field = new VectorField(width, height, NOISE_RESOLUTION);

        particles = new ArrayList<>();

        setup_imp();
    }

    public abstract void setup_imp();

    public void draw() {
        draw_settings();

        for (int i = 0; i < ITERATIONS_PER_FRAME; i++) {
            int j = 0;
            while (j < particles.size()) {
                particles.get(j).update(field);
                if (!particles.get(j).active) {
                    particles.remove(j);
                    addParticle();
                } else {
                    j++;
                }
            }
        }
    }

    public abstract void draw_settings();

    public abstract void addParticle();

    public void keyPressed() {
        if (key == ' ') {
            setup();
        }
    }

    public List<Particle> getParticles() {
        return particles;
    }

    public VectorField getField() {
        return field;
    }
}
