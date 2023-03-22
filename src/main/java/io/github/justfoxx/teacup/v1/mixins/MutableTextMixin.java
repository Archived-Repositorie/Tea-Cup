package io.github.justfoxx.teacup.v1.mixins;

import io.github.justfoxx.teacup.v1.event.Events;
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
        return Events.getON_TEXT_STYLE_MODIFY().invoker().invoke(style);
    }

    @ModifyVariable(method = "<init>", at = @At("HEAD"), argsOnly = true)
    private static TextContent modifyTextContent(TextContent textContent) {
        return Events.getON_TEXT_CONTENT_MODIFY().invoker().invoke(textContent);
    }

    @ModifyVariable(method = "<init>", at = @At("HEAD"), argsOnly = true)
    private static List<Text> modifyTextSiblings(List<Text> siblings) {
        return Events.getON_TEXT_SIBLINGS_MODIFY().invoker().invoke(siblings);
    }
}
