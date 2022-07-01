package draedon;

import mindustry.Vars;
import mindustry.content.*;
import mindustry.entities.abilities.Ability;
import mindustry.entities.bullet.*;
import mindustry.entities.part.*;
import mindustry.gen.EntityMapping;
import mindustry.gen.Sounds;
import mindustry.gen.Unit;
import mindustry.gen.UnitEntity;
import mindustry.graphics.*;
import mindustry.mod.*;
import mindustry.type.*;
import draedon.ai.twins.*;
import draedon.content.*;

public class DraedonMain extends Mod{
    public static UnitType twins;
    public static UnitType apollo;
    public static UnitType artemis;

    public static int artemisID;
    public static int apolloID;

    @Override
    public void loadContent() {
        artemisID = EntityMapping.register("draedon-artemis", ArtemisUnit::new);
        apolloID = EntityMapping.register("draedon-apollo", ApolloUnit::new);

        EntityMapping.nameMap.put("draedon-twins-spawner", UnitEntity::create);
        artemis = new ExoTwinsUnitType("artemis") {{
            localizedName = "Artemis";
            description = "you're not supposed to see this buddy. :)";
            flying = true;
            outlines = false;
            lowAltitude = true;
            drawCell = false;
            hidden = true;

            drag = 0.07f;
            speed = 7f;
            rotateSpeed = 4f;
            accel = 0.08f;
            health = 200000f;
            armor = 3f;
            hitSize = 50f;
            itemCapacity = 0;
            controller = u -> new ArtemisAI();
            engineColor = Pal.lighterOrange;
            constructor = ArtemisUnit::new;

            setEnginesMirror(
                    new ExoTwinsTrailUnit.DriftEngine(34f / 4f, -40f / 2f, 3f, -90f)
                            .setTrail(13, 15f, 0.50f, 0.05f, Pal.lighterOrange)
            );
            parts.add(new RegionPart("-glow"){{
                outline = false;
                layer = Layer.bullet - 0.02f;
            }});
            weapons.add(new Weapon(){{
                range = 450f;
                reload = 5f;
                x = 0f;
                y = 32f;
                top = false;
                mirror = false;
                shootSound = Sounds.artillery;
                bullet = new BasicBulletType(60f, 100){{
                    frontColor = Pal.lighterOrange;
                    backColor = Pal.lightishOrange;
                    shootEffect = Fx.ballfire;
                    despawnEffect = Fx.hitBeam;
                    width = 7.5f;
                    height = 35f;
                    lifetime = 15f;
                    pierce = true;
                    pierceBuilding = true;
                    pierceCap = 6;
                }};
            }});
        }};

        apollo = new ExoTwinsUnitType("apollo") {{
            localizedName = "Apollo";
            description = "you're not supposed to see this buddy. :)";
            flying = true;
            outlines = false;
            lowAltitude = true;
            drawCell = false;
            hidden = true;

            drag = 0.07f;
            speed = 7f;
            rotateSpeed = 4f;
            accel = 0.08f;
            health = 200000f;
            armor = 3f;
            hitSize = 50f;
            engineOffset = 10;
            itemCapacity = 0;
            controller = u -> new ApolloAI();
            engineColor = Pal.heal;
            constructor = ApolloUnit::new;

            setEnginesMirror(
                    new ExoTwinsTrailUnit.DriftEngine(34f / 4f, -40f / 2f, 3f, -90f)
                            .setTrail(13, 15f, 0.50f, 0.05f, Pal.heal)
            );
            parts.add(new RegionPart("-glow"){{
                outline = false;
                layer = Layer.bullet - 0.02f;
            }});
            weapons.add(new Weapon(){{
                parentizeEffects = true;
                range = 200f;
                reload = 4f;
                x = 0f;
                y = 32f;
                shootCone = 20f;
                rotate = false;
                mirror = false;
                top = false;
                shootSound = Sounds.flame2;
                bullet = new BulletType(20f, 90){{
                    hitSize = 40f;
                    pierce = true;
                    pierceBuilding = true;
                    pierceCap = 4;
                    shootEffect = ExoTwinsFx.shootMagniFlame;
                    hitEffect = Fx.smoke;
                    despawnEffect = Fx.none;
                    keepVelocity = false;
                    hittable = false;
                    lifetime = 10f;
                }};
            }});
        }};
        twins = new UnitType("twins-spawner"){{
            localizedName = "The Twins";
            outlines = false;
            health = 0f;
            description = "Artemis and Apollo, a pair of destroyers with deadly pulse cannons and extreme agility, many rarely live to tell the tale.";
            deathSound = Sounds.none;
            deathExplosionEffect = Fx.spawnShockwave;
            constructor = UnitEntity::create;
            abilities.add(new Ability(){
                @Override
                public void death(Unit unit){
                    ArtemisUnit apollo = (ArtemisUnit) Vars.content.unit("draedon-artemis").spawn(unit.team, unit.x + 5f, unit.y + 5f);
                    ApolloUnit artemis = (ApolloUnit)Vars.content.unit("draedon-apollo").spawn(unit.team, unit.x - 5f, unit.y - 5f);
                    apollo.apolloPair = artemis;
                    artemis.artemisPair = apollo;
                }
            });
        }};
    }
    public DraedonMain(){
    }
}
