package com.coze.client.service;

import com.coze.model.chat.*;
import com.coze.request.*;
import okhttp3.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ChatClient {
    private final CozeHttpClient httpClient;
    private final ObjectMapper mapper;

    public ChatClient(CozeHttpClient httpClient) {
        this.httpClient = httpClient;
        this.mapper = new ObjectMapper();
    }

    public void streamConversation(Message message, EventHandler<ChatEvent> handler) {
        Request request = httpClient.createRequestBuilder("/v1/chat/completions")
            .post(RequestBody.create(
                mapper.writeValueAsString(message),
                MediaType.parse("application/json")
            ))
            .addHeader("Accept", "text/event-stream")
            .build();

        StreamingResponseHandler streamHandler = new StreamingResponseHandler(handler);
        httpClient.streamAsync(request, streamHandler);
    }
}
