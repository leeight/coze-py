package com.coze.client.service;

import com.coze.model.bot.*;
import com.coze.request.CozeHttpClient;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class BotClient {
    private final CozeHttpClient httpClient;
    private static final String BASE_PATH = "/v1/bots";

    public BotClient(CozeHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Bot createBot(Bot bot) {
        return httpClient.post(BASE_PATH, bot, Bot.class);
    }

    public Bot getBot(String botId) {
        return httpClient.get(BASE_PATH + "/" + botId, Bot.class);
    }

    public List<Bot> listBots() {
        return httpClient.get(BASE_PATH, new TypeReference<List<Bot>>() {});
    }

    public Bot updateBot(String botId, Bot bot) {
        return httpClient.put(BASE_PATH + "/" + botId, bot, Bot.class);
    }

    public void deleteBot(String botId) {
        httpClient.delete(BASE_PATH + "/" + botId);
    }

    public Bot addPlugin(String botId, BotPluginInfo plugin) {
        return httpClient.post(BASE_PATH + "/" + botId + "/plugins", plugin, Bot.class);
    }

    public Bot removePlugin(String botId, String pluginId) {
        return httpClient.delete(BASE_PATH + "/" + botId + "/plugins/" + pluginId, Bot.class);
    }

    public Bot updatePlugin(String botId, String pluginId, BotPluginInfo plugin) {
        return httpClient.put(BASE_PATH + "/" + botId + "/plugins/" + pluginId, plugin, Bot.class);
    }

    public Bot updatePrompt(String botId, BotPromptInfo prompt) {
        return httpClient.put(BASE_PATH + "/" + botId + "/prompt", prompt, Bot.class);
    }

    public Bot updateModel(String botId, BotModelInfo model) {
        return httpClient.put(BASE_PATH + "/" + botId + "/model", model, Bot.class);
    }
}
