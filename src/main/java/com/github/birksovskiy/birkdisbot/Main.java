package com.github.birksovskiy.birkdisbot;

import com.github.birksovskiy.birkdisbot.listeners.BirkMailCommand;
import com.github.birksovskiy.birkdisbot.listeners.LinkCommands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class Main {
    public static void main(String[] args) {

        try {
            JDA jda = JDABuilder.createDefault(args[0])
                    .addEventListeners(
                            new LinkCommands(),
                            new BirkMailCommand()
                    )
                    .setActivity(Activity.streaming("воздух", "https://youtube.com/watch?v=adibCKTBqHo"))
                    .build();

            jda.updateCommands()
                    .addCommands(
                            Commands.slash("website", "Ссылка на сайт Бирка"),
                            Commands.slash("github", "Ссылка на GitHub-профиль Бирка"),
                            Commands.slash("fediverse", "Ссылка на профиль Бирка в Fediverse"),
                            Commands.slash("birkmail", "Написать Бирку")
                    )
                    .queue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
