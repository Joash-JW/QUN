import os
import time
import threading
import pyautogui

print("Integration Testing  (Day 5) ...")
os.system("mvn compile")
os.chdir("./target/classes")

validAcc = " ../../ValidAccList.txt "
transSumDir = "../../TransactionFiles/"
master = " ../../Master.txt "

def runJava(session, arg1, arg2):
    os.system("java main/Quinterac "+session+ arg1 + arg2)

t = threading.Thread(target=runJava, args=("frontend", validAcc, transSumDir+"TransSum1.txt",))
t.start()
time.sleep(1) # important for race conditions
pyautogui.write("login")
pyautogui.press("enter")
pyautogui.write("agent")
pyautogui.press("enter")
pyautogui.write("deleteacct")
pyautogui.press("enter")
pyautogui.write("1234567")
pyautogui.press("enter")
pyautogui.write("qwerty")
pyautogui.press("enter")
pyautogui.write("logout")
pyautogui.press("enter")

t = threading.Thread(target=runJava, args=("frontend", validAcc, transSumDir+"TransSum2.txt",))
t.start()
time.sleep(1) # important for race conditions
pyautogui.write("login")
pyautogui.press("enter")
pyautogui.write("agent")
pyautogui.press("enter")
pyautogui.write("deleteacct")
pyautogui.press("enter")
pyautogui.write("1234568")
pyautogui.press("enter")
pyautogui.write("abcde")
pyautogui.press("enter")
pyautogui.write("logout")
pyautogui.press("enter")

t = threading.Thread(target=runJava, args=("frontend", validAcc, transSumDir+"TransSum3.txt",))
t.start()
time.sleep(1) # important for race conditions
pyautogui.write("login")
pyautogui.press("enter")
pyautogui.write("agent")
pyautogui.press("enter")
pyautogui.write("deleteacct")
pyautogui.press("enter")
pyautogui.write("1234569")
pyautogui.press("enter")
pyautogui.write("uwxyz")
pyautogui.press("enter")
pyautogui.write("logout")
pyautogui.press("enter")


t = threading.Thread(target=runJava, args=("backend", master, "../../MergeTransSum.txt",))
t.start()
time.sleep(5) # important for race conditions
