import java.lang.IndexOutOfBoundsException;
public class LinkedListBoolean {
    NodeBoolean first;
    private int size;
    public LinkedListBoolean() {
        size = 0;
        first = null;
    }

    /**
     * Returns the node at the specified position in this list.
     *
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private NodeBoolean getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            NodeBoolean temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     */
    public boolean get(int index) {
        NodeBoolean temp = null;
        try {
            temp = getNode(index);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return temp.data;
    }

    // Retorna el tamaño actual de la lista
    public int size() {
        return size;
    }

    // Inserta un dato en la posición index
    public void insert(boolean data, int index) throws IndexOutOfBoundsException {
        if (index == 0) {
            NodeBoolean nuevo = new NodeBoolean(data);
            nuevo.next = null;
            first = nuevo;
            size++;
        } else if(index != 0){
            NodeBoolean temp = getNode(index - 1);
            NodeBoolean nuevo = new NodeBoolean(data);
            nuevo.next = temp.next;
            temp.next = nuevo;
            size++;
        }else 
        {
            throw new IndexOutOfBoundsException();
        }
    }

    // Borra el dato en la posición index
    public void remove(int index) {
        try {
            if (index == 0) {
                NodeBoolean temp = first;
                first = temp.next;
                size--;
            } else if (index == size - 1) {
                NodeBoolean temp = getNode(size - 2);
                temp.next = null;
                size--;
            } else {
                NodeBoolean temp = getNode(index - 1);
                temp.next = temp.next.next;
                size--;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("La posicion no existe");
        }
    }

    // Verifica si está un dato en la lista
    public boolean contains(boolean data) {
        try {
            for (int i = 0; i < size; i++) {
                if (get(i) == data) {
                    return true;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("La posicion no existe");
        }
        return false;
    }
}
