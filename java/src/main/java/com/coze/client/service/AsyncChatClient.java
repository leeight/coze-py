package com.coze.client.service;

import com.coze.model.chat.*;
import com.coze.request.*;
import okhttp3.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.CompletableFuture;

public class AsyncChatClient {
    private final CozeHttpClient httpClient;
    private final ObjectMapper mapper;

    public AsyncChatClient(CozeHttpClient httpClient) {
        this.httpClient = httpClient;
        this.mapper = new ObjectMapper();
    }

    public CompletableFuture<Void> streamConversation(Message message, EventHandler<ChatEvent> handler) {
        Request request = httpClient.createRequestBuilder("/v1/chat/completions")
            .post(RequestBody.create(
                mapper.writeValueAsString(message),
                MediaType.parse("application/json")
            ))
            .addHeader("Accept", "text/event-stream")
            .build();

        StreamingResponseHandler streamHandler = new StreamingResponseHandler(handler);
        return httpClient.streamAsync(request, streamHandler);
    }
}
