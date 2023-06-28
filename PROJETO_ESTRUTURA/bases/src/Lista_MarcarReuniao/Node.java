package Lista_MarcarReuniao;

public class Node<T> {

	  private T dado;
	  private Node<T> previous;
	  private Node<T> next;

	  public Node(T dado) {
	    this.dado = dado;
	    this.previous = null;
	    this.next = null;
	  }

	  public T getDado() {
	    return dado;
	  }

	  public Node<T> getPrevious() {
	    return previous;
	  }

	  public void setPrevious(Node<T> previous) {
	    this.previous = previous;
	  }

	  public Node<T> getNext() {
	    return next;
	  }

	  public void setNext(Node<T> next) {
	    this.next = next;
	  }
	}

