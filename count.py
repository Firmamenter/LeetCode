import os
rootdir = os.getcwd()

count = 0

for subdir, dirs, files in os.walk(rootdir):
    for file in files:
    	if file.endswith('.java'):
        	print(file)
        	count += 1

print('******************************')
print('Amount of Solved Problems: ', count)
