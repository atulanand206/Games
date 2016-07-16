from __future__ import print_function
import subprocess as sp
tmp = sp.call('clear',shell=True)
board = [" "," "," "," "," "," "," "," "," "]
def printBoard():
	print(" ", end = "")
	print(board[0],end = " | ")
	print(board[1],end = " | ")
	print(board[2],end = "\n")
	print("-----------")
	print(" ", end = "")
	print(board[3],end = " | ")
	print(board[4],end = " | ")
	print(board[5],end = "\n")
	print("-----------")
	print(" ", end = "")
	print(board[6],end = " | ")
	print(board[7],end = " | ")
	print(board[8],end = "\n")
def chk(a,b,c):
	if(board[a]==board[b] and board[b]==board[c] and (board[a]=="X" or board[a]=="O")):
		return True
	else:
		return False
def win(ok):
	if(chk(0,1,2) or chk(3,4,5) or chk(6,7,8) or chk(0,3,6) or chk(1,4,7) or chk(2,5,8) or chk(0,4,8) or chk(2,4,6)):
		return False
	else:
		return True
print("Tic Tac Toe - 1.2")
print("Enter First Player Name: ", end = "")
p = raw_input()
P = [p]
print("Enter First Player Name: ", end = "")
p = raw_input()
P.append(p)
print("Let's Play " + P[0] + " vs. " + P[1])
printBoard()
ok = True
chance = 0
ctr = 0
while(ok and ctr<9):
	print("Enter your move " + P[chance] + " (row col): ", end = "")
	mv = list(map(int,((raw_input()).split(" "))))
	move = 3*(mv[0]-1)+mv[1]
	move = move-1
	if(move>8 or move<0):
		print("Invalid Move! Try Again")
	else:
		if(board[move]!=" "):
			print("Invalid Move! Try Again")
		else:
			if(chance==0):
				board[move]="X"
			else:
				board[move]="O"
			ctr+=1
			tmp = sp.call('clear',shell=True)
			print("Tic Tac Toe - 1.2")
			print("We're playing " + P[0] + " vs. " + P[1])
			printBoard()
			ok = win(ok)
			chance = 1-chance
if(ctr==9 and ok==True):
	print("Game Draw, Nobody Won!!")
if(ok==False):
	print(P[1-chance] + " Won, Congrats!!!")