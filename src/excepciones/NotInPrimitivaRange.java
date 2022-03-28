package excepciones;

@SuppressWarnings("serial")
public class NotInPrimitivaRange extends Exception {
	public NotInPrimitivaRange(String errorMessage) {
		super(errorMessage);
	}
}
