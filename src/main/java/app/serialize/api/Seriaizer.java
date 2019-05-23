package app.serialize.api;

public interface Seriaizer {

	<T> void serialize (T t, String filename);
	
	<T> T deserialize (Class<T> t, String filename);
}
