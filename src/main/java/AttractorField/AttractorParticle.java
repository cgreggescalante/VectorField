package AttractorField;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.List;

public class AttractorParticle {
    PVector position;
    PVector velocity;

    PApplet applet;

    public AttractorParticle(PApplet applet) {
        this.applet = applet;

        position = new PVector(applet.random(applet.width), applet.random(applet.height));

        velocity = PVector.random2D().setMag(applet.random(5, 10));
    }

    public void update(List<Attractor> attractors) {
        PVector force = new PVector();

        for (Attractor attractor: attractors) {
            force.add(
                    PVector.sub(attractor.position, position)
                            .div(PVector.dist(attractor.position, position))
                            .mult(attractor.strength)
            );
        }

        velocity.add(force);
        velocity.mult(.999f);
        position.add(velocity);
    }

    public void show() {
        applet.noStroke();
        applet.fill(100);
        applet.circle(position.x, position.y, 3);
    }
}
