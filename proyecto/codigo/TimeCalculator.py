from time import time
import os
import psutil
from Tree import Tree
from Trainer import Trainer

'''
This class checks the time and memory used by the 
program, it repeats the process 1000 times with
3 diferent data sets
'''
def get_process_memory():
    process = psutil.Process(os.getpid())
    return process.memory_info().rss

med = []
medo = []
trainer = Trainer("data_set_test.csv")
for i in range(1000):
    start_time = time()
    start_memo = get_process_memory()
    trainer.main()
    med.append(time() - start_time)
    medo.append(get_process_memory() - start_memo)
tot = sum(med) / len(med)
print('Data 1 train')
print(tot)
print(sum(med))
print(sum(medo))
print()
med = []
medo = []
tree = Tree("data_set_test.csv", "data_set_test.csv")
for i in range(1000):
    start_time = time()
    start_memo = get_process_memory()
    tree.main()
    med.append(time() - start_time)
    medo.append(get_process_memory() - start_memo)
tot = sum(med) / len(med)
print('Data 1 validation')
print(tot)
print(sum(med))
print(sum(medo))
print()

med = []
medo = []
trainer = Trainer("data_set_train.csv")
for i in range(1000):
    start_time = time()
    start_memo = get_process_memory()
    trainer.main()
    med.append(time() - start_time)
    medo.append(get_process_memory() - start_memo)
tot = sum(med) / len(med)
print('Data 2 train')
print(tot)
print(sum(med))
print(sum(medo))
print()
med = []
medo = []
tree = Tree("data_set_train.csv", "data_set_train.csv")
for i in range(1000):
    start_time = time()
    start_memo = get_process_memory()
    tree.main()
    med.append(time() - start_time)
    medo.append(get_process_memory() - start_memo)
tot = sum(med) / len(med)
print('Data 2 validation')
print(tot)
print(sum(med))
print(sum(medo))
print()

med = []
medo = []
trainer = Trainer("data_set.csv")
for i in range(1000):
    start_time = time()
    start_memo = get_process_memory()
    trainer.main()
    med.append(time() - start_time)
    medo.append(get_process_memory() - start_memo)
tot = sum(med) / len(med)
print('Data 3 train')
print(tot)
print(sum(med))
print(sum(medo))
print()
med = []
medo = []
tree = Tree("data_set.csv", "data_set.csv")
for i in range(1000):
    start_time = time()
    start_memo = get_process_memory()
    tree.main()
    med.append(time() - start_time)
    medo.append(get_process_memory() - start_memo)
tot = sum(med) / len(med)
print('Data 3 validation')
print(tot)
print(sum(med))
print(sum(medo))
print()