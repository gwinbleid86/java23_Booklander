package kg.attractor.java.lesson47;

import com.sun.net.httpserver.HttpExchange;
import kg.attractor.java.lesson46.Lesson46Server;
import kg.attractor.java.utils.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Lesson47Server extends Lesson46Server {
    public Lesson47Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/query", this::handleQueryRequest);
    }

    private void handleQueryRequest(HttpExchange exchange) {
        String query = getQueryParams(exchange);

        Map<String, String> params = Utils.parseUrlEncoded(query, "&");

        Map<String, Object> data = new HashMap<>();
        data.put("params", params);

        renderTemplate(exchange, "query.ftlh", data);
    }
}
