"""
'ph', 'soil_temperature', 'soil_moisture', 'illuminance',
    'env_temperature', 'env_humidity', 'label'
"""
def reader(locat):
    fil = open(locat)
    fil.readline()
    u = []
    ph = []
    stemp = []
    smoist = []
    illum = []
    etemp = []
    ehum = []
    label = []
    n = 0
    for l in fil:
        s = l.split(",")
        u.append(n)
        ph.append(float(s[0]))
        stemp.append(float(s[1]))
        smoist.append(float(s[2]))
        illum.append(float(s[3]))
        etemp.append(float(s[4]))
        ehum.append(float(s[5]))
        label.append(s[6])
        n += 1
    fil.close
    return [u, ph, stemp, smoist, illum, etemp, ehum, label]