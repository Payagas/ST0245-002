from Reader import reader
class Trainer:
    '''
    Imports the reader method
    This class creates an instruction list from the 
    train data text, it makes diferent desitions in a 
    range, and then it picks the desition that has the 
    smallest fail range in one node, then it's added 
    to the instruction list
    >>> dic = The data from train.txt
    >>> instructions = The list the instructions that will 
    be used by the Tree class, they'll be appended while 
    this tree picks the values.
    '''
    def __init__(self, fil):
        self.dic = reader(fil)
        self.instructions = []

    '''
    The main method, it creates a tree of depth three
    and the values from the range are picked in an 
    avarge best, the algorith then selects only the best values
    '''
    def main(self):
        node1 = self.trainer(self.dic[0],40,71,1,3)
        node2 = self.trainer(node1,30,61,1,3)
        self.trainer(node2,1200,3000,50,4)
        return self.instructions

    '''
    The main method that creates the instruccions of the tree
    It saves the value that has one node with the lowest 
    value tries multiple tree configurations within the range
    >>> U = The array of the node to be separated, this is an
    impure node, the next node to be purified will be the most impure
    >>> a = The lower range 
    >>> b = The higer range
    >>> c = The increase from a to reach b
    >>> p = The value that will be selected to compare the impurity
    for example, the value 3 equals to the soil moisture
    '''
    def trainer(self, U, a, b, c, p):
        bestProb = 0
        left = False
        for x in range(a,b,c):
            thisData = self.trainerAux(U, x, p)
            probL = thisData[3]
            probR = thisData[4]

            if probL < 0.5:
                probL = 1 - probL
            if probR < 0.5:
                probR = 1 - probR

            if bestProb < probL:
                left = True
                bestProb = probL
                bestData = thisData
            if bestProb < probR:
                left = False
                bestProb = probR
                bestData = thisData

        self.instructions.append(bestData[2])
        self.instructions.append(bestData[5])
        self.instructions.append(bestData[3])
        self.instructions.append(bestData[4])
        if left:
            self.instructions.append('rigth')
            return bestData[1]
        else:
            self.instructions.append('left')
            return bestData[0] 
        
    '''
    This method is the auxiliary to the trainer, it takes 
    a value to compare and separates the node, it then 
    checks the probability of success
    >>> U = The array of the node to be separated
    >>> x = The value to be compared
    >>> p = The value that will be selected to compare the impurity
    '''
    def trainerAux(self, U, x, p):
        L = []
        R = []
        for u in U:
            if self.dic[p][u] > x:
                L.append(u)
            else:
                R.append(u)
        if len(L) == 0 or len(R) == 0:
            return [L, R, x, 0.5, 0.5, p]
        numL = 0
        numR = 0
        for u in L:
            if self.dic[7][u] == 'yes\n':
                numL += 1
        for u in R:
            if self.dic[7][u] == 'yes\n':
                numR += 1

        probL = numL/len(L)
        probR = numR/len(R)
        return [L, R, x, probL, probR, p]