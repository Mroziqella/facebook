package pl.mroziqella.facebook.model;

import java.util.Map;

public class Post {

    private String id;
    private String message;
    private Map<String, Object> additionalProperties;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (message != null ? !message.equals(post.message) : post.message != null) return false;
        return additionalProperties != null ? additionalProperties.equals(post.additionalProperties) : post.additionalProperties == null;
    }

    @Override
    public int hashCode() {
        int result = message != null ? message.hashCode() : 0;
        result = 31 * result + (additionalProperties != null ? additionalProperties.hashCode() : 0);
        return result;
    }
}
