package app.serialize.impl;

public class SerializationEsception extends RuntimeException {

	public SerializationEsception(String message) {
		super(message);
	}

	public SerializationEsception(String message, Throwable cause) {
		super(message, cause);
	}
}
