package terra.entities;

import arc.graphics.g2d.*;
import arc.struct.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import terra.type.*;

public class TerraEntity extends UnitEntity{
    public Seq<Trail> tails = new Seq<>();
    public static int classid;

    public TerraEntity setup(TerraUnit type){
        this.type = type;
        for(Tail tail : type.tails){
            tails.add(new Trail(tail.length));
        };
        return this;
    }

    @Override
    public void update(){
        super.update();

        if(type instanceof TerraUnit u){
            if(vel.len() > 0.3f){
                for(int i = 0; i < tails.size; i++){
                    u.tails.get(i).update(this, tails.get(i));
                }
            }
        }
    }

    @Override
    public void draw(){
        super.draw();

        Draw.z(type.groundLayer - 1);
        if(type instanceof TerraUnit u){
            for(int i = 0; i < tails.size; i++){
                u.tails.get(i).draw(tails.get(i));
            }
        }
    }

    @Override
    public int classId(){
        return classid;
    }
}
