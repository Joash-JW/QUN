import os
import time
import threading
import pyautogui

print("Integration Testing...")
os.system("mvn compile")
os.chdir("./target/classes")

def runJava():
    os.system("java main/Quinterac frontend ../../ValidAccList.txt 123")

t = threading.Thread(target=runJava, args=())
t.start()
time.sleep(2) # important for race conditions
pyautogui.write("login")
pyautogui.press("enter")