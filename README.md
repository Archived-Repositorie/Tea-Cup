# Welcome to Tea-Cup

## Usage in mods
1. Adding modrinth repository to build.gradle
```groovy
repositories {
    // ...
    maven {
        url = "https://api.modrinth.com/maven"
    }
}
```
2. Adding dependience (replace `{version}` with latest version found on modrinth <https://modrinth.com/mod/teacup/versions>)
```groovy
dependencies {
    // Adding and remapping a mod only in local runtime
    modImplementation "maven.modrinth:teacup:{version}"
}
```
## Event usage (kotlin and java)
Remember, register events on PreLaunch!

### Kotlin example
```kt
val mod = Mod("ivycore") //helper class for mods

fun preMain() {
  Events.ON_ITEM_USING.onEvent { data ->
    mod.logger.info("Item used: ${data.itemStack.item}")
    data.itemUseResult.returnValue = ActionResult.PASS
  }
}
```
### Java example
```java
public class PreMain implements PreLaunchEntrypoint {
    Mod mod = new Mod("teacup"); //helper class for mods
    
    @Override
    public void onPreLaunch() {
        Events.INSTANCE.getON_ITEM_USING().onEvent(data -> {
            mod.getLogger().info("Item used: "+data.getItemStack().getItem());
            data.getItemUseResult().setReturnValue(ActionResult.PASS);
            return null;
        });
    }
}
```
## Config usage (kotlin and java)

### Kotlin example
```kt
val mod = Mod("teacup")

@Suppress("unused")
fun init() {
    val config = ConfigLoader.loadConfig(mod.configPath, ConfigObject::class.java)
    config.first.ifPresent {
        mod.logger.info(it.test)
    }
}

data class ConfigObject(
    val test: String
)
```
### Java example
```java
public class PreMain implements PreLaunchEntrypoint {
    Mod mod = new Mod("teacup");

    @Override
    public void onPreLaunch() {
        final var config = ConfigLoader.INSTANCE.loadConfig(mod.getConfigPath(), ConfigObject.class);
        config.getFirst().ifPresent(data -> {
            mod.getLogger().info(data.test);
        });
    }
    record ConfigObject(String test) {}
}
```
