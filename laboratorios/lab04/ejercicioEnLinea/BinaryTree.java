import java.util.LinkedList;
public class BinaryTree{
    Node root;
    void root(Node root){
        this.root = root;
    }

    void add(Node son, Node father){
        if(son.key == father.key) return;
        if(son.key < father.key){
            if(father.left == null)
                father.left = new Node(son.key);
            else
                add(son, father.left);
        }else{
            if(father.right == null)
                father.right = new Node(son.key);
            else
                add(son, father.right);
        }
    }

    void BuildFromString(String tree){
        String build = "";
        LinkedList<String> list = new LinkedList<String>();
        for(int i=0; i<tree.length(); i++){
            if(tree.charAt(i) == ' '){
                list.add(build);
                build = "";
            }else{
                build += tree.charAt(i);
            }
        }
        root(new Node(list.pop()));
        for(String n: list){
            add(new Node(n),root);
        }
    }
    
    String posOrderString(Node node){
        String ret = "";
        if(node.left != null)
            ret += posOrderString(node.left);
        if(node.right != null)
            ret += posOrderString(node.right);
        return ret + " " + node.key;
    }
    
    static void main(String[] args){
        BinaryTree b = new BinaryTree();
        String builder = "50 30 24 5 28 45 98 52 60";
        b.BuildFromString(builder);
        System.out.println("Desde la String: ");
        System.out.println(builder);
        System.out.println("Se retorna la inversa: ");
        System.out.println(b.posOrderString(b.root));
    }
}

class Node{
    int key;
    Node left;
    Node right;
    
    Node(int key){
        this.key = key;
    }

    Node(String key){
        this.key = Integer.parseInt(key);
    }
}
