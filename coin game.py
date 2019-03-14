""" The coin stip game
by Sarah Ying Ying Zhang, Upi szha677, ID 397042883
Goal of the game is to move one coin on numbers 1, 2, 3 or 4.
Only one coin can sit on each of those numbers. 
Turns are taken by two players who move a coin and the last player that moves the last coin so that 1, 2, and 4 has a coin wins.
"""
import random
import math
def create_game_string():
	game_string = " $ $ $ $ "
	count=0
	#calling helper function to randomise game_string and looping 7 times
	while count <=7:
		game_loop= jumble_game_line(game_string)       
		count=count+1
	return game_loop
	
def jumble_game_line(game_line):
	#generating random index
	generating_position1 = random.randrange(0,9)      
	generating_position2 = random.randrange(0,9)  
	#storing number to swap	
	value1 = game_line[generating_position1]       
	value2 = game_line[generating_position2]     
	#swapping value at generating_position1 with another value at generatin_position2 	
	game_line = game_line[:generating_position1] + value2 + game_line[generating_position1+1:]
	game_line = game_line[:generating_position2] + value1 + game_line[generating_position2+1:] 
	return game_line
	
def display_game_string(game_string):
	first_line = ""
	second_line = "    1     2     3     4     5     6     7     8     9  "
	third_line ="||     |     |     |     |     |     |     |     |     ||"
	#Iteration loop
	fourth_line=""
	for character in game_string:   
		fourth_line =   fourth_line + "|  "+ character +"  "      #setting up of game board 
	fourth_line = "|"+fourth_line+"||"	
	fifth_line ="||     |     |     |     |     |     |     |     |     ||"
	last_line = ""
	
	print(first_line)
	print(second_line)
	print(third_line)
	print(fourth_line)
	print(fifth_line)
	print(last_line)

def get_user_position_num(player_num):
	if player_num ==1:
		print("PLAYER NUMBER: 1")
		
	else :
		print("PLAYER NUMBER: 2")
		
	player_position = input("Enter position number:")
			
	return player_position	
	
def get_num_to_move():
	spaces_move = input("Enter number to move:")
	return spaces_move

def move_dollar_to_the_left(game_string, position_number, to_move):
    
	index1= int(position_number)-1
	index2 = int(position_number)-1-int(to_move)
	
	value1 = game_string[index1]       
	value2 = game_string[index2]     
	#move the dollar signs
	#swap the characters at the above indexes
	game_string = game_string[:index1] + value2 + game_string[index1+1:]
	game_string = game_string[:index2] + value1 + game_string[index2+1:] 
	
	return game_string
	
def get_next_player_num(player_num):
	if player_num ==1:
		
		player_num = player_num+1
	else :
		
		player_num = player_num-1
	
	return player_num
	
def	congratulate_player(player_num):
	print("="*25)
	print("** Y O U H A V E W O N **")
	print("    PLAYER NUMBER:", player_num, "    ")
	print("** Y O U H A V E W O N **")
	print("="*25)
	
def check_game_finished(game_string):
	first_four_symbols = game_string[0:4]
	if first_four_symbols == "$$$$":
		return True
	return False
# PLAY ONE GAME OF COIN STRIP
def play_one_game():
	player_num = 1
	game_finished = False
	game_string = create_game_string()
	while game_finished == False:
		display_game_string(game_string)
		position_num = get_user_position_num(player_num)
		move_num = get_num_to_move()
		game_string = move_dollar_to_the_left(game_string,
		position_num, move_num)
		game_finished = check_game_finished(game_string)
		if game_finished:
			display_game_string(game_string)
			congratulate_player(player_num)
		else:
			player_num = get_next_player_num(player_num)
def display_menu():
	print("1. PLAY COIN STRIP")
	print("2. EXIT")
	number_selection = input("Enter selection:")
		
	return  number_selection
def main():
	number_selection = display_menu()
	while int(number_selection) ==1:
		playing_game=play_one_game()
		number_selection = display_menu()	
	print()
	print("BYE FROM COIN STRIP")
main()
