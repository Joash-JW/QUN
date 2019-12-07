import os

print("Integration Testing (Weekly Test) ...")

def runPython(day):
    os.system("python day" + day + ".py")

runPython("1")
runPython("2")
runPython("3")
runPython("4")
runPython("5")
