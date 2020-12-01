def issortingrequired(elementfromlowerindex,elementfromheigherindex):
    return elementfromlowerindex > elementfromheigherindex;


def swappingtheelements(elements,fromindex,toindex):
    temp = elements[fromindex]
    elements[fromindex] = elements[toindex]
    elements[toindex] = temp


def printingtheelements(elements):
    for element in range(0,len(elements)):
        print(elements[element])


def insertionsorting(elements):
    position = 0
    for i in range(0,len(elements)-1):
       position=i
       for position in range(position,-1,-1): 
        if(issortingrequired(elements[position],elements[position+1])):
            swappingtheelements(elements,position,position+1)
    return elements

if __name__ == "__main__":
    elements = [ 5, 1, 4, 8, 2 ]
    listofelements = insertionsorting(elements) 
    printingtheelements(listofelements)                