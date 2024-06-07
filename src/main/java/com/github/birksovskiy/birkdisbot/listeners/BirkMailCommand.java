package com.github.birksovskiy.birkdisbot.listeners;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class BirkMailCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("birkmail")) {
            TextInput subject = TextInput.create("subject", "Заголовок", TextInputStyle.SHORT)
                    .setRequired(true)
                    .setPlaceholder("Введите заголовок...")
                    .setRequiredRange(1, 40)
                    .build();

            TextInput body = TextInput.create("body", "Описание", TextInputStyle.PARAGRAPH)
                    .setRequired(true)
                    .setPlaceholder("Опишите проблему...")
                    .setRequiredRange(10, 200)
                    .build();

            Modal modal = Modal.create("birkmail", "BirkMail")
                    .addComponents(ActionRow.of(subject), ActionRow.of(body))
                    .build();

            event.replyModal(modal).queue();
        }
    }

    @Override
    public void onModalInteraction(@NotNull ModalInteractionEvent event) {
        if (event.getModalId().equals("birkmail")) {
            String subject = Objects.requireNonNull(event.getValue("subject")).getAsString();
            String body = Objects.requireNonNull(event.getValue("body")).getAsString();

            User birkUser = event.getJDA().retrieveUserById("723556139647893615").complete();
            birkUser.openPrivateChannel().flatMap(channel -> channel.sendMessage(String.format("%s | %s | %s%n", event.getUser().getGlobalName(), subject, body))).queue();

            event.reply(":white_check_mark: Ваше сообщение отправлено Бирку").queue();
        }
    }
}
