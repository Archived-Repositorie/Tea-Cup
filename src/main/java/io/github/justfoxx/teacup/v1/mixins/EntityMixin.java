package io.github.justfoxx.teacup.v1.mixins;

import io.github.justfoxx.teacup.v1.event.Events;
import io.github.justfoxx.teacup.v1.event.SingletonData;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Entity.class)
public class EntityMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTicking(CallbackInfo ci) {
        Events.getON_ENTITY_TICKING().invoker().invoke(new SingletonData<>((Entity) (Object) this, ci));
    }

    @Inject(method = "tick", at = @At("RETURN"))
    private void onTicked(CallbackInfo ci) {
        Events.getON_ENTITY_TICKED().invoker().invoke(new SingletonData<>((Entity) (Object) this, ci));
    }
}
