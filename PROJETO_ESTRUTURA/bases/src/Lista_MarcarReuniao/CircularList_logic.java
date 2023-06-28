package Lista_MarcarReuniao;

import java.util.NoSuchElementException;

public class CircularList_logic<T> {

  private Node<T> head;
  private int size;

  public CircularList_logic() {
    head = null;
    size = 0;
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void addFirst(T dado) {
    Node<T> newNode = new Node<>(dado);
    if (isEmpty()) {
      newNode.setNext(newNode);
      newNode.setPrevious(newNode);
    } else {
      newNode.setNext(head);
      newNode.setPrevious(head.getPrevious());
      head.getPrevious().setNext(newNode);
      head.setPrevious(newNode);
    }
    head = newNode;
    size++;
  }

  public void addLast(T dado) {
    Node<T> newNode = new Node<>(dado);
    if (isEmpty()) {
      newNode.setNext(newNode);
      newNode.setPrevious(newNode);
      head = newNode;
    } else {
      newNode.setNext(head);
      newNode.setPrevious(head.getPrevious());
      head.getPrevious().setNext(newNode);
      head.setPrevious(newNode);
    }
    size++;
  }

  public T removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    T removedDado = head.getDado();
    if (size == 1) {
      head = null;
    } else {
      head.getNext().setPrevious(head.getPrevious());
      head.getPrevious().setNext(head.getNext());
      head = head.getNext();
    }
    size--;
    return removedDado;
  }

  public T removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    T removedDado = head.getPrevious().getDado();
    if (size == 1) {
      head = null;
    } else {
      Node<T> last = head.getPrevious();
      last.getPrevious().setNext(head);
      head.setPrevious(last.getPrevious());
    }
    size--;
    return removedDado;
  }

  public void add(int index, T dado) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    if (index == 0) {
      addFirst(dado);
    } else if (index == size) {
      addLast(dado);
    } else {
      Node<T> current = head;
      for (int i = 0; i < index - 1; i++) {
        current = current.getNext();
      }
      Node<T> newNode = new Node<>(dado);
      newNode.setNext(current.getNext());
      newNode.setPrevious(current);
      current.getNext().setPrevious(newNode);
      current.setNext(newNode);
      size++;
    }
  }

  public T get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node<T> current = head;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current.getDado();
  }

  public int indexOf(T dado) {
    int index = 0;
    Node<T> current = head;
    while (current != null) {
      if (current.getDado().equals(dado)) {
        return index;
      }
      current = current.getNext();
      index++;
    }
    return -1;
  }

  public boolean contains(T dado) {
    return indexOf(dado) != -1;
  }

  public void imprimirLista() {
      if (isEmpty()) {
          System.out.println("A lista está vazia.");
      } else {
          Node<T> current = head;
          for (int i = 0; i < size; i++) {
              System.out.print(current.getDado() + " ");
              current = current.getNext();
          }
          System.out.println();
      }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    if (isEmpty()) {
        sb.append("A lista está vazia.");
    } else {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            sb.append(current.getDado()).append(" ");
            current = current.getNext();
        }
    }
    return sb.toString();
}

}

 


