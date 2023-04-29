package io.github.justfoxx.teacup.v2.mixins;

import io.github.justfoxx.teacup.v2.event.data.MutableSingletonData;
import io.github.justfoxx.teacup.v2.event.data.Setter;
import io.github.justfoxx.teacup.v2.event.events.TextEvents;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextContent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.List;

@Mixin(MutableText.class)
public abstract class MutableTextMixin {
    @ModifyVariable(method = "<init>", at = @At("HEAD"), argsOnly = true)
    private static Style modifyStyle(Style style) {
        var setter = new MutableSingletonData<>(new Setter<>(style));
        TextEvents.getON_TEXT_STYLE_MODIFY().invoker().invoke(setter);
        return setter.getData().get();
    }

    @ModifyVariable(method = "<init>", at = @At("HEAD"), argsOnly = true)
    private static TextContent modifyTextContent(TextContent textContent) {
        var setter = new MutableSingletonData<>(new Setter<>(textContent));
        TextEvents.getON_TEXT_CONTENT_MODIFY().invoker().invoke(setter);
        return setter.getData().get();
    }

    @ModifyVariable(method = "<init>", at = @At("HEAD"), argsOnly = true)
    private static List<? extends Text> modifyTextSiblings(List<? extends Text> siblings) {
        MutableSingletonData<List<? extends Text>> setter = new MutableSingletonData<>(new Setter<>(siblings));
        TextEvents.getON_TEXT_SIBLINGS_MODIFY().invoker().invoke(setter);
        return setter.getData().get();
    }
}
