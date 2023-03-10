package io.github.justfoxx.teacup.v1.mixins;

import io.github.justfoxx.teacup.v1.event.Events;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "onDeath", at = @At("HEAD"))
    private void onDying(CallbackInfo ci) {
        Events.getON_ENTITY_DYING().invoker().invoke((LivingEntity) (Object) this);
    }

    @Inject(method = "onDeath", at = @At("RETURN"))
    private void onDied(CallbackInfo ci) {
        Events.getON_ENTITY_DIED().invoker().invoke((LivingEntity) (Object) this);
    }
}
