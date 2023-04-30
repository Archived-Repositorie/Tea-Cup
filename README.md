# Welcome to Tea-Cup

## What is tea cup?
This is library created to give mods utilities that they can use and also adds events system for serverside mods, so they can create mixin-free and mojank-free mods, potentially making it easier to port their mods on different versions without needing to touch weird mojank stuff. It will be updated on snapshots/latest possible versions.

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

fun preInit() {
    MinecraftServerEvents.ON_SERVER_STARTED.register(::onServerStarted)
}

@Subscriber
fun onServerStarted(event: SingletonData<MinecraftServer>) {
    mod.logger.info("Server started")
}
```
### Java example
```java
public class PreMain implements PreLaunchEntrypoint {
    Mod mod = new Mod("teacup"); //helper class for mods
    
    public void onPreLaunch() {
        MinecraftServerEvents.getON_SERVER_STARTED().registerHelper(
                Test.class, "onServerStarted"
        );
    }
    @Subscriber
    public static Unit onServerStarted(SingletonData<MinecraftServer> data) {
         mod.getLogger.info("Server started!");
        return Unit.INSTANCE;
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
