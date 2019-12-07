import os
import time
import threading
import pyautogui

print("Integration Testing  (Day 4) ...")
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
pyautogui.write("withdraw")
pyautogui.press("enter")
pyautogui.write("1234567")
pyautogui.press("enter")
pyautogui.write("1500")
pyautogui.press("enter")
pyautogui.write("logout")
pyautogui.press("enter")

t = threading.Thread(target=runJava, args=("frontend", validAcc, transSumDir+"TransSum2.txt",))
t.start()
time.sleep(1) # important for race conditions
pyautogui.write("login")
pyautogui.press("enter")
pyautogui.write("machine")
pyautogui.press("enter")
pyautogui.write("withdraw")
pyautogui.press("enter")
pyautogui.write("1234568")
pyautogui.press("enter")
pyautogui.write("13500")
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
pyautogui.write("withdraw")
pyautogui.press("enter")
pyautogui.write("1234569")
pyautogui.press("enter")
pyautogui.write("79997000")
pyautogui.press("enter")
pyautogui.write("logout")
pyautogui.press("enter")


t = threading.Thread(target=runJava, args=("backend", master, "../../MergeTransSum.txt",))
t.start()
time.sleep(5) # important for race conditions
