##Pygame
##Leo Yin
##Python (Snake Game)

import pygame
import random
import sys

backColour = (194, 178, 128)
red = (255, 0, 0)
orange = (255, 127, 80)
green = (0, 255, 0)
skyblue = (0, 191, 255)
darkBlue = (0, 0, 139)
violet = (153, 50, 204)
black = (0, 0 , 0)
mouse = pygame.image.load('mouse.png')
mouse = pygame.transform.scale(mouse, (100, 50))
grass = pygame.image.load('grass.png')
grass = pygame.transform.scale(grass, (2000, 1000))
def snake (bodyPosition):
    bodyColour = [skyblue, orange, darkBlue, green, violet]
    for position in bodyPosition:
        pygame.draw.rect(screen, bodyColour[0], [position[0], position[1]-25, 50, 50], 0)
##(Not done need the teacher)        

def hitBorder (head):
    if head[0]>= 1500 or head[0]<0 or head[1]>= 800 or head[1]<0:
        return True
    else:
        return False

def hitSnakeBody(bodyPosition):
    head = bodyPosition[0]
    if head in bodyPosition[1:]:
        return True
    else:
        return False

def Food (foodPosition):
    screen.blit(mouse, [foodPosition[0]-50, foodPosition[1]-30])
##    pygame.draw.circle(screen, red, [foodPosition[0], foodPosition[1]], 25, 0)

def finalScore (fscore, score, hitBoarder, hitSnakeBody):
    if hitBoarder == True:
        fscore = score
    if hitSnakeBody == True:
        fscore = score
    return fscore

def addBody (head, bodyPosition, foodPosition, direction, score):
    if direction == 8:
        head[1] -= 50
        bodyPosition.insert(0,list(head))
        bodyPosition.pop()
        
    elif direction == 4:
        head[0] -= 50
        bodyPosition.insert(0,list(head))
        bodyPosition.pop()

    elif direction == 6:
        head[0] += 50
        bodyPosition.insert(0,list(head))
        bodyPosition.pop()

    elif direction == 2:
        head[1] += 50
        bodyPosition.insert(0,list(head))
        bodyPosition.pop()

    return bodyPosition, foodPosition, score
    
pygame.init()

size = (1500, 775)
screen = pygame.display.set_mode(size)

clock = pygame.time.Clock()
head = [600,400]

bodyPosition = [[600,400],[550,400],[500,400]]
foodPosition = [random.randrange(50, 1450, 50), random.randrange(50, 700, 50)]
score = 0
fscore = score

pygame.display.set_caption("Python")

playing = True

direction = 6
preDirection = 6

state = "start"

hscore=0

f = pygame.font.SysFont('Arial', 40)
while playing:
    
    if score < 15:
        clock.tick(12)

    if score >= 15 and score < 30:
        clock.tick(18)

    if score >= 30 and score < 50:
        clock.tick(25)
        
    if score >= 50:
        clock.tick(40)

    for event in pygame.event.get():

        if event.type == pygame.QUIT:
            playing = False
            
        elif event.type == pygame.KEYDOWN:
            if event.key == pygame.K_SPACE and state == "start":
                state = "play"
            elif event.key == pygame.K_SPACE and state == "dead":
                state = "start"
                head = [600,400]

                bodyPosition = [[600,400],[550,400],[500,400]]
                foodPosition = [random.randrange(50, 1450, 50), random.randrange(50, 700, 50)]
                score = 0
                fscore = score

                pygame.display.set_caption("Python")

                playing = True

                direction = 6
                preDirection = 6

                state = "start"
              
            if event.key == pygame.K_UP and preDirection != 2:
                direction = 8
      
            elif event.key == pygame.K_LEFT and preDirection != 6:
                direction = 4

            elif event.key == pygame.K_RIGHT and preDirection != 4:
                direction = 6

            elif event.key == pygame.K_DOWN and preDirection != 8:
                direction = 2
          
            else:
                direction = direction

    if state == "start":
        screen.blit(grass, (0, 0))
        f=pygame.font.SysFont('agencyfb', 100)
        t=f.render('Python', True, (255, 0, 0), (0, 255, 0))
        screen.blit(t, (600, 150))
        f=pygame.font.SysFont('Arial', 60)
        t=f.render('Press Space to start!', True, (255, 0, 0), (0, 255, 0))
        screen.blit(t, (400, 300))
        t=f.render('Use the Arrow Keys to control the Python!', True, (255, 0, 0), (0, 255, 0))
        screen.blit(t, (250, 400))
        t=f.render('Speed will increase at scores: 15, 30, and 50!', True, (255, 0, 0), (0, 255, 0))
        screen.blit(t, (200, 500))
        t=f.render('Catch as many mice as possible without crashing!', True, (255, 0, 0), (0, 255, 0))
        screen.blit(t, (200, 600))
    elif state == "play":
        screen.blit(grass, (0, 0))

        Food(foodPosition)
            
        snake(bodyPosition)
        
        addBody(head, bodyPosition, foodPosition, direction, score)

        preDirection = direction

        hitSnakeBody(bodyPosition)

        if (hitSnakeBody(bodyPosition) == True):
            state = "dead"
            
        hitBorder(head)
        
        if (hitBorder(head) == True):
            state = "dead"
            
        finalScore(fscore, score, hitBorder, hitSnakeBody)
            
        clock.tick(60)

        pygame.display.flip()
        
        if (head[0] == foodPosition[0] or head[0] == foodPosition[0] - 50) and head[1] == foodPosition[1]:
            print("Yum")
            foodPosition = [random.randrange(50, 1450, 50), random.randrange(50, 700, 50)]
            bodyPosition.insert(0,list(head))
            score += 1
            print (score)
        t=f.render('Score: '+str(score), True, (0, 0, 255))
        screen.blit(t, (10,10))
        if score>hscore:
            hscore=score
        else:
            hscore=hscore
        f = pygame.font.SysFont('Arial', 30)
        t=f.render('Highscore: '+str(hscore), True, (0, 0, 255))
        screen.blit(t, (10,50))
    elif state == "dead":
        screen.blit(grass, (0, 0))
        f=pygame.font.SysFont('Arial', 60)
        t=f.render('Your score was: '+str(score), True, (255, 0, 0), (0, 255, 0))
        screen.blit(t, (400, 400))
        t=f.render('Press Space to restart!', True, (255, 0, 0), (0, 255, 0))
        screen.blit(t, (400, 500))
        if score>hscore:
            hscore=score
        else:
            hscore=hscore
        t=f.render('Highscore: '+str(hscore), True, (255, 0, 0), (0, 255, 0))
        screen.blit(t, (400, 300))
        
    pygame.display.update()
print("Your score was:", score)
f=pygame.font.SysFont('Arial', 60)
t=f.render('Press Space to restart!', True, (255, 0, 0), (0, 255, 0))
screen.blit(t, (400, 500))
pygame.display.update()
pygame.quit()


##Citation
##TheAILearner. “TheAILearner/Snake-Game-with-Pygame.” GitHub, GitHub, 2019, github.com/TheAILearner/Snake-Game-with-Pygame/blob/master/snake%20game%20with%20pygame.ipynb.
