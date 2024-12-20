package com.coze.request;

import com.coze.model.chat.ChatEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class StreamingResponseHandler implements EventHandler<String> {
    private final EventHandler<ChatEvent> handler;
    private final ObjectMapper mapper;

    public StreamingResponseHandler(EventHandler<ChatEvent> handler) {
        this.handler = handler;
        this.mapper = new ObjectMapper();
    }

    @Override
    public void onEvent(String data) {
        try {
            ChatEvent event = mapper.readValue(data, ChatEvent.class);
            handler.onEvent(event);
        } catch (IOException e) {
            handler.onError(e);
        }
    }

    @Override
    public void onComplete() {
        handler.onComplete();
    }

    @Override
    public void onError(Throwable error) {
        handler.onError(error);
    }
}
