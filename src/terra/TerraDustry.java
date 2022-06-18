package terra;

import arc.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
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

            drag = 0.08f;
            speed = 10f;
            rotateSpeed = 4f;
            accel = 0.09f;
            health = 1100f;
            armor = 3f;
            hitSize = 12f;
            engineSize = 0;
            itemCapacity = 0;
            //if you want it to *not* be RTS-controllable, write:
            //controller = u -> new TestFlyingAI();
            //otherwise it will still be controllable and have "normal" RTS AI on player teams
            controller = u -> new ModiAI();
            constructor = UnitEntity::create;

            weapons.add(new Weapon("large-weapon"){{
                reload = 13f;
                x = 4f;
                y = 2f;
                top = false;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(2.5f, 9){{
                    width = 7f;
                    height = 9f;
                    lifetime = 60f;
                }};
            }});
        }};

        magni = new UnitType("magni") {{
            flying = true;
            outlines = false;

            drag = 0.08f;
            speed = 10f;
            rotateSpeed = 4f;
            accel = 0.09f;
            health = 1100f;
            armor = 3f;
            hitSize = 12f;
            engineSize = 0;
            itemCapacity = 0;
            //if you want it to *not* be RTS-controllable, write:
            //controller = u -> new TestFlyingAI();
            //otherwise it will still be controllable and have "normal" RTS AI on player teams
            controller = u -> new MagniAI();
            constructor = UnitEntity::create;

            weapons.add(new Weapon("large-weapon"){{
                reload = 13f;
                x = 4f;
                y = 2f;
                top = false;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(2.5f, 9){{
                    width = 7f;
                    height = 9f;
                    lifetime = 60f;
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
