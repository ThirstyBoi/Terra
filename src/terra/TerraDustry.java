package terra;

import arc.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.part.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.mod.*;
import mindustry.type.*;
import mindustry.ui.dialogs.*;
import terra.ai.twins.MagniAI;
import terra.ai.twins.ModiAI;
public class TerraDustry extends Mod{

    public UnitType magni;
    public UnitType modi;

    @Override
    public void loadContent() {
        modi = new UnitType("modi") {{
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
            constructor = UnitEntity::create;
            parts.add(new RegionPart("-glow"){{
                outline = false;
                layer = Layer.bullet - 0.02f;
            }});
            weapons.add(new Weapon("empty"){{
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

        magni = new UnitType("magni") {{
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
            constructor = UnitEntity::create;
            parts.add(new RegionPart("-glow"){{
                outline = false;
                layer = Layer.bullet - 0.02f;
            }});
            weapons.add(new Weapon("empty"){{
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
        Log.info("Loaded TerraDustry constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("frog");
                dialog.cont.add("behold").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("terradustry-frog")).pad(20f).row();
                dialog.cont.button("I see", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }
}
