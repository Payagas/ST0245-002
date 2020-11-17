from Trainer import Trainer
from Reader import reader
'''
We're importing the tree trainer to recieve the instructions of this tree, 
and the method reader to be able to interpret a txt file that is in format 
of the data
''''''
This is the class Node, it's able to store all the important caracteristics
to view and navigate the tree later, it can print itself in an organized 
and understandable manner
'''
class Node:
    '''
    Constructor
    >>> u = An int array containing the positions of the nodes values in the
    main dictionary
    >>> typ = Stores a string, it is the type of data by which the node 
    was separated
    >>> value = Strores the point at which the father node got separated and 
    especifies if this node was bigger or lesser than that number
    >>> probyes = Stores the probability of a plant inside the tree 
    having the Roya disease
    '''
    def __init__(self, u, typ, value, probyes):
        self.u = u
        self.value = value
        self.typ = typ
        self.probyes = probyes
        self.l = None
        self.r = None

    #Prints the node in an organised manner
    def __str__(self):
        if self.typ == 'Root':
            print("This is the root ")
        else:
            print("This node was separated by", self.typ, "because it was", self.value)
        print("It has", len(self.u), " values")
        print("With a probability of", str(int(self.probyes*100))+'%', "of a plant having Roya disease")
        if self.r == None:
            print("This is a leaf, there's no more nodes below, please return")
        else:
            print("This node has two children")
        return ''

    # This method splits the node, giving it two children
    def split(self, l, r):
        self.l = l
        self.r = r


'''
This is the class Tree, it strores the main dictionary red from the test file,
it also has the instructions recieved from the Trainer and the root node
'''
class Tree:
    '''
    Constructor
    >>> instructions = The values and order at which the tree is to be
    separated, it's recieved from the Trainer class
    >>> dic = The dictionary containing all the data that will be
    filtered throgh the tree, it uses the method reader, by using this
    method the nodes only need to store the positions of the values in
    the dictionary
    >>> root = The father of all other nodes, it's specified that
    it is the root in its construction
    '''
    def __init__(self, train, test):
        train = Trainer(train)
        self.instructions = train.main()
        self.dic = reader(test)
        self.root = Node(self.dic[0], 'Root', '', 0.5)

    '''
    The main method of the tree class, it creates a depth
    four tree
    '''
    def main(self):
        node = self.root
        while len(self.instructions) != 0:
            self.tree(node)
            impure = self.instructions.pop(0)
            if impure == 'right':
                node = node.l
            else:
                node = node.r
        
    '''
    This is the method that reads the instructions and separates 
    the tree acordingly
    '''
    def tree(self, node):
        x = self.instructions.pop(0)
        p = self.instructions.pop(0)
        probL = self.instructions.pop(0)
        probR = self.instructions.pop(0)
        L = []
        R = []
        for u in node.u:
            if self.dic[p][u] > x:
                L.append(u)
            else:
                R.append(u)
        name = ["soil moisture", "illuminance"]
        left = Node(L, name[p-3], "bigger than " + str(x), probL)
        right = Node(R, name[p-3], "lesser than " + str(x), probR)
        node.split(left, right)