package com.coze.client.service;

import com.coze.model.bot.*;
import com.coze.request.CozeHttpClient;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class AsyncBotClient {
    private final CozeHttpClient httpClient;
    private static final String BASE_PATH = "/v1/bots";

    public AsyncBotClient(CozeHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public CompletableFuture<Bot> createBot(Bot bot) {
        return httpClient.postAsync(BASE_PATH, bot, Bot.class);
    }

    public CompletableFuture<Bot> getBot(String botId) {
        return httpClient.getAsync(BASE_PATH + "/" + botId, Bot.class);
    }

    public CompletableFuture<List<Bot>> listBots() {
        return httpClient.getAsync(BASE_PATH, new TypeReference<List<Bot>>() {});
    }

    public CompletableFuture<Bot> updateBot(String botId, Bot bot) {
        return httpClient.putAsync(BASE_PATH + "/" + botId, bot, Bot.class);
    }

    public CompletableFuture<Void> deleteBot(String botId) {
        return httpClient.deleteAsync(BASE_PATH + "/" + botId);
    }

    public CompletableFuture<Bot> addPlugin(String botId, BotPluginInfo plugin) {
        return httpClient.postAsync(BASE_PATH + "/" + botId + "/plugins", plugin, Bot.class);
    }

    public CompletableFuture<Bot> removePlugin(String botId, String pluginId) {
        return httpClient.deleteAsync(BASE_PATH + "/" + botId + "/plugins/" + pluginId, Bot.class);
    }

    public CompletableFuture<Bot> updatePlugin(String botId, String pluginId, BotPluginInfo plugin) {
        return httpClient.putAsync(BASE_PATH + "/" + botId + "/plugins/" + pluginId, plugin, Bot.class);
    }

    public CompletableFuture<Bot> updatePrompt(String botId, BotPromptInfo prompt) {
        return httpClient.putAsync(BASE_PATH + "/" + botId + "/prompt", prompt, Bot.class);
    }


    public CompletableFuture<Bot> updateModel(String botId, BotModelInfo model) {
        return httpClient.putAsync(BASE_PATH + "/" + botId + "/model", model, Bot.class);
    }
}
