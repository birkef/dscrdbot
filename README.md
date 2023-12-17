# birkdisbot

Easy bot for Discord with birksovskiy's links.

## Usage

1. Build a jar-file
```sh
./gradlew shadowJar
```

2. Go to `build/libs` folder
```sh
cd build/libs
```

3. Run the bot with your token by executing the following command
```sh
java -jar birkdisbot-[VERSION]-all.jar [TOKEN]
```

## Stack

- Discord API library: [JDA](https://github.com/discord-jda/JDA)

## Tools

- Build tool: [Gradle](https://github.com/gradle/gradle)
- Build plugin: [Shadow](https://github.com/johnrengelman/shadow)
