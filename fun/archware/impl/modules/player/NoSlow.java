package fun.archware.impl.modules.player;

import fun.archware.ArchWare;
import fun.archware.base.event.EventTarget;
import fun.archware.base.module.Category;
import fun.archware.base.module.Module;
import fun.archware.base.setting.BooleanValue;
import fun.archware.impl.events.EventPreUpdate;
import fun.archware.impl.events.EventSlowdown;
import fun.archware.impl.utils.MoveUtils;
import net.minecraft.entity.MoverType;

/**
 * Created by 1 on 01.04.2021.
 */
public class NoSlow extends Module {

    private BooleanValue web = new BooleanValue("Web", "NoSlowWeb", this ,true);

    public NoSlow() {
        super("NoSlow", Category.PLAYER);
    }

    @EventTarget
    public void onUpdate(final EventPreUpdate event){
        if(mc.player.isHandActive()){
            if(mc.player.ticksExisted % 3 == 0 && mc.player.onGround){
                mc.player.moveEntity(MoverType.PLAYER, 0f, 0.05f, 0);
                //event.setOnGround(true);
            }if(!mc.player.onGround){
                mc.player.speedInAir = 0.1f;
            }else{
                mc.player.speedInAir = 0.02f;
            }
        }
    }

    @EventTarget
    public void onSlowDown(final EventSlowdown eventSlowdown){
        //eventSlowdown.cancel();

    }
}
