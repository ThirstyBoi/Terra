package terra.type;

import arc.graphics.*;
import arc.math.*;
import mindustry.graphics.*;
import terra.entities.*;

public class Tail implements Cloneable{
    public Color color;

    public int length;
    public float width;
    public float x, y;

    public boolean mirror;

    public Tail(float x, float y, int length, float width, boolean mirror, Color color){
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
        this.color = color;
        this.mirror = mirror;
    }

    public void update(TerraEntity u, Trail trail){
        float txx = Angles.trnsx(u.rotation(), x);
        float txy = Angles.trnsy(u.rotation(), x);
        float tyx = Angles.trnsx(u.rotation(), y);
        float tyy = Angles.trnsy(u.rotation(), y);

        trail.update(u.x + txx + tyx, u.y + txy + tyy, width);
    }

    public void draw(Trail trail){
        trail.draw(color, width);
    }

    @Override
    public Tail clone(){
        try{
            return (Tail)super.clone();
        }catch(CloneNotSupportedException suck){
            throw new RuntimeException("very good language design", suck);
        }
    }
}
