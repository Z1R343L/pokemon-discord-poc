package fr.reminy.pokemon_discord.command.commands;

import fr.reminy.pokemon_discord.Settings;
import fr.reminy.pokemon_discord.command.Category;
import fr.reminy.pokemon_discord.command.Command;
import fr.reminy.pokemon_discord.command.Commands;
import fr.reminy.pokemon_discord.annotation.command.Register;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageEvent;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Register
public class HelpCommand implements Command {

    @Override
    public String[] getLabels() {
        return new String[]{ "help", "h" };
    }

    @Override
    public String getDescription() {
        return "List all commands (& how they work)";
    }

    @Override
    public Category getCategory() {
        return Category.COMMON;
    }

    @Override
    public void execute(MessageEvent event, MessageAuthor author, TextChannel channel, List<String> args) {
        Map<Category, List<Command>> commands = Commands.list().stream().collect(Collectors.groupingBy(Command::getCategory));

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setColor(Color.WHITE);

        for (Map.Entry<Category, List<Command>> commandsByCategory : commands.entrySet()) {
            Category category = commandsByCategory.getKey();
            List<Command> cmds = commandsByCategory.getValue();
            embedBuilder.addField(category.getLabel().toUpperCase(),
                    cmds.stream().map(cmd -> String.format("`%s` : %s", Settings.PREFIX + cmd.getLabels()[0], cmd.getDescription()))
                            .collect(Collectors.joining("\n")));
        }

        channel.sendMessage(embedBuilder);
    }
}
