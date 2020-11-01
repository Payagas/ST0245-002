
f = open('Colors.txt', 'r')
info = []
for l in f:
    info.append(l.split(" "))
f.close()

listaInstrucciones = []
lista = []

for i in range(2, len(info)-1):
    if len(info[i]) == 1 and len(info[i+1]) == 1:
        listaInstrucciones.append(lista)
        lista = []
    elif len(info[i]) == 2:
        lista.append(info[i])
listaInstrucciones.append(lista)

poss = False
for j in listaInstrucciones:
    if len(j) != 3:
        print("BICOLORABLE")
    else:
        print("NOT BICOLORABLE")
