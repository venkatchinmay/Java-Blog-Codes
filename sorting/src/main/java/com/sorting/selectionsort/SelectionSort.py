
def issortingrequired(elementfromlowerindex,elementfromheigherindex):
    return elementfromlowerindex > elementfromheigherindex;

def swappingtheelements(elements, fromindex,toindex):
    temp = elements[fromindex]
    elements[fromindex] = elements[toindex]
    elements[toindex] = temp


def printingtheelements(elements):
    for element in range(0,len(elements)):
        print(elements[element])


def selectionsort(elements):
    position = 0;
    for i in range(0,len(elements)):
        position = i
        for j in range(position+1,len(elements)):
            if(issortingrequired(elements[position],elements[j])):
                position = j;
        swappingtheelements(elements,i,position) 
    return elements;    

if __name__ == "__main__":
    elements = [ 5, 1, 4, 2, 8 ]
    listofelements = selectionsort(elements) 
    printingtheelements(listofelements)             


