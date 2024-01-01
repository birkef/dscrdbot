package com.github.birksovskiy.birkdisbot;

import com.github.birksovskiy.birkdisbot.listeners.LinkCommands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class Main {
    public static void main(String[] args) {
        try {
            JDA jda = JDABuilder.createDefault(args[0])
                    .addEventListeners(new LinkCommands())
                    .setActivity(Activity.streaming("новый альбом Ксенона", "https://youtube.com/watch?v=adibCKTBqHo"))
                    .build();

            jda.updateCommands()
                    .addCommands(
                            Commands.slash("website", "Sends a link to birksovskiy's website"),
                            Commands.slash("github", "Sends a link to birksovskiy's GitHub"),
                            Commands.slash("mastodon", "Sends a link to birksovskiy's Mastodon")
                    )
                    .queue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
