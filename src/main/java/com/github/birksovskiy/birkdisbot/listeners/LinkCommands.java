package com.github.birksovskiy.birkdisbot.listeners;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class LinkCommands extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "website"  -> event.reply("https://birksovskiy.vercel.app/").setEphemeral(true).queue();
            case "github"   -> event.reply("https://github.com/birksovskiy/").setEphemeral(true).queue();
            case "mastodon" -> event.reply("https://lor.sh/@birksovskiy").setEphemeral(true).queue();
        }
    }
}
