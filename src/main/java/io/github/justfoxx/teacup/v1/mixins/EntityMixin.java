package io.github.justfoxx.teacup.v1.mixins;

import io.github.justfoxx.teacup.v1.event.Events;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;


@Mixin(Entity.class)
public class EntityMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTicking(CallbackInfo ci) {
        Events.getON_ENTITY_TICKING().invoke((Entity) (Object) this);
    }

    @Inject(method = "tick", at = @At("RETURN"))
    private void onTicked(CallbackInfo ci) {
        Events.getON_ENTITY_TICKED().invoke((Entity) (Object) this);
    }
}
