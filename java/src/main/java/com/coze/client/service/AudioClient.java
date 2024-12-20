package com.coze.client.service;

import com.coze.model.audio.*;
import com.coze.request.CozeHttpClient;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

public class AudioClient {
    private final CozeHttpClient httpClient;
    private static final String BASE_PATH = "/v1/audio";

    public AudioClient(CozeHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public List<Voice> listVoices() {
        return httpClient.get(BASE_PATH + "/voices", new TypeReference<List<Voice>>() {});
    }

    public Voice getVoice(String voiceId) {
        return httpClient.get(BASE_PATH + "/voices/" + voiceId, Voice.class);
    }

    public AudioResponse synthesize(VoiceSynthesisRequest request) {
        return httpClient.post(BASE_PATH + "/synthesize", request, AudioResponse.class);
    }
}
