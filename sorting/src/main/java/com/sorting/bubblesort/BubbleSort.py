
def swappingoftwonumbers(list,fromindex,toindex):
    temp = list[fromindex]
    list[fromindex] = list[toindex]
    list[toindex] = temp

def isswappingrequired(fromelement,toelement):
    return fromelement > toelement

def bubblesort(listofelements):
   for i in range(0, len(listofelements) , 1):
       position = 0
       for j in range(1,len(listofelements)):
           if isswappingrequired(listofelements[position],listofelements[j]):
               swappingoftwonumbers(listofelements,position,j)
           position=j
   printingofelements(listofelements)        
   return listofelements      

def printingofelements(listofelements):
    for element in listofelements:
        print(element)

if __name__ == "__main__":
    elements = [ 5, 1, 4, 2, 8 ]
    listofelements = bubblesort(elements) 
    printingofelements(listofelements)        
