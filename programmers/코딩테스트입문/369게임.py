def solution(order):
    game_numbers = ['3','6','9']
    clap = 0
    for game_number in game_numbers:
        if game_number in str(order):
            clap += str(order).count(game_number) 
    return clap
