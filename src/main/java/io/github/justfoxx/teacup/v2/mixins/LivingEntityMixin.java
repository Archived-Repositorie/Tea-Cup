package io.github.justfoxx.teacup.v2.mixins;

import io.github.justfoxx.teacup.v2.event.data.SingletonData;
import io.github.justfoxx.teacup.v2.event.events.LivingEntityEvents;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "onDeath", at = @At("HEAD"))
    private void onDying(CallbackInfo ci) {
        LivingEntityEvents.getON_ENTITY_DYING().invoker().invoke(new SingletonData<>((LivingEntity) (Object) this, ci));
    }

    @Inject(method = "onDeath", at = @At("RETURN"))
    private void onDied(CallbackInfo ci) {
        LivingEntityEvents.getON_ENTITY_DIED().invoker().invoke(new SingletonData<>((LivingEntity) (Object) this, ci));
    }
}
