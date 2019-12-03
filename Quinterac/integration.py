import os
import time
import threading
import pyautogui

print("Integration Testing...")
os.system("mvn compile")
os.chdir("./target/classes")
validAcc = "../../ValidAccList.txt "
transSumDir = "../../TransactionFiles/"
master = "../../Master.txt "

def runJava(session, transSum):
    os.system("java main/Quinterac "+session+" ../../ValidAccList.txt " + transSum)

t = threading.Thread(target=runJava, args=("frontend", "../../TransactionFiles/TransSum1.txt",))
t.start()
time.sleep(1) # important for race conditions
pyautogui.write("login")
pyautogui.press("enter")
pyautogui.write("agent")
pyautogui.press("enter")
pyautogui.write("createacct")
pyautogui.press("enter")
pyautogui.write("1234567")
pyautogui.press("enter")
pyautogui.write("qwerty")
pyautogui.press("enter")
pyautogui.write("logout")
pyautogui.press("enter")

t = threading.Thread(target=runJava, args=("frontend","../../TransactionFiles/TransSum2.txt",))
t.start()
time.sleep(1) # important for race conditions
pyautogui.write("login")
pyautogui.press("enter")
pyautogui.write("agent")
pyautogui.press("enter")
pyautogui.write("createacct")
pyautogui.press("enter")
pyautogui.write("1234568")
pyautogui.press("enter")
pyautogui.write("abcde")
pyautogui.press("enter")
pyautogui.write("logout")
pyautogui.press("enter")

t = threading.Thread(target=runJava, args=("frontend","../../TransactionFiles/TransSum3.txt",))
t.start()
time.sleep(1) # important for race conditions
pyautogui.write("login")
pyautogui.press("enter")
pyautogui.write("agent")
pyautogui.press("enter")
pyautogui.write("createacct")
pyautogui.press("enter")
pyautogui.write("1234569")
pyautogui.press("enter")
pyautogui.write("uwxyz")
pyautogui.press("enter")
pyautogui.write("logout")
pyautogui.press("enter")


t = threading.Thread(target=runJava, args=("backend","../../MergeTransSum.txt",))
t.start()
time.sleep(5) # important for race conditions
