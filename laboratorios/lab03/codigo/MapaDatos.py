import pandas as pd

dataVertices = pd.read_csv('Vertices.csv')
dataVertices.columns = ["ID", "CoordenadaX", "CoordenadaY", "Nombre"]
print(dataVertices.head())

dataArcos = pd.read_csv('Arcos.csv')
dataArcos.columns = ["ID", "ID1", "Distancia", "Nombre"]
print(dataArcos.head())

diccArcos = {}
for i in range(len(dataArcos)):
    diccArcos[(dataArcos.iloc[i]['ID'], dataArcos.iloc[i]['ID1'])
              ] = dataArcos['Distancia'][i]

print("El diccionario de los arcos es:")
print(diccArcos)

diccVert = {}
for i in range(len(dataVertices)):
    diccVert[(dataVertices.iloc[i]['ID'])] = (
        dataVertices['CoordenadaX'][i], dataVertices['CoordenadaY'][i])

print("El diccionario de los vertices es:")
print(diccVert)
