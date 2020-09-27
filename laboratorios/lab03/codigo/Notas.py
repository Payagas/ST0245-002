import pandas as pd

Fundamentos = pd.read_csv('Fundamentos.csv')
Datos1 = pd.read_csv('Datos1.csv')
Datos2 = pd.read_csv('Datos2.csv')

Fundamentos.columns = Fundamentos[["nombre", "codigo", "Cod. Materia", "Semestre", "Grupo", "", "",
                                   "Descripcion Evaluacion", "Porcentaje", "Descripcion", "Nom. Materia", "", "Nota", "Nota Definitiva"]]
Datos1.columns = Datos1[["nombre", "codigo", "Cod. Materia", "Semestre", "Grupo", "", "",
                         "Descripcion Evaluacion", "Porcentaje", "Descripcion", "Nom. Materia", "", "Nota", "Nota Definitiva"]]
Datos2.columns = Datos2[["nombre", "codigo", "Cod. Materia", "Semestre", "Grupo", "", "",
                         "Descripcion Evaluacion", "Porcentaje", "Descripcion", "Nom. Materia", "", "Nota", "Nota Definitiva"]]

Fundamentos = Fundamentos.drop_duplicates(['codigo'], keep='last')
Datos1 = Datos1.drop_duplicates(['codigo'], keep='last')
Datos2 = Datos2.drop_duplicates(['codigo'], keep='last')

print(Fundamentos)
print(Datos1)
print(Datos2)


def BuscarCurso(materia, Semestre):
    if(materia == 'ST0242'):
        for i in range(len(Fundamentos)):
            if(Fundamentos['Semestre'][i] == Semestre):
                print(Fundamentos['nombre'][i] + ' ' +
                      Fundamentos['Nota Definitiva'][i])
    if(materia == 'ST0245'):
        for i in range(len(Datos1)):
            if(Datos1['Semestre'][i] == Semestre):
                print(Datos1['nombre'][i] + ' ' + Datos1['Nota Definitiva'][i])
    if(materia == 'ST0247'):
        for i in range(len(Datos2)):
            if(Datos2['Semestre'][i] == Semestre):
                print(Datos2['nombre'][i] + ' ' + Datos2['Nota Definitiva'][i])


def BuscarAlumno(Estudiante, Semestre):
    for i in range(len(Fundamentos)):
        if(Fundamentos['nombre'][i] == Estudiante and Fundamentos['Semestre'][i] == Semestre):
            print(Fundamentos['Cod. Materia'][i] + ' ' +
                  Fundamentos['Nota Definitiva'][i])
    for i in range(len(Datos1)):
        if(Datos1['nombre'][i] == Estudiante and Datos1['Semestre'][i] == Semestre):
            print(Datos1['Cod. Materia'][i] + ' ' +
                  Datos1['Nota Definitiva'][i])
    for i in range(len(Datos2)):
        if(Datos2['nombre'][i] == Estudiante and Datos2['Semestre'][i] == Semestre):
            print(Datos2['Cod. Materia'][i] + ' ' +
                  Datos2['Nota Definitiva'][i])


BuscarCurso('ST0242', '20151')
BuscarAlumno('Adela', '20142')
