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
