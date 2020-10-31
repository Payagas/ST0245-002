
f = open('Coordenadas.txt', 'r')
f.readline()
ID = []
X = []
Y = []
for l in f:
    s = l.split(" ")
    ID.append(int(s[0]))
    X.append(float(s[1]))
    Y.append(float(s[2]))
f.close()
w = open('Grupos.txt', 'w')
d = 0
m = [10000, 0]
lista = []


def remove(x):
    ID.pop(x)
    X.pop(x)
    Y.pop(x)


def findnext(a):
    for b in range(len(ID)):
        d = ((a[1] - X[b])**2+(a[2] - Y[b])**2)**(1/2)
        if d < m[0]:
            m[0] = d
            m[1] = b
    lista.append(ID[m[1]])
    m[0] = 10000
    if len(lista) < 5:
        c = [ID[m[1]], X[m[1]], Y[m[1]]]
        remove(m[1])
        m[1] = 0
        findnext(c)
    else:
        remove(m[1])
        m[1] = 0
        w.write(str(lista) + '\n')
        lista.clear()


def main():
    while(len(ID) > 1):
        lista.append(ID[0])
        a = [ID[0], X[0], Y[0]]
        remove(0)
        findnext(a)
    w.close()


main()
