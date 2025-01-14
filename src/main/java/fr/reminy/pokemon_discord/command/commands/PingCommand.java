package fr.reminy.pokemon_discord.command.commands;

import fr.reminy.pokemon_discord.command.Category;
import fr.reminy.pokemon_discord.command.Command;
import fr.reminy.pokemon_discord.annotation.command.Register;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageEvent;

import java.awt.*;
import java.util.List;

@Register
public class PingCommand implements Command {

    @Override
    public String[] getLabels() {
        return new String[]{ "ping", "p" };
    }

    @Override
    public String getDescription() {
        return "-";
    }

    @Override
    public Category getCategory() {
        return Category.COMMON;
    }

    @Override
    public void execute(MessageEvent event, MessageAuthor author, TextChannel channel, List<String> args) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setColor(Color.WHITE);
        embedBuilder.setDescription("Pong!");
        channel.sendMessage(embedBuilder);
    }
}
