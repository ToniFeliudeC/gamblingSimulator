package excepciones;

@SuppressWarnings("serial")
public class NotValidQuinielaInput extends Exception {
	public NotValidQuinielaInput(String errorMessage) {
		super(errorMessage);
	}
}
