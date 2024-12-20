package com.coze.client.service;

import com.coze.model.audio.*;
import com.coze.request.CozeHttpClient;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AsyncAudioClient {
    private final CozeHttpClient httpClient;
    private static final String BASE_PATH = "/v1/audio";

    public AsyncAudioClient(CozeHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public CompletableFuture<List<Voice>> listVoices() {
        return httpClient.getAsync(BASE_PATH + "/voices", new TypeReference<List<Voice>>() {});
    }

    public CompletableFuture<Voice> getVoice(String voiceId) {
        return httpClient.getAsync(BASE_PATH + "/voices/" + voiceId, Voice.class);
    }

    public CompletableFuture<AudioResponse> synthesize(VoiceSynthesisRequest request) {
        return httpClient.postAsync(BASE_PATH + "/synthesize", request, AudioResponse.class);
    }
}
