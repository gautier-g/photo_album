package album.pages;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.net.URL;

public class URLAdapter implements JsonSerializer<URL>, JsonDeserializer<URL> {

    @Override
    public JsonElement serialize(URL src, Type typeOfSrc, JsonSerializationContext context) {
        if (src == null) {
            return JsonNull.INSTANCE;
        }
        return new JsonPrimitive(src.toString());
    }

    @Override
    public URL deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json.isJsonNull()) {
            return null;
        }
        try {
            return new URL(json.getAsString());
        } catch (Exception e) {
            throw new JsonParseException("Erreur lors de la désérialisation de l'URL", e);
        }
    }
}