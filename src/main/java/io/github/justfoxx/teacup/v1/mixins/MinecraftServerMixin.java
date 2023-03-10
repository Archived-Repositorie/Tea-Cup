package io.github.justfoxx.teacup.v1.mixins;

import io.github.justfoxx.teacup.v1.event.Events;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @Inject(method = "runServer", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/MinecraftServer;setupServer()Z"))
    private void beforeServerStarting(CallbackInfo ci) {
        Events.getON_SERVER_STARTING().invoker().invoke((MinecraftServer) (Object) this);
    }

    @Inject(method = "runServer", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/MinecraftServer;createMetadata()Lnet/minecraft/server/ServerMetadata;", ordinal = 0))
    private void afterServerStarted(CallbackInfo ci) {
        Events.getON_SERVER_STARTED().invoker().invoke((MinecraftServer) (Object) this);
    }

    @Inject(method = "shutdown", at = @At("HEAD"))
    private void beforeServerStopping(CallbackInfo ci) {
        Events.getON_SERVER_STOPPING().invoker().invoke((MinecraftServer) (Object) this);
    }

    @Inject(method = "shutdown", at = @At("RETURN"))
    private void afterServerStopped(CallbackInfo ci) {
        Events.getON_SERVER_STOPPED().invoker().invoke((MinecraftServer) (Object) this);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTicking(CallbackInfo ci) {
        Events.getON_SERVER_TICKING().invoker().invoke((MinecraftServer) (Object) this);
    }

    @Inject(method = "tick", at = @At("RETURN"))
    private void onTicked(CallbackInfo ci) {
        Events.getON_SERVER_TICKED().invoker().invoke((MinecraftServer) (Object) this);
    }
}
