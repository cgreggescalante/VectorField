import AttractorField.AttractorField;
import AttractorField.AttractorParticle;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Planetary extends PApplet {
    AttractorField field;
    List<AttractorParticle> particles;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        field = new AttractorField(this, 3);

        particles = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            particles.add(new AttractorParticle(this));
        }

        background(51);
    }

    public void draw() {
        for (AttractorParticle particle : particles) {
            particle.update(field.getAttractors());
        }

        for (AttractorParticle particle : particles) {
            particle.show();
        }
    }

    public static void main(String[] args) {
        String[] pArgs = new String[]{"Planetary"};
        PApplet.runSketch(pArgs, new Planetary());
    }
}
