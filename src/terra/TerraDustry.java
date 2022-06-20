package terra;

import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.part.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.mod.*;
import mindustry.type.*;
import terra.ai.twins.MagniAI;
import terra.ai.twins.ModiAI;
import terra.type.*;

public class TerraDustry extends Mod{

    public UnitType magni;
    public UnitType modi;

    @Override
    public void loadContent() {
        modi = new TerraUnit("modi") {{
            flying = true;
            outlines = false;
            lowAltitude = true;
            drawCell = false;

            drag = 0.08f;
            speed = 15f;
            rotateSpeed = 4f;
            accel = 0.09f;
            health = 63000f;
            armor = 3f;
            hitSize = 50f;
            engineSize = 12;
            engineOffset = 10;
            itemCapacity = 0;
            controller = u -> new ModiAI();
            parts.add(new RegionPart("-glow"){{
                outline = false;
                layer = Layer.bullet - 0.02f;
            }});
            tails.add(new Tail(15, 15, 20, 2, true, Pal.heal));
            weapons.add(new Weapon(){{
                range = 300f;
                reload = 5f;
                x = 4f;
                y = 40f;
                top = false;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(40f, 17){{
                    width = 7f;
                    height = 50f;
                    lifetime = 20f;
                }};
            }});
        }};

        magni = new TerraUnit("magni") {{
            flying = true;
            outlines = false;
            lowAltitude = true;
            drawCell = false;

            drag = 0.08f;
            speed = 15f;
            rotateSpeed = 4f;
            accel = 0.09f;
            health = 63000f;
            armor = 3f;
            hitSize = 50f;
            engineSize = 12;
            engineOffset = 10;
            itemCapacity = 0;
            controller = u -> new MagniAI();
            parts.add(new RegionPart("-glow"){{
                outline = false;
                layer = Layer.bullet - 0.02f;
            }});
            tails.add(new Tail(15, 15, 20, 2, true, Pal.heal));
            weapons.add(new Weapon(){{
                range = 300f;
                reload = 5f;
                x = 4f;
                y = 40f;
                top = false;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(40f, 17){{
                    width = 7f;
                    height = 50f;
                    lifetime = 20f;
                }};
            }});
        }};
    }

    public TerraDustry(){
    }
}
