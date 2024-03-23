package com.github.birksovskiy.birkdisbot.listeners;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class LinkCommands extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "website"  -> event.reply("https://birkx.vercel.app/").setEphemeral(true).queue();
            case "github"   -> event.reply("https://github.com/birkxef/").setEphemeral(true).queue();
            case "fediverse" -> event.reply("https://lamp.leemoon.network/@birksovskiy").setEphemeral(true).queue();
        }
    }
}
