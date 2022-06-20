package terra.type;

import arc.struct.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import terra.entities.*;

public class TerraUnit extends UnitType{
    public Seq<Tail> tails = new Seq<>();
    public TerraUnit(String name){
        super(name);
    };

    @Override
    public void init(){
        TerraEntity.classid = EntityMapping.register("terradustry-" + name, TerraEntity::create);
        constructor = TerraEntity::new;

        super.init();

        if(!tails.isEmpty()){
            float length = tails.size;
            for(int i = 0; i < length; i++){
                Tail tail = tails.get(i);
                if(!tail.mirror) continue;

                tail = tail.clone();
                tail.x *= -1;
                tail.mirror = false;
                tails.add(tail);
            }
        }
    }

    @Override
    public Unit create(Team team){
        return ((TerraEntity) super.create(team)).setup(this);
    }
}
