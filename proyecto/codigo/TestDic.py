import pandas as pd

# dataVertices = pd.read_csv('Vertices.csv')
# dataVertices.columns = ["ID", "CoordenadaX", "CoordenadaY", "Nombre"]
#

# for i in dataVertices['Nombre']:
#     print(i)

full = pd.read_csv('data_set_train.csv')
full.columns = [
    'ph', 'soil_temperature', 'soil_moisture', 'illuminance',
    'env_temperature', 'env_humidity', 'label'
]

for i in full['env_humidity']:
    print(i)

print(full.head())
print(full.size)
