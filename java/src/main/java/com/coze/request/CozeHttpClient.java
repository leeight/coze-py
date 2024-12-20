package com.coze.request;

import com.coze.exception.CozeException;
import okhttp3.*;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class CozeHttpClient {
    private final OkHttpClient client;
    private final String baseUrl;
    private final String token;

    public CozeHttpClient(String token) {
        this(token, "https://api.coze.com");
    }

    public CozeHttpClient(String token, String baseUrl) {
        this.client = new OkHttpClient.Builder().build();
        this.token = token;
        this.baseUrl = baseUrl;
    }

    public Response execute(Request request) throws CozeException {
        try {
            return client.newCall(request).execute();
        } catch (IOException e) {
            throw new CozeException("Failed to execute request", e);
        }
    }

    public CompletableFuture<Void> streamAsync(Request request, EventHandler<String> handler) {
        CompletableFuture<Void> future = new CompletableFuture<>();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.onError(new CozeException("Stream request failed", e));
                future.completeExceptionally(e);
            }

            @Override
            public void onResponse(Call call, Response response) {
                try (ResponseBody body = response.body()) {
                    if (!response.isSuccessful()) {
                        String errorMessage = body != null ? body.string() : "Unknown error";
                        CozeException error = new CozeException(errorMessage, response.code(), response.header("X-Request-Id"));
                        handler.onError(error);
                        future.completeExceptionally(error);
                        return;
                    }

                    if (body == null) {
                        handler.onError(new CozeException("Empty response body", 500, response.header("X-Request-Id")));
                        future.completeExceptionally(new CozeException("Empty response body"));
                        return;
                    }

                    try {
                        String line;
                        while ((line = body.source().readUtf8Line()) != null) {
                            if (line.trim().isEmpty()) continue;
                            handler.onEvent(line);
                        }
                        handler.onComplete();
                        future.complete(null);
                    } catch (IOException e) {
                        handler.onError(new CozeException("Error reading stream", e));
                        future.completeExceptionally(e);
                    }
                }
            }
        });

        return future;
    }

    protected Request.Builder createRequestBuilder(String path) {
        return new Request.Builder()
            .url(baseUrl + path)
            .header("Authorization", "Bearer " + token)
            .header("Accept", "application/json");
    }
}
