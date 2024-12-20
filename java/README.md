# Coze Java SDK

The official Java SDK for the Coze API.

## Installation

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.coze</groupId>
    <artifactId>coze-java</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

## Usage

### Authentication

```java
TokenAuth auth = TokenAuth.builder()
    .token("your-api-token")
    .build();

Coze client = Coze.builder()
    .auth(auth)
    .build();
```

### Chat Example

```java
Message message = Message.builder()
    .role(MessageRole.USER)
    .content("Hello!")
    .build();

ChatResponse response = client.chat()
    .createConversation(message);
```

### Streaming Example

```java
EventHandler<ChatEvent> handler = new EventHandler<ChatEvent>() {
    @Override
    public void onEvent(ChatEvent event) {
        System.out.println("Received: " + event);
    }

    @Override
    public void onComplete() {
        System.out.println("Stream completed");
    }

    @Override
    public void onError(Throwable t) {
        System.err.println("Error: " + t.getMessage());
    }
};

client.chat().streamConversation(message, handler);
```

## Documentation

For detailed documentation and examples, please refer to the [Coze API Documentation](https://docs.coze.com).

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct and the process for submitting pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
