*
*[Wiki](https://github.com/XZot1K/DisplayShopsAPI/wiki) | [Commands](https://github.com/XZot1K/DisplayShopsAPI/wiki/commands) | [Permissions](https://github.com/XZot1K/DisplayShopsAPI/wiki/permissions)
| [How Does It Work?](https://github.com/XZot1K/DisplayShopsAPI/wiki/shop-guide) | [Developer API](https://github.com/XZot1K/DisplayShopsAPI/wiki/developer-api)
| [Java Docs](https://xzot1k.github.io/DisplayShopsAPI/)**

To use the DisplayShops API, navigate to the releases tab and download the JAR file. Once completed, add the jar to your plugin/project's dependency list and access the plugin's
main instance using
DisplayShops.getPluginInstance()!

<img src="https://imgur.com/mkPfGtg.png" width="150px" height="150px">

# DisplayShops

Create immersive simplistic shops with animations, efficient transaction handling, and much more!
***

### Don't have a DisplayShops license? No Worries, you can obtain a license from anyone of the three platforms below:

[Spigot](https://www.spigotmc.org/resources/•-display-shops-•-a-new-approach-to-player-shops-•.69766/) | [Mc-Market](https://www.mc-market.org/resources/11595/)
| [Songoda](https://songoda.com/marketplace/product/displayshops-displayshops.269)

For support or general information, including the Developer API please visit the [Wiki](https://github.com/XZot1K/DisplayShopsAPI/wiki)!

### DisplayShops Addons

https://github.com/bzigus/DisplayShopAddon - `Handles a form of chest-linking allowing users to sync containters to their shops!`

### Maven Dependency

```xml

<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
<dependency>
    <groupId>com.github.XZot1K</groupId>
    <artifactId>DisplayShopsAPI</artifactId>
    <version>2.0</version>
</dependency>
</dependencies>
```

### Gradle Dependency

```gradle
allprojects {
   repositories {
      maven { url 'https://jitpack.io' }
   }
}

dependencies {
   implementation 'com.github.XZot1K:DisplayShopsAPI:2.0'
}
```