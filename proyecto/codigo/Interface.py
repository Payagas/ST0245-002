from Tree import Tree
from Tree import Node
from sys import exit
'''
This is the interface class, it displays the tree
visualy to the user and lets them travel it whole
'''
class interface():
    '''
    Constructor
    >>> tree = The tree created by the Tree class
    >>> currentNode = The node that is currently 
    the user on, it starts on the root .
    >>> depth = The depth the user is currently on,
    used to return to the previous node
    '''
    def __init__(self):
        print("Do you whish to select the files manualy? ")
        yes = input()
        if yes == 'yes' or yes == 'Yes':
            print("The name of the trainer file: ")
            train = input()
            print("The name of the test file: ")
            test = input()  
        else:
            train = "data_set_train.csv"
            test = "data_set_test.csv"
        self.tree = Tree(train, test)
        self.tree.main()
        self.currentNode = self.tree.root
        self.depth = 0

    '''
    The main method displays the options and starts
    an endless loop that will stop when the user 
    choses to
    '''
    def main(self):
        self.options()
        while True:
            x = int(input())
            self.select(x)

    '''
    This method prints the option menu to let the
    user choose
    '''
    def options(self):
        print('0 --- view the options')
        print('1 --- go to the root')
        print('2 --- go to the right node')
        print('3 --- go to the left node')
        print('4 --- return to the previous node')
        print('5 --- see how well it did on the current node')
        print('6 --- end the program')

    '''
    This method reads what the user chose and 
    performs the desired method
    '''
    def select(self, x):
        if x == 0:
            self.options()
        elif x == 1:
            print(self.tree.root)
            self.currentNode = self.tree.root
            self.depth = 0
        elif x == 2:
            self.travel(True)
        elif x == 3:
            self.travel(False)
        elif x == 4:
            self.returnn()
        elif x == 5:
            self.certainty(self.currentNode.u)
        elif x == 6:
            self.terminate()
        else:
            print("Invalid option. ")

    '''
    This method travels to a son of the current node
    it recieves a boolean called right, if it's true
    then it will travel to the right node, if it's 
    false then it goes to the left node.
    If the current node is a leaf, then it advices 
    the user to not go further and return to keep exploring.
    '''
    def travel(self, right):
        if self.currentNode.r == None:
            print("You can't travel from a leaf! Please return")
            return 
        elif(right):
            self.currentNode = self.currentNode.r
        else:
            self.currentNode = self.currentNode.l
        self.depth += 1
        print(self.currentNode) 

    '''
    This method returns from the current node to 
    its father node, if the user tries to return
    from the root the program will tell them 
    why they can't
    '''
    def returnn(self):
        if self.depth == 0:
            print("You can't go back from the root! Please go forward")
        else:
            self.currentNode = self.tree.root
            for i in range(1, self.depth):
                self.currentNode = self.currentNode.r
            self.depth -= 1
            print(self.currentNode)
        
    '''
    This method confirms how is the porcentage of
    the valification data compared to the test
    '''
    def certainty(self, U):
        count = 0
        for u in U:
            if self.tree.dic[7][u] == 'yes\n':
                count += 1
        count = (count/len(U))*100
        print(int(count),"% of plants have Roya")

    def terminate(self):
        exit() 

inter = interface()
inter.main()