package io.github.justfoxx.teacup.v1.mixins;

import io.github.justfoxx.teacup.MainKt;
import io.github.justfoxx.teacup.v1.event.Events;
import io.github.justfoxx.teacup.v1.event.SingletonData;
import io.github.justfoxx.teacup.v1.utils.EntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Entity.class)
public class EntityMixin implements EntityDataSaver {
    private NbtCompound persistentData;
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTicking(CallbackInfo ci) {
        Events.getON_ENTITY_TICKING().invoker().invoke(new SingletonData<>((Entity) (Object) this, ci));
    }

    @Inject(method = "tick", at = @At("RETURN"))
    private void onTicked(CallbackInfo ci) {
        Events.getON_ENTITY_TICKED().invoker().invoke(new SingletonData<>((Entity) (Object) this, ci));
    }

    @NotNull
    @Override
    public NbtCompound getPersistentData() {
        if(this.persistentData == null) {
            this.persistentData = new NbtCompound();
        }
        return persistentData;
    }

    @Inject(method = "writeNbt", at = @At("HEAD"))
    protected void injectWriteMethod(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> cir) {
        if(persistentData != null) {
            nbt.put(MainKt.getMod().getName(), persistentData);
        }
    }

    @Inject(method = "readNbt", at = @At("HEAD"))
    protected void injectReadMethod(NbtCompound nbt, CallbackInfo ci) {
        if (nbt.contains(MainKt.getMod().getName(), 10)) {
            persistentData = nbt.getCompound("teacup");
        }
    }
}
