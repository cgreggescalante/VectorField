package VectorField;

import processing.core.PApplet;
import processing.core.PVector;

public class Particle {
    PVector position;
    PVector velocity;

    PApplet sketch;

    static float momentum = .9f;

    boolean active;

    public Particle(int x, int y, PVector velocity, PApplet sketch) {
        active = true;

        position = new PVector(x, y);
        this.velocity = velocity;

        this.sketch = sketch;
    }

    public Particle(PVector position, PVector velocity, PApplet sketch) {
        active = true;

        this.position = position;
        this.velocity = velocity;

        this.sketch = sketch;
    }

    public static void setMomentum(float new_momentum) {
        momentum = new_momentum;
    }

    public void update(VectorField field) {
        if (active) {
            try {
                velocity.mult(momentum);
                velocity.add(field.get(position.x, position.y));
            } catch (ArrayIndexOutOfBoundsException e) {
                active = false;
            }
            PVector prevPosition = position.copy();
            position.add(velocity);
            sketch.line(prevPosition.x, prevPosition.y, position.x, position.y);
        }
    }

    public PVector getPosition() {
        return position;
    }
}
